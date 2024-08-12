package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import util.DBUtil;


public class StudentDAO {

    private static DBUtil dBUtil = new DBUtil();
    private static PreparedStatement ps;
    private static Connection connection;

    public static int saveStudent(Student student) {
        int result = 0;
        try {
            String sql = "insert into student(name, email, gender, subject) values(?, ?, ?, ?);";

            connection = dBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getSubject());

            result = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Student> studentList() {
        List<Student> studentList = new ArrayList<>();
        try {
            String sql = "select * from student;";

            connection = dBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getString("subject")
                );
                studentList.add(student);
            }

            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static int deleteStudent(Student student) {
        int result = 0;
        try {
            String sql = "delete from student where id = ?;";

            connection = dBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setLong(1, student.getId());

            result = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Student getStudentById(Long studentId) {
        Student dbStudent = new Student();
        try {
            String sql = "select * from student where id = ?;";

            connection = dBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setLong(1, studentId);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                dbStudent = new Student(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getString("subject")
                );
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbStudent;
    }

    public static int updateStudent(Student student) {
        int result = 0;
        try {
            String sql = "update student set name = ?, email = ?, gender = ?, subject = ? where id = ?;";

            connection = dBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getSubject());
            ps.setLong(5, student.getId());

            result = ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
