package com.mahan.Data;

import com.mahan.UI.Model.Student;
import java.sql.*;

/**
 * Created by 921227 on 11/24/2015.
 */
public class StudentDAOImpl extends BaseDAO implements StudentDAO{

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
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }
    public ResultSet selectStudent(Long userId) throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Student] where [Id_Education_User] = '" + userId + "'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
    public void deleteStudent(Long studentId) throws SQLException {
        String query = "delete from [JavaTraining].[dbo].[Education_Student] where Id='" + studentId + "'";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }
    public void updateStudent(Student student, Long editId) throws SQLException {
        String query = "update [JavaTraining].[dbo].[Education_Student] SET [FirstName]='" + student.getFirstname() + "',[LastName]='" + student.getLastname()
                + "' ,[NationalNo]=" + student.getNationalNo() + ",[BirthDate]='" + student.getBirthDate()
                + "',[Gender]='" + student.getGender() + "',[Address]='" + student.getAddress() + "',[Email]='" + student.getEmail() + "',[Tel]='" + student.getTel() + "',[Field]='" + student.getFieldsOfStudy() + "',[StudentNo]='" + student.getStudentNo() + "',[Degree]='" + student.getDegree()
                + "'" + "where [Id] = '" + editId + "'";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);

    }
    public ResultSet selectStudents() throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Student]";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
    public ResultSet selectStudentsbyCourse(Long courseId) throws SQLException {
        String query = "SELECT distinct s.Id as studentId, sc.Id, s.StudentNo, s.FirstName, s.LastName, s.Field, s.Degree, sc.Grade FROM [JavaTraining].[dbo].[Education_Student_Course] sc left join [dbo].[Education_Student] s on sc.Id_Education_Student=s.[Id]  where sc.Id_Education_Course='" + courseId + "' order by s.LastName";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
}
