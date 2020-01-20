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
import java.util.Arrays;
import java.util.List;

@Api
@RestController
public class EmployeeController {

    @Autowired
    private AvailableEmployeesImpl employeeService;

    @ApiOperation("get all availableEmployees")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "v1/api/availableEmployees", produces = "application/json")
    public List<Employee> getAllAvailableEmployees(
            @RequestParam("startDate") String projectStartDate,
            @RequestParam("endDate") String projectEndDate
    ){
        LocalDate start = LocalDate.parse(projectStartDate);
        LocalDate end = LocalDate.parse(projectEndDate);

        Employee defaultEmp = new Employee();
        defaultEmp.setEmployee_address("employee address");
        defaultEmp.setEmployee_email("employee mail");
        defaultEmp.setEmployee_firstname("employee name");
        defaultEmp.setEmployee_gender("emplyee gender");
        defaultEmp.setEmployee_id(1);
        defaultEmp.setEmployee_lastname("employee lastname");
        defaultEmp.setEmployee_phonenumber("1234");

        List<Employee> employees = Arrays.asList(defaultEmp);

        if ( start.isAfter(end)){
            return employees;
        }else {
            return employeeService.getAllAvailableEmployees(start, end);
        }
    }
}
