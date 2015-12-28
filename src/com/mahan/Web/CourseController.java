package com.mahan.Web;

import com.mahan.biz.BLO;
import com.mahan.biz.Course;
import com.mahan.biz.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
            if(req.getSession().getAttribute("role_course").equals("student")){
                Student student=new Student();
                student.setdId(2L);
                session.setAttribute("selectedCourses", blo.loadStudentCourses(student).getCourses());
                RequestDispatcher rd = req.getRequestDispatcher("/studentcourse.jsp");
                rd.forward(req, res);
            }
            else{
            RequestDispatcher rd = req.getRequestDispatcher("/course.jsp");
            rd.forward(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//test
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

    public void showStudentCourse() {
        HttpSession session = req.getSession();
        BLO blo = new BLO();
        Student student=new Student();
        student.setdId(2L);

        try {
            //todo
            String[] selectedCourse_String = req.getParameterValues("myTextEditBox");
            if(selectedCourse_String!=null){
            ArrayList<Long> selectedCourse = new ArrayList<>();
            for (int i = 0; i < selectedCourse_String.length; i++) {
                selectedCourse.add(Long.parseLong(selectedCourse_String[i]));
            }

              selectedCourse=  blo.checkSelectedCourse(student.getdId(), selectedCourse);
            blo.addCourseStudent(student.getdId(), selectedCourse);

            session.setAttribute("selectedCourses",blo.loadStudentCourses(student).getCourses());
            }
            RequestDispatcher rd = req.getRequestDispatcher("/studentcourse.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void teacherCourses(){
        HttpSession session = req.getSession();
        BLO blo = new BLO();
        Long a = Long.valueOf(13);
        try {
            session.setAttribute("teachercourses",blo.loadTeacherCourses(a));
            RequestDispatcher rd = req.getRequestDispatcher("/coursesteacher.jsp");
            rd.forward(req,res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGrade(){
        System.out.println("HI");
    }
}
