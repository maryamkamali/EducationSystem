package com.mahan.Web;

import com.mahan.biz.BLO;
import com.mahan.biz.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 921227 on 12/5/2015.
 */
public class TeacherController extends BaseController{


    public void showList(){
        HttpSession session = req.getSession();
        BLO blo = new BLO();
        try {
            session.setAttribute("teachers",blo.loadTeachers());
            RequestDispatcher rd = req.getRequestDispatcher("/teacher.jsp");
            rd.forward(req,res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void edit() {
        HttpSession session=req.getSession();
        try {
            session.setAttribute("edit",true);
            ArrayList<Teacher> teachers=(ArrayList<Teacher>)session.getAttribute("teachers");
            int counter= teachers.size();

            for (int i=0;i<counter;i++)
            {
                if(req.getAttribute("id").equals(teachers.get(i).getTeacherNo()))
                    req.setAttribute("teacherOrder", i);
            }
            RequestDispatcher rd=  req.getRequestDispatcher("/teacher_edit.jsp");
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
            int teacherId=(Integer)req.getAttribute("id");
            blo.deleteTeacher(teacherId);
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
