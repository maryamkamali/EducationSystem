package com.mahan.Filter;



import com.mahan.UI.Model.Person;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by maryam.kamali on 1/5/2016.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session =request.getSession();
        HttpServletResponse response = (HttpServletResponse) resp;
        Person user = (Person) session.getAttribute("user");
//        String path = request.getPathInfo();
        String path = String.valueOf(request.getRequestURL());
        path = path.replace("http://localhost:8080/","");
        if ((path.equals("login.jsp")) || (path.equals("")) || (path.equals("loginController")) || (path.equals("favicon.ico"))){
                chain.doFilter(req,resp);
        } else {
            if (user == null) {
                response.sendRedirect("login.jsp");
            } else {
                chain.doFilter(req,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
