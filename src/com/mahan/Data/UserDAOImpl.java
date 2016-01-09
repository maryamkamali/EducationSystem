package com.mahan.Data;

import com.mahan.Util.ConfigGenerator;

import java.io.IOException;
import java.sql.*;

/**
 * Created by 921227 on 1/6/2016.
 */
public class UserDAOImpl {
    Connection con;
    public ResultSet selectUser(String userName) throws SQLException {

        String query = "select * from [JavaTraining].[dbo].[Education_User] where [UserName]=" + "'" + userName + "'";
        Statement stm = con.createStatement();
        ResultSet resultSet = stm.executeQuery(query);
        return resultSet;

    }

    public void insertUser(String firstname, String password, int role) throws SQLException {
        String query = "insert into [JavaTraining].[dbo].[Education_User]  values('" + firstname + "','" + password + "','" + role + "')";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }
    public void connect() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = new ConfigGenerator().getPropValues();
        con = DriverManager.getConnection(connectionURL);
    }
}
