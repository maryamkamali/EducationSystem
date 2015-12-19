package com.mahan.biz;

import com.mahan.Data.DAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 921227 on 11/24/2015.
 */
public class BLO {
    public void createPerson(Person person) throws SQLException, IOException, ClassNotFoundException {
//This is a git test
        DAO dao = new DAO();
        dao.connect();
        if (person instanceof Student) {
            dao.insertStudent((Student) person);
        } else if (person instanceof Teacher) {
            dao.insertTeacher((Teacher) person);
        } else if (person instanceof Admin) {
            dao.insertAdmin((Admin) person);
        }
    }

    public void createCourse(Course course, Long teacherId) throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        dao.insertCourse(course,teacherId);


    }


    public ArrayList<Student> loadStudents() throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        ResultSet rs = dao.selectStudents();
        ArrayList<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setFirstname(rs.getString("firstName"));
            student.setLastname(rs.getString("lastName"));
            student.setNationalID(rs.getLong("nationalID"));
            student.setBirthDate(rs.getString("birthDate"));
            student.setGender(rs.getString("gender"));
            student.setFieldsOfStudy((FieldsOfStudy.valueOf(rs.getString("field"))));
            student.setDegree((Degree.valueOf(rs.getString("degree"))));
            student.setEmail(rs.getString("email"));
            student.setTel(rs.getString("tel"));
            student.setAddress(rs.getString("address"));
            student.setStudentID(rs.getLong("studentID"));
            students.add(student);
        }
        return students;
    }

    public void deleteStudent(Long StudentId) throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
       dao.deleteStudent(StudentId);
    }



    public void editPerson(Person person) throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        if (person instanceof Student) {
            dao.updateStudent((Student) person);
        }
        else if (person instanceof Teacher) {
            dao.updateTeacher((Teacher) person);
        } else if (person instanceof Admin) {
            dao.insertAdmin((Admin) person);
        }
    }
    public ArrayList<Teacher> loadTeachers() throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        ResultSet rs = dao.selectTeachers();
        ArrayList<Teacher> teachers = new ArrayList<>();
        while (rs.next()){
            Teacher teacher = new Teacher();
            teacher.setId(rs.getLong("ID"));
            teacher.setTeacherID(rs.getLong("teacherID"));
            teacher.setLastname(rs.getString("lastName"));
            teacher.setFirstname(rs.getString("firstName"));
            teacher.setFaculty(Faculty.valueOf(rs.getString("faculty")));
            teacher.setPosition((Position.valueOf(rs.getString("position"))));
            teacher.setBirthDate(rs.getString("birthDate"));
            teacher.setAddress(rs.getString("address"));
            teacher.setEmail(rs.getString("email"));
            teacher.setGender(rs.getString("gender"));
            teacher.setNationalID(rs.getLong("nationalID"));
            teacher.setTel(rs.getString("phone"));
            teachers.add(teacher);

        }
        return teachers;
    }
    public void deleteTeacher(int teacherId) throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        dao.deleteTeacher(teacherId);
    }

    public ArrayList<Course> loadCourses() throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        ResultSet rs = dao.selectCourses();
        ArrayList<Course> courses = new ArrayList<>();
        while (rs.next()){
            Course course = new Course();
            // course.setTeacherID(rs.getLong("teacherID"));
            course.setCourseID(rs.getLong("courseID"));
            course.setFaculty(Faculty.valueOf(rs.getString("faculty")));
            course.setPoint(rs.getInt("point"));
            course.setTeacher(getTeacherbyId(Long.valueOf(rs.getInt("teacherID"))));
            course.setID(Long.valueOf(rs.getInt("ID")));
            courses.add(course);
        }
        return courses;
    }

    public void deleteCourse(int courseId) throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        dao.deleteCourse(courseId);
    }

    public Teacher getTeacherbyId(long teacherID) throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Teacher> teachers = loadTeachers();
        Teacher teacher = new Teacher();
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getId()==teacherID){
                teacher = teachers.get(i);
            }
        }
        return teacher;
    }

    public ArrayList<Course> loadTeacherCourses(Long teacherID) throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Course> teacherCourses = new ArrayList<>();
        ArrayList<Course> allCourses = loadCourses();
        for (int i=0;i<allCourses.size();i++){
            if(allCourses.get(i).getTeacher().getId()==teacherID){
                teacherCourses.add(allCourses.get(i));
            }
        }
        return teacherCourses;
    }

}
