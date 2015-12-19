package com.mahan.Data;

import com.mahan.Util.ConfigGenerator;
import com.mahan.biz.Admin;
import com.mahan.biz.Course;
import com.mahan.biz.Student;
import com.mahan.biz.Teacher;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 921227 on 11/24/2015.
 */
public class DAO {
    private Connection con;

    public void connect() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = new ConfigGenerator().getPropValues();
        con = DriverManager.getConnection(connectionURL);
    }

    public void insertStudent(Student student) throws SQLException {
        String query = "insert into [dbo].[Education_Student]  values('"
                + student.getFirstname() + "','" + student.getLastname() + "'," + student.getNationalID() + ",'" + student.getBirthDate()
                + "','" + student.getGender() + "','" + student.getFieldsOfStudy() + "','"
                + student.getDegree() + "','" + student.getEmail() + "','" + student.getTel() + "','" + student.getAddress() + "'," + student.getStudentID() + ")";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void insertTeacher(Teacher teacher) throws SQLException {
        String query = "insert into [JavaTraining].[dbo].[Education_Teacher]  values('"
                + teacher.getFirstname() + "','" + teacher.getLastname() + "'," + teacher.getNationalID() + ",'" + teacher.getBirthDate() + "','" + teacher.getGender() + "','" + teacher.getFaculty() + "','"
                + teacher.getPosition() + "','" + teacher.getEmail() + "','" + teacher.getAddress() + "','" + teacher.getTel() + "'," + teacher.getTeacherID() + ")";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void insertAdmin(Admin admin) throws SQLException {
        String query = "insert into [dbo].[Education_Student]  values('"
                + admin.getFirstname() + "','" + admin.getLastname() + "'," + admin.getNationalID() + ",'2004-10-10'"
                + ",'" + admin.getGender() + "','" + admin.getEmail() + "','" + admin.getTel() + "','" + admin.getAddress() + "')";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void insertCourse(Course course, Long teacherId) throws SQLException {
        String query = "insert into [dbo].[Education_Course]  values('" + course.getFaculty() + "','" + course.getPoint() + "','" + course.getCourseID() +"','"+teacherId+ "')";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public ResultSet selectStudents() throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Student]";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public void deleteStudent(Long studentId) throws SQLException {
        String query = "delete from [JavaTraining].[dbo].[Education_Student] where studentID='" + studentId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);

    }

    public void updateStudent(Student student) throws SQLException {
        String query = "update [JavaTraining].[dbo].[Education_Student] SET [firstName]='" + student.getFirstname() + "',[lastName]='" + student.getLastname()
                + "' ,[nationalID]=" + student.getNationalID() + ",[birthDate]='" + student.getBirthDate()
                + "',[gender]='" + student.getGender() + "',[field]='" + student.getFieldsOfStudy() + "',[degree]='" + student.getDegree()
                + "',[email]='" + student.getEmail() + "',[tel]='" + student.getTel() + "',[address]='" + student.getAddress() + "'"
                + "where studentID = '" + student.getStudentID() + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);

    }

    public ResultSet selectTeachers() throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Teacher]";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public void deleteTeacher(int teacherId) throws SQLException {
        String query = "delete from [JavaTraining].[dbo].[Education_Teacher] where teacherID='" + teacherId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public ResultSet selectCourses() throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Course]";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public void deleteCourse(int courseId) throws SQLException {
        String query = "delete from [JavaTraining].[dbo].[Education_Course] where courseId='" + courseId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void updateTeacher(Teacher teacher) throws SQLException {
        String query = "update [JavaTraining].[dbo].[Education_Teacher] SET [firstName]='" + teacher.getFirstname() + "',[lastName]='" + teacher.getLastname()
                + "' ,[nationalID]=" + teacher.getNationalID() + ",[birthDate]='" + teacher.getBirthDate()
                + "',[gender]='" + teacher.getGender() + "',[faculty]='" + teacher.getFaculty() + "',[position]='" + teacher.getPosition()
                + "',[email]='" + teacher.getEmail() + "',[address]='" + teacher.getAddress() + "',[phone]='" + teacher.getTel() + "'where TeacherID = '" + teacher.getTeacherID() + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }
}
