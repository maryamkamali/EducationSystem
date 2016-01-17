package com.mahan.Web;

import com.mahan.biz.BLO;
import com.mahan.biz.Person;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        BLO myBLO = new BLO();
        HttpSession session = request.getSession();

        try {
            Person person = myBLO.findUser(request.getParameter("userName"));
            session.setAttribute("user", person);
            if ((person != null) && (person.getPassword().equals(request.getParameter("password")))) {
              switch (person.getRole()){
                  case 0:{response.sendRedirect("/adminhome.jsp");
                  break;}
                  case 1:{response.sendRedirect("/studenthome.jsp");
                  break;}
                  case 2:{response.sendRedirect("/teacherhome.jsp");
                  break;}
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
