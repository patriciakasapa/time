package io.turntabl.services;

import io.turntabl.models.Employee;
import io.turntabl.models.Leave;
import io.turntabl.models.Project;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;

public class AvailableEmployeesImpl implements IAvailableEmployees {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public List<Employee> getAllAvailableEmployees(LocalDate projectStartDate, LocalDate projectEndDate) {
        // http request
        List<Employee> employees = getAllEmployees();

        // filter out unavailable employees
       /* Stream<Employee> employeesReturningFromLeave = employees.stream().filter(Employee::isEmployee_onleave).filter(
                x -> {
                    Optional<Leave> leave = getLeave(Integer.toString(x.getEmployee_id()));
                    return leave.filter(value -> dateIsBefore(projectStartDate, value)).isPresent();
                }
        );
        Stream<Employee> employeesWithNoLeave = employees.stream().filter( x -> !x.isEmployee_onleave());
        Stream<Employee> availableEmployees = Stream.concat(employeesReturningFromLeave, employeesWithNoLeave);*/

        Stream<Employee> employeeStream = employees.stream()
                                                .filter( employee -> {
                                                    System.out.println( employee);
                                                    employee.getProjects().sort(comparing(Project::getProject_start_date));
                                                    List<Project> projectList = employee.getProjects().stream().filter(x -> x.getProject_end_date().isAfter(LocalDate.now())).collect(Collectors.toList());
                                                    employee.setProjects(projectList);
                                                    return fitEmployee(projectList, projectStartDate, projectEndDate );
                                                });

        // return the list of employees
        return employeeStream.collect(Collectors.toList());
    }

    private boolean fitEmployee(List<Project> projects, LocalDate projectStartDate, LocalDate projectEndDate) {
        if (projects.size() == 0) {
            return true;
        }
        if ( projects.size() == 1 ){
            return ( projectStartDate.isAfter(projects.get(0).getProject_end_date()) ||
                        projectEndDate.isBefore(projects.get(0).getProject_start_date()) );
        }
        for (int i = 0; i < projects.size(); i++) {

            if ( i == projects.size() - 1){
                return ( projectStartDate.isAfter(projects.get(0).getProject_end_date()) ||
                        projectEndDate.isBefore(projects.get(0).getProject_start_date()));
            }
            else if ( projects.get(i ).getProject_start_date().isAfter(projectEndDate) ){ return true; }
            else if ( projects.get(i ).getProject_end_date().isBefore(projectStartDate)){
                if ( projects.get(i + 1).getProject_start_date().isAfter(projectEndDate)) { return true; }
                // else if ( projects.get(i + 1).getProject_end_date().isBefore(projectStartDate)){ return true; }
            }
        }
        return false;
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
                emp.setEmployee_hire_date(LocalDate.parse(next.get("employee_hire_date").asText()));
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
                    Project proj = new Project();
                    proj.setProject_id(tech.get("project_id").asInt());
                    proj.setProject_description(tech.get("project_description").asText());
                    proj.setProject_name(tech.get("project_name").asText());
                    proj.setProject_start_date(LocalDate.parse(tech.get("project_start_date").asText()));
                    proj.setProject_end_date(LocalDate.parse(tech.get("project_end_date").asText()));
                    projects.add(proj);
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
