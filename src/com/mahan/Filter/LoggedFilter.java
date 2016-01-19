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
@WebFilter(filterName = "LoggedFilter")
public class LoggedFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
      HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        HttpServletResponse response = (HttpServletResponse) resp;
        Person user = (Person) session.getAttribute("user");
        if (user != null) {
            switch (user.getRole()){
                case 0:{response.sendRedirect("/adminhome.jsp");
                    break;}
                case 1:{response.sendRedirect("/studenthome.jsp");
                    break;}
                case 2:{response.sendRedirect("/teacherhome.jsp");
                    break;}
            }
        } else {
            chain.doFilter(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
