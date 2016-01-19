package com.mahan.Filter;

import com.mahan.UI.Model.Person;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by maryam.kamali on 1/9/2016.
 */
@WebFilter(filterName = "RoleFilter")
public class RoleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        HttpServletResponse response = (HttpServletResponse) resp;
        Person user = (Person) session.getAttribute("user");
        String path = String.valueOf(request.getRequestURL());
        path = path.replace("http://localhost:8080/", "");
//        path.equals("")
        if (user == null || path.equals("accessdenied.jsp") || path.equals("createbean.jsp") || path.equals("error.jsp") || path.equals("header.jsp") || path.equals("login.jsp") || path.equals("loginfail.jsp")) {
            chain.doFilter(req, resp);
        } else if (user.getRole() == 0 && (path.equals("adminhome.jsp") || (path.equals("courseedit.jsp")) || (path.equals("coursenew.jsp") || path.equals("courselist.jsp")
                || path.equals("studentedit.jsp") || path.equals("studentnew.jsp") || path.equals("studentlist.jsp") || path.equals("teacheredit.jsp") || path.equals("teachernew.jsp") || path.equals("teacherlist.jsp") ))) {
            chain.doFilter(req, resp);
        } else if (user.getRole() == 1 && (path.equals("studenthome.jsp") || (path.equals("studenttranscript.jsp")|| path.equals("studentcourses.jsp") ))) {
            chain.doFilter(req, resp);
        } else if (user.getRole() == 2 && (path.equals("teacherhome.jsp") || (path.equals("/teachercourses.jsp")||path.equals("")))) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendRedirect("/accessdenied.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
