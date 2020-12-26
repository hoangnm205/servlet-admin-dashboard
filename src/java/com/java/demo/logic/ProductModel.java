/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.demo.logic;

import com.java.demo.entity.Product;
import com.java.demo.utils.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangnghiem
 */
public class ProductModel {
    
    public int count() throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "SELECT COUNT(*) as TOTAL FROM PRODUCTS";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("TOTAL");
        }
        return 0;
    }
    
    public List<Product> list(int limit, int page) throws Exception {
        List<Product> products = new ArrayList<>();
        Connection conn = DBConnector.getConnection();
        
        /**
         * page = 1 --> offset = 0
         * page = 2 --> offset = 10
         * page = 3 --> offset = 20
         * ...
         * page = n --> offset = (n - 1)*limit
         */
        int offset = (page - 1) * limit;
        
        String sql = "SELECT * FROM PRODUCTS LIMIT ? OFFSET ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, limit);
        pstmt.setInt(2, offset);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setCategory(rs.getInt("cateId"));
            p.setHot(rs.getBoolean("isHot"));
            
            products.add(p);
        }
        return products;   
    }
    
}
