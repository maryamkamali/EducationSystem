package com.mahan.Data;
import com.mahan.UI.Model.Course;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 921227 on 11/24/2015.
 */
public interface CourseDAO {

    public void insertCourse(Course course, Long teacherId) throws SQLException;

    public ResultSet selectCourses() throws SQLException;

    public void deleteCourse(Long courseId) throws SQLException;

    public void updateCourse(Course course, Long teacherId, Long editId) throws SQLException;

    public ResultSet selectStudentCourses(Long studentId) throws SQLException;

    public void insertStudent_Course(Long studentId, ArrayList<Long> selectedCourse) throws SQLException;

    public ResultSet getCourseStudents(Long courseID) throws SQLException;

    public void updateGrade(Long id, float grade) throws SQLException;
}
