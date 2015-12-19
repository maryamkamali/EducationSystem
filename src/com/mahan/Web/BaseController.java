package com.mahan.Web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 921227 on 12/5/2015.
 */
@WebServlet(name = "BaseController")
public class BaseController extends HttpServlet {
    protected HttpServletRequest req;
    protected HttpServletResponse res;
    protected String[] address;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        req = request;
        res = response;
        callController("Post");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        req = request;
        res = response;
        callController("Get");
    }


    private void callController(String methodName) {
        String host = "http://" + req.getHeader("host");
        String url = req.getRequestURI().replace(host, "");
        address = url.split("/");
        String action = null;
        if (address.length == 4) {
            Long id = Long.parseLong(address[3]);
            req.setAttribute("id", id);
            action = address[2];
        } else if (address.length == 3) {
            action = address[2];
        } else if (address.length == 2) {
            if (req.getSession().getAttribute("role_course").equals("student"))
                action = "showFacultyCourse";
            else
                action = "showList";
        }
        try {

            Method method = this.getClass().getMethod(action, null);
            method.invoke(this, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
