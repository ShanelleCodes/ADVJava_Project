package com.shoppingcart.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shoppingcart.model.User;



public class UserDoa {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet res;
	
	public UserDoa(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
		try {
			query = "select * from users where email=? and password=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			res = pst.executeQuery();
			
			if(res.next()) {
				user = new User();
				user.setId(res.getInt("id"));
				user.setName(res.getString("name"));
				user.setEmail(res.getString("email"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return user;
		
	}
	
	public boolean registerUser(User user) {
        try {
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement pst = this.con.prepareStatement(query)) {
                pst.setString(1, user.getName());
                pst.setString(2, user.getEmail());
                pst.setString(3, user.getPassword());
                
                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }return false;
    }

}
