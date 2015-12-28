package com.mahan.biz;

import com.mahan.Data.DAO;

import javax.naming.NamingException;
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
        dao.insertCourse(course, teacherId);


    }


    public ArrayList<Student> loadStudents() throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
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
        } else if (person instanceof Teacher) {
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

    public void deleteTeacher(Long teacherId) throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        dao.deleteTeacher(teacherId);
    }

    public ArrayList<Course> loadCourses() throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        ResultSet rs = dao.selectCourses();
        ArrayList<Course> courses = new ArrayList<>();
        while (rs.next()) {
            Course course = new Course();
            // course.setTeacherNo(rs.getLong("teacherID"));
            course.setCourseNo(rs.getLong("CourseNo"));
            course.setPoint(rs.getInt("Point"));
            course.setTeacher(getTeacherbyId(Long.valueOf(rs.getInt("Id_Education_Teacher"))));
            course.setdId(Long.valueOf(rs.getInt("Id")));
            course.setTitle(rs.getString("Title"));
            courses.add(course);
        }
        return courses;
    }

    public void deleteCourse(Long courseId) throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        dao.deleteCourse(courseId);
    }

    public void editCourse(Course course, Long teacherId) throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        dao.updateCourse(course, teacherId);
    }

    public ArrayList<Course> loadStudentCourses(Long studentId) throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        ResultSet rs = dao.selectStudentCourses(studentId);
        ArrayList<Course> courses = new ArrayList<>();
        while (rs.next()) {
            Course course = new Course();
            course.setCourseNo(rs.getLong("CourseNo"));
            course.setTitle(rs.getString("Title"));
            course.setTeacherName(rs.getString("FirstName") + " " + rs.getString("LastName"));
            course.setPoint(rs.getInt("Point"));
            courses.add(course);

        }
        return courses;
    }

    public void addCourseStudent(Long studentId, ArrayList<Long> selectedCourse) throws SQLException, IOException, ClassNotFoundException {
        DAO dao = new DAO();
        dao.connect();
        dao.insertStudent_Course(studentId, selectedCourse);

    }

    public Teacher getTeacherbyId(long teacherID) throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Teacher> teachers = loadTeachers();
        Teacher teacher = new Teacher();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getdId() == teacherID) {
                teacher = teachers.get(i);
            }
        }
        return teacher;
    }

    public ArrayList<Course> loadTeacherCourses(Long teacherID) throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Course> teacherCourses = new ArrayList<>();
        ArrayList<Course> allCourses = loadCourses();
        for (int i = 0; i < allCourses.size(); i++) {
            if (allCourses.get(i).getTeacher().getdId() == teacherID) {
                teacherCourses.add(allCourses.get(i));
            }
        }
        return teacherCourses;
    }

    public Person createUser(String userName)
            throws SQLException, NamingException, IOException, ClassNotFoundException {
        DAO db;
        db = new DAO();
        db.connect();
        Person person = null;
        ResultSet rs = db.selectUser(userName);

        while (rs.next()) {
            person = new Person();
            person.setUserName(rs.getString("UserName"));
            person.setPassword(rs.getString("Password"));
            person.setdId(rs.getLong("Id"));
            person.setRole(rs.getInt("role"));
        }
        return person;
    }

    public ArrayList checkSelectedCourse(Long studentId, ArrayList selectedCourse) throws SQLException, IOException, ClassNotFoundException {
        DAO db;
        db = new DAO();
        db.connect();
        ResultSet rs = db.selectStudentCourses(studentId);
       while (rs.next()){
           for(int i=0;i<selectedCourse.size();i++) {
               if (rs.getLong("Id_Education_Course")==selectedCourse.get(i)){
                   selectedCourse.remove(selectedCourse.get(i));
               }
           }
       }
        return selectedCourse;
    }
}
