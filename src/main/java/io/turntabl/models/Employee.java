package io.turntabl.models;

import java.time.LocalDate;

public class Employee {
    private Integer employee_id;
    private String employee_firstname;
    private String employee_lastname;
    private String employee_phonenumber;
    private String employee_email;
    private String employee_address;
    private String employee_dev_level;
    private String employee_gender;
    private String employee_role;
    private String employee_status;
    private Boolean employee_onleave;
    private LocalDate employee_hire_date;


    public Employee() {
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
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

    public String getEmployee_role() {
        return employee_role;
    }

    public void setEmployee_role(String employee_role) {
        this.employee_role = employee_role;
    }

    public String getEmployee_status() {
        return employee_status;
    }

    public void setEmployee_status(String employee_status) {
        this.employee_status = employee_status;
    }

    public Boolean getEmployee_onleave() {
        return employee_onleave;
    }

    public void setEmployee_onleave(Boolean employee_onleave) {
        this.employee_onleave = employee_onleave;
    }

    public LocalDate getEmployee_hire_date() {
        return employee_hire_date;
    }

    public void setEmployee_hire_date(LocalDate employee_hire_date) {
        this.employee_hire_date = employee_hire_date;
    }
}