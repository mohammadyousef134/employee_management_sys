package com.example.employee_management.services;

import com.example.employee_management.DTOs.createLeaveRequest;
import com.example.employee_management.models.Employee;
import com.example.employee_management.models.LeaveRequest;
import com.example.employee_management.repositories.EmployeeRepo;
import com.example.employee_management.repositories.LeaveRequestRepo;
import com.example.employee_management.shared.CustomResponseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {
    LeaveRequestRepo repo;
    EmployeeRepo empRepo;
    public LeaveRequestService(LeaveRequestRepo repo, EmployeeRepo empRepo) {
        this.repo = repo;
        this.empRepo = empRepo;
    }

    public LeaveRequest createLeaveRequest(createLeaveRequest request, Long employeeId) {
        Employee employee = empRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(
                        "Employee not found"
                ));
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStartDate(request.getStartDate());
        leaveRequest.setEndtDate(request.getEndDate());
        leaveRequest.setReason(request.getReason());
        leaveRequest.setEmployee(employee);
        leaveRequest.setStatus("PENDING");
        repo.save(leaveRequest);
        return leaveRequest;
    }

    public List<LeaveRequest> findAllByEmployeeId(Long employeeId) {
        return repo.findAllByEmployeeId(employeeId);
    }
}
