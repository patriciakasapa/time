package io.turntabl.services;

import io.turntabl.models.Employee;
import io.turntabl.models.Leave;
import io.turntabl.models.Project;
import io.turntabl.utils.Common;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.*;
import java.text.ParseException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AvailableEmployeesImpl implements IAvailableEmployees {
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public List<Employee> getAllAvailableEmployees(Date projectStartDate, Date projectEndDate) {
        // http request
        List<Employee> employees = getAllEmployees();

        // filter out unavailable employees
        Stream<Employee> employeesReturningFromLeave = employees.stream().filter(Employee::isEmployee_onleave).filter(
                x -> {
                    Optional<Leave> leave = getLeave(Integer.toString(x.getEmployee_id()));
                    return leave.filter(value -> dateIsBefore(projectStartDate, value)).isPresent();
                }
        );
        Stream<Employee> employeesWithNoLeave = employees.stream().filter( x -> !x.isEmployee_onleave());
        Stream<Employee> availableEmployees = Stream.concat(employeesReturningFromLeave, employeesWithNoLeave);

        // filter out old projects && fit
        Stream<Employee> employeeStream = availableEmployees.filter(x -> {
            List<Project> projects = x.getProjects();
            List<Project> projectBacklog = projects.stream().filter(project -> Objects.requireNonNull(Common.toDate(project.getProject_end_date())).after(projectStartDate)).collect(Collectors.toList());
           // x.setProjects(projectBacklog);
            return fitEmployee(projectBacklog, projectStartDate, projectEndDate);
        });

        // return the list of employees
        return employeeStream.collect(Collectors.toList());
    }

    private boolean fitEmployee(List<Project> projects, Date projectStartDate, Date projectEndDate) {

        if ( projects.size() == 0) { return true; }
        for (int i = 0; i < projects.size(); i ++){
            if (
                    projectStartDate.equals(Objects.requireNonNull(Common.toDate(projects.get(i).getProject_end_date()))) ||
                    projectStartDate.after(Objects.requireNonNull(Common.toDate(projects.get(i).getProject_end_date())))
            ){
                System.out.println(projects.get(i));
                if ( i == projects.size() - 1) { return true; }

                else if (
                        projectEndDate.equals(Objects.requireNonNull(Common.toDate(projects.get(i+1).getProject_start_date()))) ||
                        projectEndDate.before(Objects.requireNonNull(Common.toDate(projects.get(i+1).getProject_start_date())))
                    ){
                        return true;
                    }
            }
        }

        return false;
    }

    private boolean dateIsBefore(Date projectStartDate, Leave leave) {
        boolean isBefore =  false;
        try {
            Date leaveEndDate = DATE_FORMAT.parse(leave.getEndDate());
            isBefore = leaveEndDate.before(projectStartDate);
        } catch (ParseException e) {  e.printStackTrace();  }
        return isBefore;
    }


    private List<Employee> getAllEmployees() {
        List<Employee> employee = new ArrayList<>();
        try {
            for (JsonNode next : OBJECT_MAPPER.readTree(new URL("https://ttmsdeveloperprofile.herokuapp.com/employees"))) {
                Employee emp = new Employee();
                emp.setEmployee_id(next.get("employee_id").asInt());
                emp.setEmployee_firstname(next.get("employee_firstname").asText());
                emp.setEmployee_lastname(next.get("employee_lastname").asText());
                emp.setEmployee_onleave(next.get("employee_onleave").asBoolean());
                emp.setEmployee_hire_date(next.get("employee_hire_date").asText());
                emp.setEmployee_address(next.get("employee_address").asText());
                emp.setEmployee_email(next.get("employee_email").asText());
                emp.setEmployee_dev_level(next.get("employee_gender").asText());
                emp.setEmployee_gender(next.get("employee_id").asText());
                emp.setEmployee_phonenumber(next.get("employee_phonenumber").asText());
                List<String> tech_stack = new ArrayList<>();
                for (JsonNode tech: next.get("tech_stack")){
                    tech_stack.add(tech.asText());
                }
                emp.setTech_stack( tech_stack);

                List<Project> projects = new ArrayList<>();
                for (JsonNode tech: next.get("projects")){
                    projects.add(OBJECT_MAPPER.readValue(tech.toPrettyString(), Project.class));
                }
                emp.setProjects( projects);
                employee.add(emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employee;
    }

    private Optional<Leave> getLeave(String employeeId) {
        try {
            Leave leave = OBJECT_MAPPER.readValue(new URL("https://ttmsdeveloperprofile.herokuapp.com/leave/" + employeeId), Leave.class);
            if (leave.getId() == null){ return Optional.empty(); }
            return Optional.of(leave);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
