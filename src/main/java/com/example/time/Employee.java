package com.example.time;

public class Employee
{
    private String employee_id;

    private String employee_lastname;

    private String employee_firstname;

    private String employee_phonenumber;

    private String employee_email;

    private String employee_gender;

    private String employee_address;

    private String employee_dev_level;

    private String[] tech_stack;

    private String employee_onleave;

    private String employee_hire_date;

    private Project[] project;

    public String getEmployee_phonenumber ()
    {
        return employee_phonenumber;
    }

    public void setEmployee_phonenumber (String employee_phonenumber)
    {
        this.employee_phonenumber = employee_phonenumber;
    }

    public String getEmployee_email ()
    {
        return employee_email;
    }

    public void setEmployee_email (String employee_email)
    {
        this.employee_email = employee_email;
    }

    public String getEmployee_gender ()
    {
        return employee_gender;
    }

    public void setEmployee_gender (String employee_gender)
    {
        this.employee_gender = employee_gender;
    }

    public String getEmployee_address ()
    {
        return employee_address;
    }

    public void setEmployee_address (String employee_address)
    {
        this.employee_address = employee_address;
    }

    public String getEmployee_dev_level ()
    {
        return employee_dev_level;
    }

    public void setEmployee_dev_level (String employee_dev_level)
    {
        this.employee_dev_level = employee_dev_level;
    }

    public String[] getTech_stack ()
    {
        return tech_stack;
    }

    public void setTech_stack (String[] tech_stack)
    {
        this.tech_stack = tech_stack;
    }

    public String getEmployee_id ()
    {
        return employee_id;
    }

    public void setEmployee_id (String employee_id)
    {
        this.employee_id = employee_id;
    }

    public String getEmployee_hire_date ()
    {
        return employee_hire_date;
    }

    public void setEmployee_hire_date (String employee_hire_date)
    {
        this.employee_hire_date = employee_hire_date;
    }

    public Project[] getProject ()
    {
        return project;
    }

    public void setProject (Project[] project)
    {
        this.project = project;
    }

    public String getEmployee_lastname ()
    {
        return employee_lastname;
    }

    public void setEmployee_lastname (String employee_lastname)
    {
        this.employee_lastname = employee_lastname;
    }

    public String getEmployee_firstname ()
    {
        return employee_firstname;
    }

    public void setEmployee_firstname (String employee_firstname)
    {
        this.employee_firstname = employee_firstname;
    }

    public String getEmployee_onleave ()
    {
        return employee_onleave;
    }

    public void setEmployee_onleave (String employee_onleave)
    {
        this.employee_onleave = employee_onleave;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [employee_phonenumber = "+employee_phonenumber+", employee_email = "+employee_email+", employee_gender = "+employee_gender+", employee_address = "+employee_address+", employee_dev_level = "+employee_dev_level+", tech_stack = "+tech_stack+", employee_id = "+employee_id+", employee_hire_date = "+employee_hire_date+", project = "+project+", employee_lastname = "+employee_lastname+", employee_firstname = "+employee_firstname+", employee_onleave = "+employee_onleave+"]";
    }
}
