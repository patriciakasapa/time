package com.example.time.services;

import com.example.time.models.Employee;
import java.util.Date;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllAvailableEmployees(Date projectStartDate, Date projectEndDate);
}
