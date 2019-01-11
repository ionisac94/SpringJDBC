package com.md.utm.main;

import com.md.utm.model.Employee;
import com.md.utm.service.EmployeeService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        AbstractApplicationContext abstractApplicationContext = new ClassPathXmlApplicationContext("aplicationContext.xml");

        EmployeeService employeeService = abstractApplicationContext.getBean("employeeService", EmployeeService.class);

//
//        Employee employee = new Employee();
//
//        employee.setEmployeeName("Ionel");
//        employee.setEmail("ion.isac94@gmail.com");
//
//        employee.setSalary(258);
//        employee.setGender("male");

        //   employeeService.addEmployee(employee);


//        Employee employee1 = employeeService.fetchEmployeeById(1);
//        System.out.println(employee1);


//        List<Employee> allEmployeesInfo = employeeService.getAllEmployeesInfo();
//
//        allEmployeesInfo.forEach(System.out::println);



//        employeeService.deleteEmployeeById(1);


        employeeService.updateEmployeeEmailById("new@gmail.com",3);


        abstractApplicationContext.close();
    }
}
