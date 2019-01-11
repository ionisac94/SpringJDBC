package com.md.utm.dao;

import com.md.utm.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {


    void createEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    List<Employee> getAllEmployeeDetails();

    void deleteEmployeeById(Integer employeeId);

    void updateEmployeeEmail(Integer employeeId, String newEmail);

}
