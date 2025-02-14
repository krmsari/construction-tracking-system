package com.kerem.authservice.service.abstracts;

import com.kerem.authservice.dto.user.request.UserLoginDTO;
import com.kerem.authservice.dto.user.request.UserRegisterDTO;
import com.kerem.authservice.dto.user.response.AuthResponseDTO;
import com.kerem.authservice.entity.User;

import java.util.List;
import java.util.UUID;

public interface AuthService {
    AuthResponseDTO register(UserRegisterDTO userRegisterDTO);
    AuthResponseDTO login(UserLoginDTO userRegisterDTO);
    AuthResponseDTO logout(String token);

    List<User> getAllUsers();
    User getUserById(UUID id);
}
