package com.shoppingcart.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	public static Connection getConnection()
			throws ClassNotFoundException, SQLException{
		if(connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart", "root","A1c3e5g7!");
			System.out.print("connected");
		}
		return connection;
	}

}
