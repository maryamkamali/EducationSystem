package com.mahan.biz;

import com.mahan.Data.StudentDAOImpl;
import com.mahan.UI.Model.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 921227 on 11/24/2015.
 */
public class StudentBLO extends UserBLO {
    StudentDAOImpl dao = new StudentDAOImpl();
    public void createStudent(Student student) throws SQLException, IOException, ClassNotFoundException {
        StudentDAOImpl dao = new StudentDAOImpl();
        dao.connect();
        dao.insertUser(student.getFirstname(), "123", 1);
        dao.insertStudent(student);
    }
    public void editStudent(Student student, Long editId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
            dao.updateStudent(student, editId);

    }
    public void deleteStudent(Long StudentId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        dao.deleteStudent(StudentId);
    }
    public Student findStudent(Long studentId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        Student student = new Student();
        ResultSet rs = dao.selectStudent(studentId);
        while (rs.next()) {
            student.setdId(rs.getLong("Id"));
        }
        return student;
    }
    public ArrayList<Student> loadStudents() throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        ResultSet rs = dao.selectStudents();
        ArrayList<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setFirstname(rs.getString("FirstName"));
            student.setLastname(rs.getString("LastName"));
            student.setNationalNo(rs.getLong("NationalNo"));
            student.setBirthDate(rs.getString("BirthDate"));
            student.setGender(rs.getString("Gender"));
            student.setFieldsOfStudy((FieldsOfStudy.valueOf(rs.getString("Field"))));
            student.setDegree((Degree.valueOf(rs.getString("Degree"))));
            student.setEmail(rs.getString("Email"));
            student.setTel(rs.getString("Tel"));
            student.setAddress(rs.getString("Address"));
            student.setStudentNo(rs.getLong("StudentNo"));
            student.setdId(rs.getLong("Id"));
            students.add(student);
        }
        return students;
    }
    public HashMap<Long, Student> getStudentsbyCourseId(Long courseId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        HashMap<Long, Student> courseStudent = new HashMap<>();
        ResultSet rs = dao.selectStudentsbyCourse(courseId);
        while (rs.next()) {
            Student student = new Student();
            ArrayList<Course> courses = new ArrayList<>();
            Course course = new Course();
            course.setdId(courseId);
            courses.add(course);
            course.setGrade(rs.getFloat("Grade"));
            Long Id = rs.getLong("Id");
            student.setdId(rs.getLong("studentId"));
            student.setStudentNo(rs.getLong("StudentNo"));
            student.setFirstname(rs.getString("FirstName"));
            student.setLastname(rs.getString("LastName"));
            student.setFieldsOfStudy(FieldsOfStudy.valueOf(rs.getString("Field")));
            student.setDegree(Degree.valueOf(rs.getString("Degree")));
            student.setCourses(courses);
            courseStudent.put(Id, student);
        }
        return courseStudent;
    }
}
