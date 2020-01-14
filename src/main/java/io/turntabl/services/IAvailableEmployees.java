package io.turntabl.services;

import io.turntabl.models.Employee;

import java.time.LocalDate;
import java.util.List;

public interface IAvailableEmployees {
    List<Employee> getAllAvailableEmployees(LocalDate projectStartDate, LocalDate projectEndDate);
}
