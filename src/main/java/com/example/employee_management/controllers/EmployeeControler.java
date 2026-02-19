package com.example.employee_management.controllers;

import com.example.employee_management.DTOs.createEmployeeRequest;
import com.example.employee_management.DTOs.updateEmployeeRequest;
import com.example.employee_management.models.Employee;
import com.example.employee_management.services.EmployeeService;
import com.example.employee_management.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeControler {
    EmployeeService service;
    public EmployeeControler(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Employee>>> getAllEmployees() {
        return new ResponseEntity<>(new GlobalResponse<>(service.getAllEmployees()), HttpStatus.OK);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>>getEmployee(@PathVariable long employeeId) {
        Employee employee = service.getOneEmployee(employeeId);
        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Employee>>createEmployee(@RequestBody @Valid createEmployeeRequest request) {
        Employee employee = service.createEmployee(request);
        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.CREATED);
    }

    @DeleteMapping ("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long employeeId) {
        service.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping ("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> updateEmployee(@PathVariable long employeeId, @RequestBody @Valid updateEmployeeRequest request) {
        return new ResponseEntity<>(new GlobalResponse<>(service.updateEmployee(employeeId, request)), HttpStatus.OK);
    }
}
