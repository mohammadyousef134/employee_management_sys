package com.example.employee_management.repositories;

import com.example.employee_management.models.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findAllByEmployeeId(Long employeeId);
}
