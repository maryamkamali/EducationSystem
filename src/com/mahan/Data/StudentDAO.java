package com.mahan.Data;

import com.mahan.UI.Model.Admin;
import com.mahan.UI.Model.Course;
import com.mahan.UI.Model.Student;
import com.mahan.UI.Model.Teacher;
import com.mahan.Util.ConfigGenerator;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 921227 on 11/24/2015.
 */
public interface StudentDAO {

    public void insertStudent(Student student) throws SQLException;
    public ResultSet selectStudent(Long userId) throws SQLException;
    public void deleteStudent(Long studentId) throws SQLException;
    public void updateStudent(Student student, Long editId) throws SQLException;
    public ResultSet selectStudents() throws SQLException;
    public ResultSet selectStudentsbyCourse(Long courseId) throws SQLException;
}
