package com.kerem.constructionmanagementservice.client;

import com.kerem.constructionmanagementservice.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "auth-service", url = "http://localhost:8080")
public interface AuthServiceClient {
    @GetMapping("/users/{userId}")
    UserDTO getUserById(@PathVariable("userId") UUID userId);
}
