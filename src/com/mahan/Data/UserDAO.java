package com.mahan.Data;

import com.mahan.Util.ConfigGenerator;
import com.mahan.UI.Model.Admin;
import com.mahan.UI.Model.Course;
import com.mahan.UI.Model.Student;
import com.mahan.UI.Model.Teacher;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 921227 on 11/24/2015.
 */
public interface UserDAO {

    public void connect() throws ClassNotFoundException, SQLException, IOException ;

    public void deleteUser(Long userId) throws SQLException ;

    public ResultSet selectUser(String userName) throws SQLException;

    public void insertUser(String firstname, String password, int role) throws SQLException;

}
