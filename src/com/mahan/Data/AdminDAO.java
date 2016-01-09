package com.mahan.Data;

import com.mahan.UI.Model.Admin;
import com.mahan.UI.Model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 921227 on 11/24/2015.
 */
public interface AdminDAO {

    public void insertAdmin(Admin admin) throws SQLException;
}
