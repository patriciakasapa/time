package com.example.time.models;

import com.example.time.models.Project;

import java.util.Date;
import java.util.List;

//public class Employee {
//    private int employee_id;
//    private String employee_firstname;
//    private String employee_lastname;
//    private String employee_phonenumber;
//    private String employee_email;
//    private String employee_address;
//    private String employee_dev_level;
//    private String employee_gender;
//    private Date employee_hire_date;
//    private boolean employee_onleave;
//    private List<String> tech_stack;
//    private List<Project> projects;
//
//    public Employee() {
//    }
//
//    public int getEmployee_id() {
//        return employee_id;
//    }
//
//    public void setEmployee_id(int employee_id) {
//        this.employee_id = employee_id;
//    }
//
//    public String getEmployee_firstname() {
//        return employee_firstname;
//    }
//
//    public void setEmployee_firstname(String employee_firstname) {
//        this.employee_firstname = employee_firstname;
//    }
//
//    public String getEmployee_lastname() {
//        return employee_lastname;
//    }
//
//    public void setEmployee_lastname(String employee_lastname) {
//        this.employee_lastname = employee_lastname;
//    }
//
//    public String getEmployee_phonenumber() {
//        return employee_phonenumber;
//    }
//
//    public void setEmployee_phonenumber(String employee_phonenumber) {
//        this.employee_phonenumber = employee_phonenumber;
//    }
//
//    public String getEmployee_email() {
//        return employee_email;
//    }
//
//    public void setEmployee_email(String employee_email) {
//        this.employee_email = employee_email;
//    }
//
//    public String getEmployee_address() {
//        return employee_address;
//    }
//
//    public void setEmployee_address(String employee_address) {
//        this.employee_address = employee_address;
//    }
//
//    public String getEmployee_dev_level() {
//        return employee_dev_level;
//    }
//
//    public void setEmployee_dev_level(String employee_dev_level) {
//        this.employee_dev_level = employee_dev_level;
//    }
//
//    public String getEmployee_gender() {
//        return employee_gender;
//    }
//
//    public void setEmployee_gender(String employee_gender) {
//        this.employee_gender = employee_gender;
//    }
//
//    public Date getEmployee_hire_date() {
//        return employee_hire_date;
//    }
//
//    public void setEmployee_hire_date(Date employee_hire_date) {
//        this.employee_hire_date = employee_hire_date;
//    }
//
//    public boolean getEmployee_onleave() {
//        return employee_onleave;
//    }
//
//    public void setEmployee_onleave(Boolean employee_onleave) {
//        this.employee_onleave = employee_onleave;
//    }
//
//    public List<String> getTech_stack() {
//        return tech_stack;
//    }
//
//    public void setTech_stack(List<String> tech_stack) {
//        this.tech_stack = tech_stack;
//    }
//
//    public List<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(List<Project> projects) {
//        this.projects = projects;
//    }
//}


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private int employee_id;
    private String employee_firstname;
    private String employee_lastname;
    private String employee_phonenumber;
    private String employee_email;
    private String employee_address;
    private String employee_dev_level;
    private String employee_gender;
    private String employee_hire_date;
    private boolean employee_onleave;
    private List<String> tech_stack;
    private List<Project> projects;



    public Employee() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_firstname() {
        return employee_firstname;
    }

    public void setEmployee_firstname(String employee_firstname) {
        this.employee_firstname = employee_firstname;
    }

    public String getEmployee_lastname() {
        return employee_lastname;
    }

    public void setEmployee_lastname(String employee_lastname) {
        this.employee_lastname = employee_lastname;
    }

    public String getEmployee_phonenumber() {
        return employee_phonenumber;
    }

    public void setEmployee_phonenumber(String employee_phonenumber) {
        this.employee_phonenumber = employee_phonenumber;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public String getEmployee_dev_level() {
        return employee_dev_level;
    }

    public void setEmployee_dev_level(String employee_dev_level) {
        this.employee_dev_level = employee_dev_level;
    }

    public String getEmployee_gender() {
        return employee_gender;
    }

    public void setEmployee_gender(String employee_gender) {
        this.employee_gender = employee_gender;
    }

    public String getEmployee_hire_date() {
        return employee_hire_date;
    }

    public void setEmployee_hire_date(String employee_hire_date) {
        this.employee_hire_date = employee_hire_date;
    }

    public boolean isEmployee_onleave() {
        return employee_onleave;
    }

    public void setEmployee_onleave(boolean employee_onleave) {
        this.employee_onleave = employee_onleave;
    }

    public List<String> getTech_stack() {
        return tech_stack;
    }

    public void setTech_stack(List<String> tech_stack) {
        this.tech_stack = tech_stack;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employee_firstname='" + employee_firstname + '\'' +
                ", employee_lastname='" + employee_lastname + '\'' +
                ", employee_phonenumber='" + employee_phonenumber + '\'' +
                ", employee_email='" + employee_email + '\'' +
                ", employee_address='" + employee_address + '\'' +
                ", employee_dev_level='" + employee_dev_level + '\'' +
                ", employee_gender='" + employee_gender + '\'' +
                ", employee_hire_date='" + employee_hire_date + '\'' +
                ", employee_onleave=" + employee_onleave +
                ", tech_stack=" + tech_stack +
                ", projects=" + projects +
                '}';
    }
}