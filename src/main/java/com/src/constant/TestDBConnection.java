package com.src.constant;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {
	 public static void main(String [] args) throws Exception {
	        // Class.forName( "com.mysql.jdbc.Driver" ); // do this in init
	        // // edit the jdbc url 
	        Connection conn = DriverManager.getConnection( 
	            "jdbc:mysql://3.93.172.194:3306/RESTDBAPI?user=phpmyadminuser&password=teamtalent@2019");
	        // Statement st = conn.createStatement();
	        // ResultSet rs = st.executeQuery( "select * from table" );

	        System.out.println("Connected?");
	    }
}
 