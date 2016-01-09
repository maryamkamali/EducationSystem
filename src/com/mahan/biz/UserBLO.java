package com.mahan.biz;

import com.mahan.Data.UserDAOImpl;
import com.mahan.UI.Model.*;
import javax.naming.NamingException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 921227 on 11/24/2015.
 */
public class UserBLO {

    public Person findUser(String userName)
            throws SQLException, NamingException, IOException, ClassNotFoundException {
        UserDAOImpl dao=new UserDAOImpl();
        dao.connect();
        Person person = null;
        ResultSet rs = dao.selectUser(userName);

        while (rs.next()) {
            person = new Person();
            person.setUserName(rs.getString("UserName"));
            person.setPassword(rs.getString("Password"));
            person.setdId(rs.getLong("Id"));
            person.setRole(rs.getInt("role"));
        }
        return person;
    }

}
