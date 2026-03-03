package com.example.employee_management.services;

import com.example.employee_management.DTOs.SignupRequest;
import com.example.employee_management.models.Employee;
import com.example.employee_management.models.UserAccount;
import com.example.employee_management.repositories.EmployeeRepo;
import com.example.employee_management.repositories.UserAccountRepo;
import com.example.employee_management.shared.CustomResponseException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UserAccountRepo repo;
    private EmployeeRepo empRepo;
    private PasswordEncoder passwordEncoder;
    public AuthService(UserAccountRepo repo, EmployeeRepo empRepo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.empRepo = empRepo;
    }


    public void signup(SignupRequest request) {
        Employee employee = empRepo.findById(request.getEmployeeId())
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "employee not found"
                ));
        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmployee(employee);

        repo.save(user);
    }


}
