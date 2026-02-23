package com.example.employee_management.services;

import com.example.employee_management.DTOs.createEmployeeRequest;
import com.example.employee_management.DTOs.updateEmployeeRequest;
import com.example.employee_management.models.Department;
import com.example.employee_management.models.Employee;
import com.example.employee_management.repositories.DepartmentRepo;
import com.example.employee_management.repositories.EmployeeRepo;
import com.example.employee_management.shared.CustomResponseException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    EmployeeRepo repo;
    DepartmentRepo depRepo;
    public EmployeeService(EmployeeRepo repo, DepartmentRepo depRepo) {
        this.repo = repo;
        this.depRepo = depRepo;
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
        Department department = depRepo.findById(request.getDepartmentId())
                        .orElseThrow(() -> CustomResponseException.ResourceNotFound("DepartmentId not found"));
        Employee employee = new Employee();
        employee.setEmail(request.getEmail());
        employee.setPosition(request.getPosition());
        employee.setHireDate(request.getHireDate());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setDepartment(department);


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
