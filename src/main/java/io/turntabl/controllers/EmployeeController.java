package io.turntabl.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.models.Employee;
import io.turntabl.services.AvailableEmployeesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Api
@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private AvailableEmployeesImpl employeeService;

    @ApiOperation("get all availableEmployees")
    @GetMapping(value = "v1/api//availableEmployees", produces = "application/json")
    public List<Employee> getAllAvailableEmployees(
            @RequestParam("startDate") String projectStartDate,
            @RequestParam("endDate") String projectEndDate
    ){
        LocalDate start = LocalDate.parse(projectStartDate);
        LocalDate end = LocalDate.parse(projectEndDate);
        System.out.println(start + "\t<>\t" +  end);
        if ( start.isAfter(end)){
            return new ArrayList<>();
        }else {
            return employeeService.getAllAvailableEmployees(start, end);
        }
    }
}
