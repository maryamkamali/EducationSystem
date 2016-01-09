package com.mahan.UI.Controller;

import com.mahan.UI.Model.Person;
import com.mahan.UI.Model.Student;
import com.mahan.biz.CourseBLO;
import com.mahan.biz.StudentBLO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 921227 on 12/5/2015.
 */
public class StudentController extends BaseController {
StudentBLO blo=new StudentBLO();
    public void showList() {
        HttpSession session = req.getSession();
        try {
            session.setAttribute("students", blo.loadStudents());
            RequestDispatcher rd = req.getRequestDispatcher("/studentslist.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void edit() {
        HttpSession session = req.getSession();
        try {
            session.setAttribute("edit", true);
            int counter = ((ArrayList<Student>) session.getAttribute("students")).size();
            ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("students");
            for (int i = 0; i < counter; i++) {
                if (req.getAttribute("id").equals(students.get(i).getdId()))
                    req.setAttribute("studentOrder", i);
            }
            RequestDispatcher rd = req.getRequestDispatcher("/studentedit.jsp");
            rd.forward(req, res);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void delete() {
        try {
            Long studentId = (Long) req.getAttribute("id");
            blo.deleteStudent(studentId);
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
    public void showTranscript() {
        try {
            HttpSession session = req.getSession();
            Student student = blo.findStudent(((Person) session.getAttribute("user")).getdId());
            CourseBLO cBlo=new CourseBLO();
            req.getSession().setAttribute("selectedCourses",cBlo.loadStudentCourses(student).getCourses());
            RequestDispatcher rd = req.getRequestDispatcher("/studenttranscript.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showSelectedCourses() {
        HttpSession session = req.getSession();
        CourseBLO cBlo=new CourseBLO();
        try {
            Student student = (Student)session.getAttribute("student");
            String[] selectedCourse_String = req.getParameterValues("myTextEditBox");
            ArrayList<Long> selectedCourse = new ArrayList<>();
            for (int i = 0; i < selectedCourse_String.length; i++) {
                selectedCourse.add(Long.parseLong(selectedCourse_String[i]));
            }
            selectedCourse = cBlo.checkSelectedCourse(student.getdId(), selectedCourse);
            cBlo.addCourseStudent(student.getdId(), selectedCourse);
            session.setAttribute("selectedCourses", cBlo.loadStudentCourses(student).getCourses());
            RequestDispatcher rd = req.getRequestDispatcher("/studentcourses.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showCourses() {
        HttpSession session = req.getSession();
        CourseBLO cBlo=new CourseBLO();
        try {
            Student student = blo.findStudent(((Person) session.getAttribute("user")).getdId());
            session.setAttribute("student", student);
            session.setAttribute("courses", cBlo.loadCourses());
            session.setAttribute("selectedCourses", cBlo.loadStudentCourses(student).getCourses());
            RequestDispatcher rd = req.getRequestDispatcher("/studentcourses.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
