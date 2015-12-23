package com.mahan.Data;

import com.mahan.Util.ConfigGenerator;
import com.mahan.biz.Admin;
import com.mahan.biz.Course;
import com.mahan.biz.Student;
import com.mahan.biz.Teacher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        //todo userid not set
        String query = "insert into [dbo].[Education_Student]  values('" + 2 + "','"
                + student.getFirstname() + "','" + student.getLastname() + "'," + student.getNationalNo() + ",'" + student.getBirthDate()
                + "','" + student.getGender() + "','" + student.getAddress() + "','" + student.getEmail() + "','" + student.getTel() + "'," + student.getStudentNo() + ",'" + student.getFieldsOfStudy() + "','"
                + student.getDegree() + "')";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void insertTeacher(Teacher teacher) throws SQLException {
        String query = "insert into [JavaTraining].[dbo].[Education_Teacher]  values('" + 2 + "','"
                + teacher.getFirstname() + "','" + teacher.getLastname() + "'," + teacher.getNationalNo() + ",'" + teacher.getBirthDate() + "','" + teacher.getGender() + "','" + teacher.getAddress() + "','" + teacher.getEmail() + "','" + teacher.getTel() + "'," + teacher.getTeacherNo() + ",'" + teacher.getFaculty() + "','"
                + teacher.getPosition() + "',)";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void insertAdmin(Admin admin) throws SQLException {
        String query = "insert into [dbo].[Education_Student]  values('"
                + admin.getFirstname() + "','" + admin.getLastname() + "'," + admin.getNationalNo() + ",'2004-10-10'"
                + ",'" + admin.getGender() + "','" + admin.getEmail() + "','" + admin.getTel() + "','" + admin.getAddress() + "')";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void insertCourse(Course course, Long teacherId) throws SQLException {
        String query = "insert into [dbo].[Education_Course]  values('" + course.getFaculty() + "','" + course.getPoint() + "','" + course.getCourseNo() + "','" + teacherId + "')";
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
        String query = "delete from [JavaTraining].[dbo].[Education_Student] where Id='" + studentId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);

    }

    public void updateStudent(Student student) throws SQLException {
        String query = "update [JavaTraining].[dbo].[Education_Student] SET [FirstName]='" + student.getFirstname() + "',[LastName]='" + student.getLastname()
                + "' ,[NationalNo]=" + student.getNationalNo() + ",[BirthDate]='" + student.getBirthDate()
                + "',[Gender]='" + student.getGender() + "',[Address]='" + student.getAddress() + "',[Email]='" + student.getEmail() + "',[Tel]='" + student.getTel() + "',[Field]='" + student.getFieldsOfStudy() + "',[StudentNo]='" + student.getStudentNo() + "',[Degree]='" + student.getDegree()
                + "'," + "where studentNo = '" + student.getStudentNo() + "'";
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
        String query = "delete from [JavaTraining].[dbo].[Education_Teacher] where Id='" + teacherId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public ResultSet selectCourses() throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Course]";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public void deleteCourse(Long courseId) throws SQLException {
        String query = "delete from [JavaTraining].[dbo].[Education_Course] where Id='" + courseId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }


    public void updateTeacher(Teacher teacher) throws SQLException {
        String query = "UPDATE [JavaTraining].[dbo].[Education_Teacher] SET [FirstName]='" + teacher.getFirstname() + "',[LastName]='" + teacher.getLastname()
                + "' ,[NationalNo]=" + teacher.getNationalNo() + ",[BirthDate]='" + teacher.getBirthDate()
                + "',[Gender]='" + teacher.getGender() + "',[Faculty]='" + teacher.getFaculty() + "',[Position]='" + teacher.getPosition()
                + "',[Email]='" + teacher.getEmail() + "',[Address]='" + teacher.getAddress() + "',[Tel]='" + teacher.getTel() + "'where TeacherNo = '" + teacher.getTeacherNo() + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }
    public void updateCourse(Course course, Long teacherId) throws SQLException {

        String query = "UPDATE [dbo].[Education_Course] SET [Faculty]='" + course.getFaculty() + "',[Point]='" + course.getPoint()
                + "' ,[CourseNo]=" + course.getCourseNo() + ",[Id_Education_Teacher]='" + teacherId + "',[Title]='" + course.getTitle() + "' where CourseNo='" + course.getCourseNo() + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public ResultSet selectFacultyCourses(String faculty) throws SQLException {
        String query = "select * from [JavaTraining].[dbo].[Education_Course] where [Faculty]='" + faculty + "'";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public ResultSet selectStudentCourses(Long studentId) throws SQLException {
        String query = "select * from [JavaTraining].[dbo].[Education_Student_Course] where [Id_Education_Student]='" + studentId + "'";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public void insertStudent_Course(Long studentId, ArrayList<Integer> selectedCourse) throws SQLException {
        for (int i = 0; i < selectedCourse.size(); i++) {
            String query = "insert into [JavaTraining].[dbo].[Education_Student_Course]  values('" + studentId + "','" + selectedCourse.get(i) + "')";
            java.sql.Statement stm = con.createStatement();
            stm.executeUpdate(query);
        }
    }

}
