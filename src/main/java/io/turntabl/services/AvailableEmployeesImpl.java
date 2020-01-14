package io.turntabl.services;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.turntabl.models.*;
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
        // List<Employee> employees = getAllEmployees();

        // filter out unavailable employees
       /* Stream<Employee> employeesReturningFromLeave = employees.stream().filter(Employee::isEmployee_onleave).filter(
                x -> {
                    Optional<Leave> leave = getLeave(Integer.toString(x.getEmployee_id()));
                    return leave.filter(value -> dateIsBefore(projectStartDate, value)).isPresent();
                }
        );
        Stream<Employee> employeesWithNoLeave = employees.stream().filter( x -> !x.isEmployee_onleave());
        Stream<Employee> availableEmployees = Stream.concat(employeesReturningFromLeave, employeesWithNoLeave);*/


       // I'm here
        /*Stream<Employee> employeeStream = employees.stream()
                                                .filter( employee -> {
                                                    System.out.println( employee);
                                                    employee.getProjects().sort(comparing(Project::getProject_start_date));
                                                    List<Project> projectList = employee.getProjects().stream().filter(x -> x.getProject_end_date().isAfter(LocalDate.now())).collect(Collectors.toList());
                                                    employee.setProjects(projectList);
                                                    return fitEmployee(projectList, projectStartDate, projectEndDate );
                                                });

        // return the list of employees
        return employeeStream.collect(Collectors.toList());*/
        return new ArrayList<>();
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

    private List<EmployeeProfile> getAllEmployees() {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());

        List<EmployeeProfile> employeeProfiles = new ArrayList<>();
        try {
            JsonNode jsonNode = OBJECT_MAPPER.readTree(new URL("http://employementprofilingapp-env.snvx8mbkdw.us-east-2.elasticbeanstalk.com/v1/api/employees")).get("data");
            for (JsonNode next : jsonNode) {
                EmployeeProfile employeeProfile = new EmployeeProfile();

                employeeProfile.setEmployee(OBJECT_MAPPER.treeToValue(next.get("employee"), Employee.class));
                employeeProfile.setProjects(Arrays.asList(OBJECT_MAPPER.treeToValue(next.get("projects"), Project[].class)));
                employeeProfile.setTech_stack(Arrays.asList(OBJECT_MAPPER.treeToValue(next.get("tech_stack"), Tech[].class)));

                employeeProfiles.add(employeeProfile);
            }
        } catch (IOException e) { e.printStackTrace(); return new ArrayList<>();}
        return employeeProfiles;
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
