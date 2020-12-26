/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.demo.logic;

import com.java.demo.entity.Admin;
import com.java.demo.utils.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hoangnghiem
 */
public class Authenticator {
 
    public Admin login(String email, String password) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "SELECT * FROM ADMIN WHERE email = ? AND password = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Admin(rs.getInt("id"), rs.getString("email"), "");
        }
        return null;
    }
}
