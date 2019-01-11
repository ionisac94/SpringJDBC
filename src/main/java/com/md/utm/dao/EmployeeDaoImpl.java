package com.md.utm.dao;

import com.md.utm.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    // @Qualifier("dataSource")
    private DataSource dataSource;
//    private JdbcOperations jdbcTemplate;

//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Override
    public void createEmployee(Employee employee) {

        String sql = "INSERT INTO employee VALUES(null,?,?,?,?)";

        try (
                Connection connection = dataSource.getConnection();


                PreparedStatement prepareStatement = connection.prepareStatement(sql);) {

            prepareStatement.execute("DROP  TABLE IF EXISTS employee");

            prepareStatement.executeUpdate("CREATE TABLE IF NOT EXISTS employee (id  INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(255), email VARCHAR(255),gender VARCHAR(255), salary INTEGER, PRIMARY KEY ( id ))");

            prepareStatement.setString(1, employee.getEmployeeName());
            prepareStatement.setString(2, employee.getEmail());
            prepareStatement.setString(3, employee.getGender());
            prepareStatement.setInt(4, employee.getSalary());


            prepareStatement.executeUpdate();

            System.out.println("Employee is created.....");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    @Override
    public Employee getEmployeeById(int employeeId) {


        String sql = "SELECT * from employee where id = ?";
        Employee employee = new Employee();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setInt(1, employeeId);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeName(resultSet.getString(2));
                employee.setEmail(resultSet.getString(3));
                employee.setGender(resultSet.getString(4));
                employee.setSalary(resultSet.getInt(5));
            }

            System.out.println("Employee was selected.....");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;

    }

    @Override
    public List<Employee> getAllEmployeeDetails() {


        String sql = "SELECT * from employee";
        Employee employee = new Employee();
        List<Employee> list = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeName(resultSet.getString(2));
                employee.setEmail(resultSet.getString(3));
                employee.setGender(resultSet.getString(4));
                employee.setSalary(resultSet.getInt(5));

                list.add(employee);
            }
            System.out.println("Employees are selected.....");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {

        String sql = "DELETE FROM employee where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {

            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Employee was deleted successfully");
    }

    @Override
    public void updateEmployeeEmail(Integer employeeId, String newEmail) {

        Employee employee = new Employee();

        employee.setEmail(newEmail);
        employee.setEmployeeId(employeeId);

        String sql = "UPDATE employee set email=? WHERE id=?";
        try
                (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ) {
            preparedStatement.setString(1, employee.getEmail());
            preparedStatement.setInt(2,employee.getEmployeeId() );


            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Sa executat cu succes!!!");
    }
}
