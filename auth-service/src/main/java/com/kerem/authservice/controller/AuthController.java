package com.kerem.authservice.controller;


import com.kerem.authservice.dto.user.request.UserRegisterDTO;
import com.kerem.authservice.dto.user.response.AuthResponseDTO;
import com.kerem.authservice.service.abstracts.AuthService;
import com.kerem.authservice.dto.user.request.UserLoginDTO;
import com.kerem.authservice.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody UserRegisterDTO request) {

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody UserLoginDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<AuthResponseDTO> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        return ResponseEntity.ok(authService.logout(token));
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return authService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable UUID id) {
        return authService.getUserById(id);
    }
    @GetMapping("/user/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return authService.getUserByEmail(email);
    }

}
