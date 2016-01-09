package com.mahan.biz;

import com.mahan.Data.AdminDAOImpl;
import com.mahan.UI.Model.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 921227 on 11/24/2015.
 */
public class AdminBLO extends UserBLO {
    AdminDAOImpl dao = new AdminDAOImpl();

    public void createPerson(Person person) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();
        dao.insertUser(person.getFirstname(), "123", 0);
        dao.insertAdmin((Admin) person);
    }

    public void editPerson(Person person, Long editId) throws SQLException, IOException, ClassNotFoundException {
        dao.connect();

//            dao.insertAdmin((Admin) person, editId);
    }
}
