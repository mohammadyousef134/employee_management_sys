package com.example.employee_management.controllers;

import com.example.employee_management.DTOs.createDepartmentRequest;
import com.example.employee_management.models.Department;
import com.example.employee_management.services.DepartmentService;
import com.example.employee_management.shared.GlobalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    DepartmentService service;
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Department>>> getAllDepartments() {
        return new ResponseEntity<>(new GlobalResponse<>(service.getAllDepartments()), HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<GlobalResponse<Department>> getDepartment(@PathVariable Long departmentId) {
        return new ResponseEntity<>(new GlobalResponse<>(service.getOneDepartment(departmentId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Department>> createDepartment(@RequestBody createDepartmentRequest request) {
        return new ResponseEntity<>(new GlobalResponse<>(service.createDepartment(request)), HttpStatus.CREATED);
    }

    @DeleteMapping("{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long departmentId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
