package com.src.testsamplecode;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {
	public static void main(String[] args) throws Exception {
		String uName = "phpmyadmindevuser";
		String uPswd = "teamtalent@2019";
		Class.forName("com.mysql.jdbc.Driver"); // do this in init
		//edit the jdbc url
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://3.82.192.92:3306/RESTDBAPI?" + "user=" + uName + "&password=" + uPswd);
		// Statement st = conn.createStatement();
		// ResultSet rs = st.executeQuery( "select * from table" );

		// String message = " Invalid Found";
		// String reason = "Invalid";

		// String json = "{\"error\" : \"" + message + "\"," + "\"reason\" : \"" +
		// reason + "\"}";
		// JsonValue jVal = Json.parse(json);
		System.out.println(conn);
	}
}
