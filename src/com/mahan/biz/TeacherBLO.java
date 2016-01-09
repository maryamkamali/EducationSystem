package com.mahan.biz;

import com.mahan.Data.TeacherDAOImpl;
import com.mahan.UI.Model.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 921227 on 11/24/2015.
 */
public class TeacherBLO {
    TeacherDAOImpl dao = new TeacherDAOImpl();

    public void createTeacher(Teacher teacher) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        dao.insertUser(teacher.getFirstname(), "123", 1);
        dao.insertTeacher(teacher);
    }
    public void editTeacher(Person person, Long editId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        dao.updateTeacher((Teacher) person, editId);
    }
    public void deleteTeacher(Long teacherId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        dao.deleteTeacher(teacherId);
    }
    public Teacher getTeacherbyId(long teacherId) throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Teacher> teachers = loadTeachers();
        Teacher teacher = new Teacher();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getdId() == teacherId) {
                teacher = teachers.get(i);
            }
        }
        return teacher;
    }
    public Teacher findTeacherbyUserId(Long userId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        Teacher teacher = new Teacher();
        ResultSet rs = dao.selectTeacher(userId);
        while (rs.next()) {
            teacher.setdId(rs.getLong("Id"));
        }
        return teacher;
    }
    public ArrayList<Teacher> loadTeachers() throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        ResultSet rs = dao.selectTeachers();
        ArrayList<Teacher> teachers = new ArrayList<>();
        while (rs.next()) {
            Teacher teacher = new Teacher();
            teacher.setdId(rs.getLong("Id"));
            teacher.setTeacherNo(rs.getLong("TeacherNo"));
            teacher.setLastname(rs.getString("LastName"));
            teacher.setFirstname(rs.getString("FirstName"));
            teacher.setPosition((Position.valueOf(rs.getString("Position"))));
            teacher.setBirthDate(rs.getString("BirthDate"));
            teacher.setAddress(rs.getString("Address"));
            teacher.setEmail(rs.getString("Email"));
            teacher.setGender(rs.getString("Gender"));
            teacher.setNationalNo(rs.getLong("NationalNo"));
            teacher.setTel(rs.getString("Tel"));
            teachers.add(teacher);
        }
        return teachers;
    }
}
