package com.src.testsamplecode;

import org.apache.velocity.VelocityContext;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestCode {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String dil ="|303|499|";
	    String pipeDelimited = "|Google|Amazon|Microsoft|Facebook|";

	    String phone = " ;3456789";
	    String[] output = phone.split(";");
		System.out.println(output.length);

		for (String serviceid : output) {
			System.out.println(serviceid);
		}
	}
	public static VelocityContext generateVelocityObject(JSONArray jsonArray) throws Exception {
		VelocityContext context = new VelocityContext();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject objectInArray = jsonArray.getJSONObject(i);
			String[] elementNames = JSONObject.getNames(objectInArray);
			for (String elementName : elementNames) {
				String value = objectInArray.getString(elementName);
				context.put(elementName, value);
			}
		}
		return context;
	}

}
