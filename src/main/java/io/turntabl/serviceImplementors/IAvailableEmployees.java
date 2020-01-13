package io.turntabl.serviceImplementors;

import io.turntabl.models.Employee;
import java.util.Date;
import java.util.List;

public interface IAvailableEmployees {
    List<Employee> getAllAvailableEmployees(Date projectStartDate, Date projectEndDate);
}
