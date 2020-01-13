package io.turntabl.controllers;

import io.turntabl.models.Employee;
import io.turntabl.services.AvailableEmployeesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api
@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private AvailableEmployeesImpl employeeService;

    @ApiOperation("get all availableEmployees")
    @GetMapping(value = "v1/api//availableEmployees", produces = "application/json")
    public List<Employee> getAllAvailableEmployees(
            @RequestParam("startDate") String projectStartDate,
            @RequestParam("endDate") String projectEndDate
    ){
         try {
            Date start = DATE_FORMAT.parse(projectStartDate);
            Date end = DATE_FORMAT.parse(projectEndDate);
            if ( start.after(end)){
                return new ArrayList<>();
            }
            return employeeService.getAllAvailableEmployees(start, end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
