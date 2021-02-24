package com.src.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <code> CommonUtilites </code> class defines Common
 * <code>Utilities</code>.
 * 
 * @author Ishaq Tasleem
 * @version 1.0
 *
 */
public class CommonUtilites {
	public static final Logger logger = LoggerFactory.getLogger(CommonUtilites.class);

	private CommonUtilites() {
		throw new IllegalStateException("Common Utilites Class");
	}

	/**
	 * getCurrentDateInNewFormat- To get the Current Date in New Format.
	 * 
	 * @return Date Format.
	 */
	public static String getCurrentDateInNewFormat() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	/**
	 * getCurrentDateInNewFormat- To get the Current Date in New Format.
	 * 
	 * @return Date Format.
	 */
	public static String getCurrentDateIndianFormat() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	/**
	 * genRandomNumeric - To get Random  Numeric Data.
	 * 
	 * @return Random Data.
	 */
	public static String genRandomAplhaNumeric() {
		return RandomStringUtils.randomAlphabetic(10);
	}

	/**
	 * getPreviousDate - To get the day before date (Present Date-1).
	 * 
	 * @return Previous Data.
	 */
	public static String getPreviousDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		return dateFormat.format(cal.getTime());
	}
	
	public static String getFileExtension(String fileName) {
		String extension = null;
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    extension = fileName.substring(i);
		}
		return extension;
	}
}
