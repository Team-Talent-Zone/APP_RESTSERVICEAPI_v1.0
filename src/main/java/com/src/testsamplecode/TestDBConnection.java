package com.src.testsamplecode;

import java.sql.Connection;
import java.sql.DriverManager;

import org.sonarsource.scanner.api.internal.shaded.minimaljson.Json;
import org.sonarsource.scanner.api.internal.shaded.minimaljson.JsonValue;

public class TestDBConnection {
	public static void main(String[] args) throws Exception {
		 Class.forName( "com.mysql.jdbc.Driver" ); // do this in init
		// // edit the jdbc url
	 Connection conn = DriverManager.getConnection(
		  "jdbc:mysql://3.82.192.92:3306/RESTDBAPI?user=phpmyadmindevuser&password=teamtalent@2019");
		// Statement st = conn.createStatement();
		// ResultSet rs = st.executeQuery( "select * from table" );
	 
	//	String message = " Invalid Found";
		//String reason = "Invalid";

		//String json = "{\"error\" : \"" + message + "\"," + "\"reason\" : \"" + reason + "\"}";
		//JsonValue jVal = Json.parse(json);
		System.out.println(conn);
	}
}
