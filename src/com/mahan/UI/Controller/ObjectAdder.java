package com.mahan.UI.Controller;
import com.mahan.UI.Model.Course;
import com.mahan.UI.Model.Student;
import com.mahan.UI.Model.Teacher;
import com.mahan.biz.CourseBLO;
import com.mahan.biz.StudentBLO;
import com.mahan.biz.TeacherBLO;

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

        HttpSession session=request.getSession();
        try {
            if (request.getAttribute("currentstudent") != null) {
                StudentBLO sBlo=new StudentBLO();
                if(session.getAttribute("edit")==true) {
                    sBlo.editStudent((Student) request.getAttribute("currentstudent"), (Long) request.getSession().getAttribute("Id"));
                }
                else {
                    sBlo.createStudent((Student) request.getAttribute("currentstudent"));
                }
                RequestDispatcher rd = request.getRequestDispatcher("admin/student/showList");
                rd.forward(request,response);
            } else if (request.getAttribute("teacher") != null) {
                TeacherBLO tBlo=new TeacherBLO();
                if(session.getAttribute("edit")==true) {
                    tBlo.editTeacher((Teacher) request.getAttribute("teacher"), (Long) request.getSession().getAttribute("Id"));
                }
                else {
                    tBlo.createTeacher((Teacher) request.getAttribute("teacher"));
                }
                RequestDispatcher rd = request.getRequestDispatcher("admin/teacher/showList");
                rd.forward(request,response);
            }
            else if(request.getAttribute("course") != null) {
                CourseBLO cBlo=new CourseBLO();
                Course course=(Course)request.getAttribute("course");
                ArrayList<Teacher> teachers=(ArrayList <Teacher>)request.getServletContext().getAttribute("teachers");
                Long teacherId = null;
                for(int i=0;i<teachers.size();i++){
                    if(course.getTeacherName().equals(teachers.get(i).getLastname())) {
                        teacherId = teachers.get(i).getdId();
                        break;
                    }
                }
                if(session.getAttribute("edit")==false) {
                    cBlo.createCourse(course, teacherId);
                }
                else {
                    cBlo.editCourse(course,teacherId,(Long)request.getSession().getAttribute("Id"));
                }
                RequestDispatcher rd = request.getRequestDispatcher("admin/course/showList");
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
