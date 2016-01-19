package com.mahan.Data;

import com.mahan.UI.Model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 921227 on 1/19/2016.
 */
public interface TeacherDAO {
    public void insertTeacher(Teacher teacher) throws SQLException;
    public void deleteTeacher(Long teacherId) throws SQLException;
    public ResultSet selectTeacher(Long userId) throws SQLException;
    public void updateTeacher(Teacher teacher, Long editId) throws SQLException;
    public ResultSet selectTeachers() throws SQLException;
}
