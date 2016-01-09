package com.mahan.UI.Controller;

import com.mahan.UI.Model.Person;
import com.mahan.UI.Model.Teacher;
import com.mahan.biz.CourseBLO;
import com.mahan.biz.StudentBLO;
import com.mahan.biz.TeacherBLO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 921227 on 12/5/2015.
 */
public class TeacherController extends BaseController {

TeacherBLO blo=new TeacherBLO();
    public void showList() {
        HttpSession session = req.getSession();
        try {
            session.setAttribute("teachers", blo.loadTeachers());
            RequestDispatcher rd = req.getRequestDispatcher("/teacherlist.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void edit() {
        HttpSession session = req.getSession();
        try {
            session.setAttribute("edit", true);
            ArrayList<Teacher> teachers = (ArrayList<Teacher>) session.getAttribute("teachers");
            int counter = teachers.size();
            for (int i = 0; i < counter; i++) {
                if (req.getAttribute("id").equals(teachers.get(i).getdId()))
                    req.setAttribute("teacherOrder", i);
            }
            RequestDispatcher rd = req.getRequestDispatcher("/teacheredit.jsp");
            rd.forward(req, res);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void delete() {
        try {
            Long teacherId = (Long) req.getAttribute("id");
            blo.deleteTeacher(teacherId);
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
    public void showCourses() {
        HttpSession session = req.getSession();
        CourseBLO cBlo=new CourseBLO();
        try {
            Teacher teacher = blo.findTeacherbyUserId(((Person) session.getAttribute("user")).getdId());
            session.setAttribute("teachercourses", cBlo.loadTeacherCourses(teacher.getdId()));
            RequestDispatcher rd = req.getRequestDispatcher("/teachercourses.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setGrade() {
        CourseBLO cBlo=new CourseBLO();
        Long id = Long.parseLong(req.getParameter("id"));
        float grade = Float.parseFloat(req.getParameter("grade"));
        try {
            cBlo.setGrade(id, grade);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void showStudentsbyCourse() {
        HttpSession session = req.getSession();
        StudentBLO sBlo=new StudentBLO();
        Long courseId = (Long) req.getAttribute("id");
        try {
            session.setAttribute("studentsCourse", sBlo.getStudentsbyCourseId(courseId));
            RequestDispatcher rd = req.getRequestDispatcher("/teachercourses.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
