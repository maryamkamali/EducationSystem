package com.mahan.Web;

import com.mahan.biz.BLO;
import com.mahan.biz.Student;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 921227 on 12/5/2015.
 */
public class StudentController extends BaseController{

    public void showList(){
        HttpSession session = req.getSession();
        BLO blo = new BLO();
        try {
            session.setAttribute("students",blo.loadStudents());
            RequestDispatcher rd = req.getRequestDispatcher("/student.jsp");
            rd.forward(req,res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void edit() {
        HttpSession session=req.getSession();
        try {
            session.setAttribute("edit",true);
            int counter= ((ArrayList<Student>)session.getAttribute("students")).size();
            ArrayList<Student> students=(ArrayList<Student>)session.getAttribute("students");
            for (int i=0;i<counter;i++)
            {
                if(req.getAttribute("id").equals(students.get(i).getStudentID()))
                    req.setAttribute("studentOrder", i);
            }
            RequestDispatcher rd=  req.getRequestDispatcher("/student_edit.jsp");
            rd.forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void delete() {

        BLO blo = new BLO();
        try {
            Long studentId=(Long)req.getAttribute("id");
            blo.deleteStudent(studentId);
            showList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        req.getSession().setAttribute("edit",false);
        try {
            RequestDispatcher rd=  req.getRequestDispatcher("/createbean.jsp");
            rd.forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
