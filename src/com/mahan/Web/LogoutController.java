package com.mahan.Web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by 921227 on 1/3/2016.
 */
public class LogoutController extends BaseController {
    public void logout(){
        try {
            req.getSession().invalidate();
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
