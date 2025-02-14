package com.kerem.authservice.service;

import com.kerem.authservice.dao.UserRepository;
import com.kerem.authservice.dto.user.request.UserLoginDTO;
import com.kerem.authservice.dto.user.request.UserRegisterDTO;
import com.kerem.authservice.dto.user.response.AuthResponseDTO;
import com.kerem.authservice.entity.Role;
import com.kerem.authservice.entity.User;
import com.kerem.authservice.exception.abstracts.CommonErrorCodes;
import com.kerem.authservice.exception.specific.GenericException;
import com.kerem.authservice.service.abstracts.AuthService;
import com.kerem.authservice.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleServiceImpl roleService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    public AuthServiceImpl(UserRepository userRepository, RoleServiceImpl roleService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponseDTO register(UserRegisterDTO registerRequest) {
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new GenericException(CommonErrorCodes.USER_ALREADY_EXISTS);
        }

        Role role = roleService.getRoleByName(registerRequest.getRoleName());
        User newUser = new User();

        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setRole(role);
        userRepository.save(newUser);
        String token = jwtUtil.generateToken(newUser.getEmail());
        return new AuthResponseDTO(token,registerRequest.getEmail(),role.getName());
    }

    @Override
    public AuthResponseDTO login(UserLoginDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new GenericException(CommonErrorCodes.USER_NOT_FOUND));

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponseDTO(token,user.getEmail(),user.getRole().getName());
    }

    @Override
    public AuthResponseDTO logout(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            throw new GenericException(CommonErrorCodes.INVALID_TOKEN);
        }
        token = token.split(" ")[1];
        String email = jwtUtil.getEmailFromToken(token);


        SecurityContextHolder.clearContext();
        return new AuthResponseDTO(token,email,getUserByEmail(email).getRole().getName());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new GenericException(CommonErrorCodes.USER_NOT_FOUND));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new GenericException(CommonErrorCodes.USER_NOT_FOUND));
    }

}
