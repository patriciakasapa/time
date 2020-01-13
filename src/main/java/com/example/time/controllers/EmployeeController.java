package com.example.time.controllers;

import com.example.time.models.Employee;
import com.example.time.serviceImplementors.EmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Api
@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private EmployeeServiceImpl employeeService;

    @ApiOperation("get all availableEmployees")
    @GetMapping(value = "/availableEmployees/{projectStartDate}/{projectEndDate}", produces = "application/json")
    public List<Employee> getAllAvailableEmployees(
            @PathVariable("projectStartDate") String projectStartDate,
            @PathVariable("projectEndDate") String projectEndDate
    ){
         try {
            Date start = DATE_FORMAT.parse(projectStartDate);
            Date end = DATE_FORMAT.parse(projectEndDate);
             System.out.println(start);
             System.out.println(end);
            return employeeService.getAllAvailableEmployees(start, end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
