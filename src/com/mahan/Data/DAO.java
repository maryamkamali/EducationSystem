package com.mahan.Data;

import com.mahan.Util.ConfigGenerator;
import com.mahan.biz.Admin;
import com.mahan.biz.Course;
import com.mahan.biz.Student;
import com.mahan.biz.Teacher;

import java.io.IOException;
import java.sql.*;
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
        ResultSet rs = selectUser(student.getFirstname());
        Long Id = null;
        while (rs.next()) {
            Id = rs.getLong("Id");
        }
        String query = "insert into [dbo].[Education_Student]  values('" + Id + "','"
                + student.getFirstname() + "','" + student.getLastname() + "'," + student.getNationalNo() + ",'" + student.getBirthDate()
                + "','" + student.getGender() + "','" + student.getAddress() + "','" + student.getEmail() + "','" + student.getTel() + "'," + student.getStudentNo() + ",'" + student.getFieldsOfStudy() + "','"
                + student.getDegree() + "')";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void insertTeacher(Teacher teacher) throws SQLException {
        ResultSet rs = selectUser(teacher.getFirstname());
        Long Id = null;
        while (rs.next()) {
            Id = rs.getLong("Id");
        }
        String query = "insert into [JavaTraining].[dbo].[Education_Teacher]  values('" + Id + "','"
                + teacher.getFirstname() + "','" + teacher.getLastname() + "'," + teacher.getNationalNo() + ",'" + teacher.getBirthDate() + "','" + teacher.getGender() + "','" + teacher.getAddress() + "','" + teacher.getEmail() + "','" + teacher.getTel() + "'," + teacher.getTeacherNo() + ",'"
                + teacher.getPosition() + "')";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void insertAdmin(Admin admin) throws SQLException {
        ResultSet rs = selectUser(admin.getFirstname());
        Long Id = null;
        while (rs.next()) {
            Id = rs.getLong("Id");
        }
        String query = "insert into [dbo].[Education_Admin]  values('" + Id + "','" + admin.getFirstname() + "','" + admin.getLastname() + "'," + admin.getNationalNo() + ",'2004-10-10'"
                + ",'" + admin.getGender() + "','" + admin.getEmail() + "','" + admin.getTel() + "','" + admin.getAddress() + "')";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void insertCourse(Course course, Long teacherId) throws SQLException {
        String query = "insert into [dbo].[Education_Course]  values('" + null + "','" + course.getPoint() + "','" + course.getCourseNo() + "','" + teacherId + "','" + course.getTitle() + "')";
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
        //todo delete user after delete strudent
    }

    public void updateStudent(Student student, Long editId) throws SQLException {
        String query = "update [JavaTraining].[dbo].[Education_Student] SET [FirstName]='" + student.getFirstname() + "',[LastName]='" + student.getLastname()
                + "' ,[NationalNo]=" + student.getNationalNo() + ",[BirthDate]='" + student.getBirthDate()
                + "',[Gender]='" + student.getGender() + "',[Address]='" + student.getAddress() + "',[Email]='" + student.getEmail() + "',[Tel]='" + student.getTel() + "',[Field]='" + student.getFieldsOfStudy() + "',[StudentNo]='" + student.getStudentNo() + "',[Degree]='" + student.getDegree()
                + "'" + "where [Id] = '" + editId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);

    }

    public ResultSet selectTeachers() throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Teacher]";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public void deleteTeacher(Long teacherId) throws SQLException {
        String query = "delete from [JavaTraining].[dbo].[Education_Teacher] where [Id]='" + teacherId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
        //todo delete user after delete teacher
//        ResultSet rs=  selectTeacher(teacherId);
//        Long userId=null;
//        while(rs.next()){
//            userId=  rs.getLong("Id_Education_User");
//        }
//        deleteUser(userId);
    }

    private void deleteUser(Long userId) throws SQLException {
        String query = "delete from [JavaTraining].[dbo].[Education_User] where [Id]='" + userId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public ResultSet selectTeacher(Long teacherId) throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Teacher] where [Id]='" + teacherId + "'";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
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


    public void updateTeacher(Teacher teacher, Long editId) throws SQLException {
        String query = "UPDATE [JavaTraining].[dbo].[Education_Teacher] SET [FirstName]='" + teacher.getFirstname() + "',[LastName]='" + teacher.getLastname()
                + "' ,[NationalNo]=" + teacher.getNationalNo() + ",[BirthDate]='" + teacher.getBirthDate()
                + "',[Gender]='" + teacher.getGender() + "',[Position]='" + teacher.getPosition()
                + "',[Email]='" + teacher.getEmail() + "',[Address]='" + teacher.getAddress() + "',[Tel]='" + teacher.getTel() + "',[TeacherNo]='" + teacher.getTeacherNo() + "' where [Id] = '" + editId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void updateCourse(Course course,Long teacherId, Long editId ) throws SQLException {

        String query = "UPDATE [dbo].[Education_Course] SET [Point]='" + course.getPoint()
                + "' ,[CourseNo]=" + course.getCourseNo() + ",[Id_Education_Teacher]='" + teacherId + "',[Title]='" + course.getTitle() + "' where [Id]='" + editId + "'";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    //todo id haye 2 jadval amade
    public ResultSet selectFacultyCourses(String faculty) throws SQLException {
        String query = "select * from [JavaTraining].[dbo].[Education_Course] c join [dbo].[Education_Teacher] t on c.Id_Education_Teacher=t.Id where c.[Faculty]='" + faculty + "'";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public ResultSet selectStudentCourses(Long studentId) throws SQLException {
        String query = "select * from [JavaTraining].[dbo].[Education_Student_Course] sc join [dbo].[Education_Course] c on sc.Id_Education_Course=c.Id join [dbo].[Education_Teacher] t on c.Id_Education_Teacher=t.Id where [Id_Education_Student]='" + studentId + "'";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public void insertStudent_Course(Long studentId, ArrayList<Long> selectedCourse) throws SQLException {
        for (int i = 0; i < selectedCourse.size(); i++) {
            String query = "insert into [JavaTraining].[dbo].[Education_Student_Course]  values('" + studentId + "','" + selectedCourse.get(i) + "','" + 0 + "')";
            java.sql.Statement stm = con.createStatement();
            stm.executeUpdate(query);
        }
    }

    public ResultSet selectUser(String userName) throws SQLException {

        String query = "select * from [JavaTraining].[dbo].[Education_User] where [UserName]=" + "'" + userName + "'";
        Statement stm = con.createStatement();
        ResultSet resultSet = stm.executeQuery(query);
        return resultSet;

    }

    public ResultSet getCourseStudents(Long courseID) throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Student_Course] c where c.[Id_Education_Course] = '" + courseID + "'";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public void insertUser(String firstname, String password, int role) throws SQLException {
        String query = "insert into [JavaTraining].[dbo].[Education_User]  values('" + firstname + "','" + password + "','" + role + "')";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public ResultSet selectStudent(Long userId) throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Student] where [Id_Education_User] = '" + userId + "'";
        java.sql.Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
}
