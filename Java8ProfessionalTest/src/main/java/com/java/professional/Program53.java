package com.java.professional;

import java.sql.*;

public class Program53 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mysql");
		String query = "select id from employee";
		
		try ( Statement stmt =  conn.createStatement()){
			ResultSet rs = stmt.executeQuery(query);
			stmt.execute("select * from customer");
			while(rs.next()) {
				//
				System.out.println("id = "+rs.getInt("id"));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
