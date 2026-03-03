package com.example.employee_management.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class LoginRequest {
    @NotNull(message = "username is required")
    private String username;

    @NotNull(message = "password is required")
    private String password;

}
