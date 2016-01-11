package com.mahan.Data;

import com.mahan.UI.Model.Course;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 921227 on 11/24/2015.
 */
public class CourseDAOImpl extends BaseDAO implements CourseDAO{

    public void insertCourse(Course course, Long teacherId) throws SQLException {
        String query = "insert into [dbo].[Education_Course]  values('" + null + "','" + course.getPoint() + "','" + course.getCourseNo() + "','" + teacherId + "','" + course.getTitle() + "')";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public ResultSet selectCourses() throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Course] c join [dbo].[Education_Teacher] t on c.[Id_Education_Teacher]=t.Id";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public void deleteCourse(Long courseId) throws SQLException {
        String query = "delete from [JavaTraining].[dbo].[Education_Course] where Id='" + courseId + "'";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public void updateCourse(Course course, Long teacherId, Long editId) throws SQLException {

        String query = "UPDATE [dbo].[Education_Course] SET [Point]='" + course.getPoint()
                + "' ,[CourseNo]=" + course.getCourseNo() + ",[Id_Education_Teacher]='" + teacherId + "',[Title]='" + course.getTitle() + "' where [Id]='" + editId + "'";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

    public ResultSet selectStudentCourses(Long studentId) throws SQLException {
        String query = "select * from [JavaTraining].[dbo].[Education_Student_Course] sc join [dbo].[Education_Course] c on sc.Id_Education_Course=c.Id join [dbo].[Education_Teacher] t on c.Id_Education_Teacher=t.Id where [Id_Education_Student]='" + studentId + "'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public void insertStudent_Course(Long studentId, ArrayList<Long> selectedCourse) throws SQLException {
        for (int i = 0; i < selectedCourse.size(); i++) {
            String query = "insert into [JavaTraining].[dbo].[Education_Student_Course]  values('" + studentId + "','" + selectedCourse.get(i) + "','" + 0 + "')";
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
        }
    }

    public ResultSet getCourseStudents(Long courseID) throws SQLException {
        String query = "SELECT * FROM [JavaTraining].[dbo].[Education_Student_Course] c where c.[Id_Education_Course] = '" + courseID + "'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
    
    public void updateGrade(Long id, float grade) throws SQLException {

        String query = "UPDATE [dbo].[Education_Student_Course] SET Grade =' "+grade+"' where Id ='"+id+"'";
        Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }
}
