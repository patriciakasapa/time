package com.example.time.services;

import com.example.time.Employee;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllAvailableEmployees();
}
