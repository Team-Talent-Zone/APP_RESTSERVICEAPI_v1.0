package com.src.testsamplecode;

import org.sonarsource.scanner.api.internal.shaded.minimaljson.Json;
import org.sonarsource.scanner.api.internal.shaded.minimaljson.JsonValue;

public class TestDBConnection {
	public static void main(String[] args) throws Exception {
		// Class.forName( "com.mysql.jdbc.Driver" ); // do this in init
		// // edit the jdbc url
		// Connection conn = DriverManager.getConnection(
		// "jdbc:mysql://54.159.110.166:3306/RESTDBAPI?user=phpmyadminuser&password=teamtalent@2019");
		// Statement st = conn.createStatement();
		// ResultSet rs = st.executeQuery( "select * from table" );
		String message = " Invalid Found";
		String reason = "Invalid";

		String json = "{\"error\" : \"" + message + "\"," + "\"reason\" : \"" + reason + "\"}";
		JsonValue jVal = Json.parse(json);
		System.out.println(jVal);
	}
}
