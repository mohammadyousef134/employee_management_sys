package com.example.employee_management.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class updateEmployeeRequest {
    @NotNull(message = "first name in required")
    @Size(min = 2, max = 100, message = "min is 2 characters and max is 100 characters")
    private String firstName;

    @NotNull(message = "Last name in required")
    @Size(min = 2, max = 100, message = "min is 2 characters and max is 100 characters")
    private String lastName;

    @NotNull(message = "Phone number is required")
    private String phoneNumber;

    @NotNull(message = "Postion is required")
    @Size(min = 2, max = 50, message = "min is 2 characters and max is 50 characters")
    private String position;
}
