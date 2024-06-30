package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Student;
import util.DBUtil;

/**
 *
 * @author Shabab-1281539
 */
public class StudentDAO {

    static PreparedStatement ps;
    static ResultSet rs;
    static Connection connection;
    static String sql = "";

    public static int saveStudent(Student student) {
        int result = 0;
        try {
            sql = "insert into student(name, roll, cell, address) values(?, ?, ?, ?);";
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getRoll());
            ps.setString(3, student.getCell());
            ps.setString(4, student.getAddress());

            result = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
