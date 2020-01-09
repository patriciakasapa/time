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
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Api
@RestController
public class EmployeeController {
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM d, yyyy", Locale.ENGLISH);

    @Autowired
    private EmployeeServiceImpl employeeService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ApiOperation("get all availableEmployees")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping({"/availableEmployees", "/"})
    public List<Employee> getAllAvailableEmployees(
            @PathVariable String projectStartDate,
            @PathVariable String projectEndDate
    ){
        Date leaveStartDate = null;
        Date leaveEndDate = null;
        String sDate2 = "31-Dec-2019";
        try {
            leaveEndDate = DATE_FORMAT.parse(projectEndDate);
            leaveStartDate = DATE_FORMAT.parse(projectStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (leaveEndDate == null && leaveStartDate == null) {
            try {
                leaveEndDate = DATE_FORMAT.parse(sDate2);
                leaveStartDate = DATE_FORMAT.parse(sDate2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return employeeService.getAllAvailableEmployees(leaveStartDate, leaveEndDate);
    }
}
