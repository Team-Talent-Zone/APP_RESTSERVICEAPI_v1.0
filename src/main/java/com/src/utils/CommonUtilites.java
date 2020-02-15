package com.src.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class CommonUtilites {

	public static String getCurrentDate() {
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	public static String getCurrentDateInNewFormat() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	public static String genRandomAlphaNumeric() {
		String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int n = alphabet.length();
		String result = "";
		Random r = new Random();
		for (int i = 0; i < 10; i++)
			result = result + alphabet.charAt(r.nextInt(n));
		return result;
	}
	
	public static String getPreviousDate() {
 		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(cal.getTime());
	}
}
