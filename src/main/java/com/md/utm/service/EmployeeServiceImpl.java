package com.md.utm.service;

import com.md.utm.dao.EmployeeDao;
import com.md.utm.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    //@Qualifier("employeeDAOImpl")
    private EmployeeDao employeeDao;

//    public void setEmployeeDao(EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }


    @Override
    public void addEmployee(Employee employee) {
        employeeDao.createEmployee(employee);
    }

    @Override
    public Employee fetchEmployeeById(Integer employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        employeeDao.deleteEmployeeById(employeeId);
    }

    @Override
    public void updateEmployeeEmailById(String newEmail, Integer employeeId) {
        employeeDao.updateEmployeeEmail(employeeId, newEmail);
    }

    @Override
    public List<Employee> getAllEmployeesInfo() {
        return employeeDao.getAllEmployeeDetails();
    }
}
