package com.md.utm.service;

import com.md.utm.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    Employee fetchEmployeeById(Integer employeeId);

    void deleteEmployeeById(Integer employeeId);

    void updateEmployeeEmailById(String newEmail, Integer employeeId);

    List<Employee> getAllEmployeesInfo();

}
