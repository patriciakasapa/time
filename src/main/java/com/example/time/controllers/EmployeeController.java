package com.example.time.controllers;

import com.example.time.Employee;
import com.example.time.serviceImplementors.EmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ApiOperation("get all availableEmployees")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping({"/availableEmployees", "/"})
    public List<Employee> getAllAvailableEmployees() {
        return employeeService.getAllAvailableEmployees();
    }
}
