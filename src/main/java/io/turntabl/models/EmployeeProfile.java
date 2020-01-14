package io.turntabl.models;

import java.util.List;

public class EmployeeProfile {
    private Employee employee;
    private List<Tech> tech_stack;
    private List<Project> projects;

    public EmployeeProfile() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Tech> getTech_stack() {
        return tech_stack;
    }

    public void setTech_stack(List<Tech> tech_stack) {
        this.tech_stack = tech_stack;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
