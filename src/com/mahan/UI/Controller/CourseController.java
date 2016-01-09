package com.mahan.UI.Controller;

import com.mahan.UI.Model.Course;
import com.mahan.biz.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 921227 on 12/5/2015.
 */
public class CourseController extends BaseController {
    CourseBLO blo = new CourseBLO();

    public void showList() {
        HttpSession session = req.getSession();
        try {
            session.setAttribute("courses", blo.loadCourses());
            if (session.getAttribute("role_course").equals("admin")) {
                RequestDispatcher rd = req.getRequestDispatcher("/courseslist.jsp");
                rd.forward(req, res);
            }
            if (session.getAttribute("role_course").equals("student")) {
                RequestDispatcher rd = req.getRequestDispatcher("/studentcourses.jsp");
                rd.forward(req, res);
            }
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
            RequestDispatcher rd = req.getRequestDispatcher("/courseedit.jsp");
            rd.forward(req, res);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void delete() {
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
}
