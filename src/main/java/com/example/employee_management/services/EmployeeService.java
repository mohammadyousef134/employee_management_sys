package com.example.employee_management.services;

import com.example.employee_management.DTOs.createEmployeeRequest;
import com.example.employee_management.DTOs.updateEmployeeRequest;
import com.example.employee_management.models.Employee;
import com.example.employee_management.repositories.EmployeeRepo;
import com.example.employee_management.shared.CustomResponseException;
import com.example.employee_management.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepo repo;
    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getOneEmployee(Long employeeId) {
        Employee employee = repo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Employee with id " + employeeId + " not found"));
        return employee;
    }

    public Employee createEmployee(createEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setEmail(request.getEmail());
        employee.setPosition(request.getPosition());
        employee.setHireDate(request.getHireDate());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setPhoneNumber(request.getPhoneNumber());

        repo.save(employee);
        return employee;
    }

    public void deleteEmployee(Long employeeId) {
        repo.deleteById(employeeId);
    }

    public Employee updateEmployee(Long employeeId, updateEmployeeRequest request) {
        Employee employee = repo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee with id " + employeeId + " not found"
                ));
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setPosition(request.getPosition());
        employee.setPhoneNumber(request.getPhoneNumber());

        repo.save(employee);
        return employee;
    }
}
