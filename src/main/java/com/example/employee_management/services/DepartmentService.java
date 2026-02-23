package com.example.employee_management.services;

import com.example.employee_management.DTOs.createDepartmentRequest;
import com.example.employee_management.models.Department;
import com.example.employee_management.models.Employee;
import com.example.employee_management.repositories.DepartmentRepo;
import com.example.employee_management.shared.CustomResponseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    DepartmentRepo repo;
    public DepartmentService(DepartmentRepo repo) {
        this.repo = repo;
    }

    public Department getOneDepartment(Long departmentId) {
        Department department = repo.findById(departmentId).orElseThrow(() -> CustomResponseException.ResourceNotFound("Department not found"));
        return department;
    }

    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    public Department createDepartment(createDepartmentRequest request) {
        Department department = new Department();
        department.setName(request.getName());
        repo.save(department);
        return department;
    }

    public void deleteDepartment(Long departmentId) {
        Department department = repo.findById(departmentId).orElseThrow(() -> CustomResponseException.ResourceNotFound("Department not found"));
        repo.delete(department);
    }
}
