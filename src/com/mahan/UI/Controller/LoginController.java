package com.mahan.UI.Controller;

import com.mahan.UI.Model.Person;
import com.mahan.biz.UserBLO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        UserBLO myBLO = new UserBLO();
        HttpSession session = request.getSession();

        try {
            Person person = myBLO.findUser(request.getParameter("userName"));
            session.setAttribute("user", person);
            if ((person != null) && (person.getPassword().equals(request.getParameter("password")))) {
                HashMap<String, String> menueItems = new HashMap<>();
                switch (person.getRole()) {
                    case 0: {
                        menueItems.put("Manage Students", "/admin/student/showList");
                        menueItems.put("Manage Teachers", "/admin/teacher/showList");
                        menueItems.put("Manage Courses", "/admin/course/showList");
                        person.setMenueItems(menueItems);
                        person.setHomePageAddress("/adminhome.jsp");
                        response.sendRedirect(person.getHomePageAddress());
                        break;
                    }
                    case 1: {
                        menueItems.put("Register", "/student/showCourses");
                        menueItems.put("Transcript", "/student/showTranscript");
                        person.setMenueItems(menueItems);
                        person.setHomePageAddress("/studenthome.jsp");
                        response.sendRedirect(person.getHomePageAddress());
                        break;
                    }
                    case 2: {
                        menueItems.put("Set Grades", "/teacher/showCourses/");
                        person.setMenueItems(menueItems);
                        person.setHomePageAddress("/teacherhome.jsp");
                        response.sendRedirect(person.getHomePageAddress());
                        break;
                    }
                }

            } else {
                response.sendRedirect("/loginfail.jsp");
            }


        } catch (Exception e1) {
            response.sendRedirect("/ErrorHandler");
            System.out.println(e1.getMessage());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
