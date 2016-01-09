package com.mahan.Data;

import com.mahan.UI.Model.Teacher;
import java.sql.*;

/**
 * Created by 921227 on 11/24/2015.
 */
public class TeacherDAOImpl extends BaseDAO implements TeacherDAO{

    public void insertTeacher(Teacher teacher) throws SQLException {
        ResultSet rs = selectUser(teacher.getFirstname());
        Long Id = null;
        while (rs.next()) {
            Id = rs.getLong("Id");
        }
        String query = "insert into [JavaTraining].[dbo].[Education_Teacher]  values('" + Id + "','"
                + teacher.getFirstname() + "','" + teacher.getLastname() + "'," + teacher.getNationalNo() + ",'" + teacher.getBirthDate() + "','" + teacher.getGender() + "','" + teacher.getAddress() + "','" + teacher.getEmail() + "','" + teacher.getTel() + "'," + teacher.getTeacherNo() + ",'"
                + teacher.getPosition() + "')";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }
    public void deleteTeacher(Long teacherId) throws SQLException {
        String query = "delete from [JavaTraining].[dbo].[Education_Teacher] where [Id]='" + teacherId + "'";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
        //todo delete user after delete teacher
//        ResultSet rs=  selectTeacher(teacherId);
//        Long userId=null;
//        while(rs.next()){
//            userId=  rs.getLong("Id_Education_User");
//        }
//        deleteUser(userId);
    }
    public ResultSet selectTeacher(Long userId) throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Teacher] where [Id_Education_User]='" + userId + "'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
    public void updateTeacher(Teacher teacher, Long editId) throws SQLException {
        String query = "UPDATE [JavaTraining].[dbo].[Education_Teacher] SET [FirstName]='" + teacher.getFirstname() + "',[LastName]='" + teacher.getLastname()
                + "' ,[NationalNo]=" + teacher.getNationalNo() + ",[BirthDate]='" + teacher.getBirthDate()
                + "',[Gender]='" + teacher.getGender() + "',[Position]='" + teacher.getPosition()
                + "',[Email]='" + teacher.getEmail() + "',[Address]='" + teacher.getAddress() + "',[Tel]='" + teacher.getTel() + "',[TeacherNo]='" + teacher.getTeacherNo() + "' where [Id] = '" + editId + "'";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }
    public ResultSet selectTeachers() throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Teacher]";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
}
