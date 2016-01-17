package com.mahan.Filter;

import com.mahan.biz.Person;

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

        if (user == null || path.equals("accessdenied.jsp")) {
            chain.doFilter(req, resp);
        } else if (user.getRole() == 0 && (path.equals("adminhome.jsp") || (path.equals("courseadding.jsp")) || (path.equals("studentadding.jsp")))) {
            chain.doFilter(req, resp);
        } else if (user.getRole() == 1 && (path.equals("studenthome.jsp") || (path.equals("transcript.jsp")))) {
            chain.doFilter(req, resp);
        } else if (user.getRole() == 2 && (path.equals("teacherhome.jsp") || (path.equals("coursesteacher.jsp")))) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendRedirect("/accessdenied.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
