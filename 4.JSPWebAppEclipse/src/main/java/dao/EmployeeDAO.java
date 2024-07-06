package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import util.DBUtil;

/**
 *
 * @author Shabab-1281539
 */
public class EmployeeDAO {

    private static DBUtil dBUtil = new DBUtil();
    private static PreparedStatement ps;
    private static Connection connection;

    public static int saveEmployee(Employee employee) {
        int result = 0;
        try {
            String sql = "insert into employee(name, email, address) values(?, ?, ?);";

            connection = dBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getAddress());

            result = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Employee> employeeList() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            String sql = "select * from employee;";

            connection = dBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address")
                );
                employeeList.add(employee);
            }

            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static int deleteEmployee(Employee employee) {
        int result = 0;
        try {
            String sql = "delete from employee where id = ?;";

            connection = dBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setLong(1, employee.getId());

            result = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Employee getEmployeeById(Long employeeId) {
        Employee dbEmployee = new Employee();
        try {
            String sql = "select * from employee where id = ?;";

            connection = dBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setLong(1, employeeId);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                dbEmployee = new Employee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address")
                );
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbEmployee;
    }

    public static int updateEmployee(Employee employee) {
        int result = 0;
        try {
            String sql = "update employee set name = ?, email = ?, address = ? where id = ?;";

            connection = dBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getAddress());
            ps.setLong(4, employee.getId());

            result = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
