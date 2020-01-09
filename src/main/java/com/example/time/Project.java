package com.example.time;

import java.time.LocalDateTime;

public class Project
{
    private String project_id;

    private String project_name;

    private String project_description;

    private LocalDateTime project_start_date;

    private LocalDateTime project_end_date;

    public String getProject_description ()
    {
        return project_description;
    }

    public void setProject_description (String project_description)
    {
        this.project_description = project_description;
    }

    public String getProject_id ()
    {
        return project_id;
    }

    public void setProject_id (String project_id)
    {
        this.project_id = project_id;
    }

    public String getProject_name ()
    {
        return project_name;
    }

    public void setProject_name (String project_name)
    {
        this.project_name = project_name;
    }

    public LocalDateTime getProject_start_date ()
    {
        return project_start_date;
    }

    public void setProject_start_date (LocalDateTime project_start_date)
    {
        this.project_start_date = project_start_date;
    }

    public LocalDateTime getProject_end_date ()
    {
        return project_end_date;
    }

    public void setProject_end_date (LocalDateTime project_end_date)
    {
        this.project_end_date = project_end_date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [project_description = "+project_description+", project_id = "+project_id+", project_name = "+project_name+", project_start_date = "+project_start_date+", project_end_date = "+project_end_date+"]";
    }
}