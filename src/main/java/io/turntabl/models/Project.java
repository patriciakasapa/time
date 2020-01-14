package io.turntabl.models;

import java.time.LocalDate;

public class Project {
    private Integer project_id;
    private String project_name;
    private String project_description;
    private String project_status;
    private Boolean isworkingon;
    private LocalDate project_start_date;
    private LocalDate project_end_date;

    public Project() {
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public String getProject_status() {
        return project_status;
    }

    public void setProject_status(String project_status) {
        this.project_status = project_status;
    }

    public Boolean getIsworkingon() {
        return isworkingon;
    }

    public void setIsworkingon(Boolean isworkingon) {
        this.isworkingon = isworkingon;
    }

    public LocalDate getProject_start_date() {
        return project_start_date;
    }

    public void setProject_start_date(LocalDate project_start_date) {
        this.project_start_date = project_start_date;
    }

    public LocalDate getProject_end_date() {
        return project_end_date;
    }

    public void setProject_end_date(LocalDate project_end_date) {
        this.project_end_date = project_end_date;
    }
}