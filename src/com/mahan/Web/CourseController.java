package com.mahan.Web;

import com.mahan.biz.BLO;
import com.mahan.biz.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 921227 on 12/5/2015.
 */
public class CourseController extends BaseController {

    public void showList() {
        HttpSession session = req.getSession();
        BLO blo = new BLO();
        try {
            session.setAttribute("courses", blo.loadCourses());
            RequestDispatcher rd = req.getRequestDispatcher("/course.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit() {
        HttpSession session = req.getSession();
        try {
            session.setAttribute("edit", true);
            int counter = ((ArrayList<Course>) session.getAttribute("courses")).size();
            ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("courses");
            for (int i = 0; i < counter; i++) {
                if (req.getAttribute("id").equals(courses.get(i).getdId())) {
                    req.setAttribute("courseOrder", i);
                    break;
                }
            }
            RequestDispatcher rd = req.getRequestDispatcher("/course_edit.jsp");
            rd.forward(req, res);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        BLO blo = new BLO();
        try {
            Long courseId = (Long) req.getAttribute("id");
            blo.deleteCourse(courseId);
            showList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        req.getSession().setAttribute("edit", false);
        try {
            RequestDispatcher rd = req.getRequestDispatcher("/createbean.jsp");
            rd.forward(req, res);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFacultyCourse() {
        HttpSession session = req.getSession();
        BLO blo = new BLO();
        String faculty = "Industrial";

        try {
            session.setAttribute("courses", blo.loadFacultyCourses(faculty));
            RequestDispatcher rd = req.getRequestDispatcher("/studentcourse.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showStudentCourse() {
        HttpSession session = req.getSession();
        BLO blo = new BLO();
        Long studentId = 2L;
        try {
            //todo
            String[] selectedCourse_String = req.getParameterValues("myTextEditBox");
            ArrayList selectedCourse = new ArrayList();
            for (int i = 0; i < selectedCourse_String.length; i++) {
                selectedCourse.add(Integer.parseInt(selectedCourse_String[i]));
            }
            blo.addCourseStudent(studentId, selectedCourse);

            session.setAttribute("selectedCourses", blo.loadStudentCourses(studentId));
            RequestDispatcher rd = req.getRequestDispatcher("/studentcourse.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void teacherCourses(){
        HttpSession session = req.getSession();
        BLO blo = new BLO();
        Long a = Long.valueOf(15);
        try {
            session.setAttribute("teachercourses",blo.loadTeacherCourses(a));
            RequestDispatcher rd = req.getRequestDispatcher("/coursesteacher.jsp");
            rd.forward(req,res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGrade()  {
        Long courseId = (Long) req.getAttribute("id");
        HttpSession session = req.getSession();
        BLO blo = new BLO();
        try {
            session.setAttribute("coursestudents",blo.loadCourseStudents(courseId));
            RequestDispatcher rd = req.getRequestDispatcher("/coursesteacher.jsp");
            rd.forward(req,res);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void saveGrades(){

    }
}
