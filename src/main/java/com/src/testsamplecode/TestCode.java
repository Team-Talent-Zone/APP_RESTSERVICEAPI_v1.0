package com.src.testsamplecode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.velocity.VelocityContext;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestCode {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getFileExtension("test.jpeg"));
		//CalendarDemo();
	}
	
	public static String getFileExtension(String fileName) {
		String extension = null;
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    extension = fileName.substring(i);
		}
		return extension;
	}
	public static void CalendarDemo()  {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_WEEK, 7);
		System.out.println(dateFormat.format(cal.getTime()));
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
