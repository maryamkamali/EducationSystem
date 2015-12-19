package com.mahan.Web;

import com.mahan.biz.BLO;
import com.mahan.biz.Course;
import com.mahan.biz.Student;
import com.mahan.biz.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 921227 on 11/24/2015.
 */

public class ObjectAdder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BLO blo = new BLO();
        HttpSession session=request.getSession();
        try {
            if (request.getAttribute("currentstudent") != null) {
                if(session.getAttribute("edit")==true) {
                    blo.editPerson((Student) request.getAttribute("currentstudent"));
                }
                else {
                    blo.createPerson((Student) request.getAttribute("currentstudent"));
                }
                RequestDispatcher rd = request.getRequestDispatcher("/student/showList");
                rd.forward(request,response);
            } else if (request.getAttribute("teacher") != null) {
                if(session.getAttribute("edit")==true) {
                    blo.editPerson((Teacher) request.getAttribute("teacher"));
                }
                else {
                    blo.createPerson((Teacher) request.getAttribute("teacher"));
                }
                RequestDispatcher rd = request.getRequestDispatcher("/teacher/showList");
                rd.forward(request,response);
            }
            else if(request.getAttribute("course") != null) {
                Course course=(Course)request.getAttribute("course");
                ArrayList<Teacher> teachers=(ArrayList <Teacher>)request.getServletContext().getAttribute("teachers");
                Long teacherId = null;
                for(int i=0;i<teachers.size();i++){
                    if(course.getTeacherName().equals(teachers.get(i).getLastname())) {
                        teacherId = teachers.get(i).getId();
                        break;
                    }
                }
                if(session.getAttribute("edit")==false) {
                    blo.createCourse(course, teacherId);
                }
                else {
                    blo.editCourse(course,teacherId);
                }
                RequestDispatcher rd = request.getRequestDispatcher("/course/showList");
                rd.forward(request,response);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
