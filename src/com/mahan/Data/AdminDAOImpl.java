package com.mahan.Data;

import com.mahan.UI.Model.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 921227 on 11/24/2015.
 */
public class AdminDAOImpl extends BaseDAO implements AdminDAO{

    public void insertAdmin(Admin admin) throws SQLException {
        ResultSet rs = selectUser(admin.getFirstname());
        Long Id = null;
        while (rs.next()) {
            Id = rs.getLong("Id");
        }
        String query = "insert into [dbo].[Education_Admin]  values('" + Id + "','" + admin.getFirstname() + "','" + admin.getLastname() + "'," + admin.getNationalNo() + ",'2004-10-10'"
                + ",'" + admin.getGender() + "','" + admin.getEmail() + "','" + admin.getTel() + "','" + admin.getAddress() + "')";
        java.sql.Statement stm = con.createStatement();
        stm.executeUpdate(query);
    }

}
