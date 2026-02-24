package com.example.employee_management.DTOs;

import com.example.employee_management.models.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class createLeaveRequest {

    @NotNull(message = "Start Date is required")
    @FutureOrPresent(message = "start date cannot be in the past")
    private LocalDate startDate;

    @NotNull(message = "End Date is required")
    @FutureOrPresent(message = "end date cannot be in the past")
    private LocalDate endDate;

    @NotNull(message = "Reason is required")
    private String reason;


}
