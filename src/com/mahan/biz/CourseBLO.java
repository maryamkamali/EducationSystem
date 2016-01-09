package com.mahan.biz;

import com.mahan.Data.CourseDAOImpl;
import com.mahan.UI.Model.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 921227 on 11/24/2015.
 */
public class CourseBLO {

    CourseDAOImpl dao = new CourseDAOImpl();
    public void createCourse(Course course, Long teacherId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        dao.insertCourse(course, teacherId);
    }
    public ArrayList<Course> loadCourses() throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        ResultSet rs = dao.selectCourses();
        ArrayList<Course> courses = new ArrayList<>();
        while (rs.next()) {
            Course course = new Course();
            course.setCourseNo(rs.getLong("CourseNo"));
            course.setPoint(rs.getInt("Point"));
            Teacher teacher=new Teacher();
            teacher.setFirstname(rs.getString("FirstName"));
            teacher.setLastname(rs.getString("LastName"));
            teacher.setdId(rs.getLong("Id_Education_Teacher"));
            course.setTeacher(teacher);
            course.setdId(Long.valueOf(rs.getInt("Id")));
            course.setTitle(rs.getString("Title"));
            courses.add(course);
        }
        return courses;
    }
    public void deleteCourse(Long courseId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        dao.deleteCourse(courseId);
    }
    public void editCourse(Course course, Long teacherId, Long editId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        dao.updateCourse(course, teacherId, editId);
    }
    public Student loadStudentCourses(Student student) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        ResultSet rs = dao.selectStudentCourses(student.getdId());
        ArrayList<Course> courses = new ArrayList<>();
        while (rs.next()) {
            Course course = new Course();
            course.setGrade(rs.getFloat("Grade"));
            course.setCourseNo(rs.getLong("CourseNo"));
            course.setTitle(rs.getString("Title"));
            course.setTeacherName(rs.getString("FirstName") + " " + rs.getString("LastName"));
            course.setPoint(rs.getInt("Point"));
            courses.add(course);

        }
        student.setCourses(courses);
        return student;
    }
    public void addCourseStudent(Long studentId, ArrayList<Long> selectedCourse) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        dao.insertStudent_Course(studentId, selectedCourse);

    }
    public ArrayList<Course> loadTeacherCourses(Long teacherId) throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Course> teacherCourses = new ArrayList<>();
        ArrayList<Course> allCourses = loadCourses();
        for (int i = 0; i < allCourses.size(); i++) {
            if (allCourses.get(i).getTeacher().getdId() == teacherId) {
                teacherCourses.add(allCourses.get(i));
            }
        }
        return teacherCourses;
    }
    public HashMap loadCourseStudents(Long courseID) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        ResultSet rs = dao.getCourseStudents(courseID);
        ArrayList<Long> studentIDs = new ArrayList<>();
        HashMap<Student, Integer> studentGradeMap = new HashMap<>();
        ArrayList<Student> courseStudents = new ArrayList<>();
        StudentBLO blo=new StudentBLO();
        while (rs.next()) {
            studentGradeMap.put(blo.findStudent(rs.getLong("Id_Education_Student")), rs.getInt("Grade"));
        }
        return studentGradeMap;
    }
    public ArrayList<Long> checkSelectedCourse(Long studentId, ArrayList<Long> selectedCourse) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        ResultSet rs = dao.selectStudentCourses(studentId);
        while (rs.next()) {
            for (int i = 0; i < selectedCourse.size(); i++) {
                if (rs.getLong("Id_Education_Course") == selectedCourse.get(i)) {
                    selectedCourse.remove(selectedCourse.get(i));
                }
            }
        }
        return selectedCourse;
    }
    public void setGrade(Long id, float grade) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        dao.updateGrade(id , grade);
    }
}
