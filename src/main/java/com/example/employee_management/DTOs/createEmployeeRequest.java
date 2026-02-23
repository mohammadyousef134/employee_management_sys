package com.example.employee_management.DTOs;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class createEmployeeRequest {

    @NotNull(message = "first name in required")
    @Size(min = 2, max = 100, message = "min is 2 characters and max is 100 characters")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 2, max = 100, message = "min is 2 characters and max is 100 characters")
    private String lastName;

    @NotNull(message = "hire date is required")
    @PastOrPresent(message = "hire date cannot be in the future")
    private LocalDate hireDate;

    @NotNull(message = "Phone number is required")
    private String phoneNumber;

    @NotNull(message = "Email is required")
    @Email(message = "invalid email format")
    private String email;

    @NotNull(message = "Postion is required")
    @Size(min = 2, max = 50, message = "min is 2 characters and max is 50 characters")
    private String position;

    @NotNull(message = "HERE")
    private Long departmentId;

}
