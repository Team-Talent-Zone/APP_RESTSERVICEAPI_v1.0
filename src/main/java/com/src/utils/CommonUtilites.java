package com.src.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

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
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	/**
	 * genRandomAlphaNumeric - To get Random Alpha Numeric Data.
	 * 
	 * @return Random Data.
	 */
	public static String genRandomAlphaNumeric() {
		String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int n = alphabet.length();
		String result = "";
		Random r;
		try {
			r = SecureRandom.getInstanceStrong();
			for (int i = 0; i < 10; i++)
				result = result + alphabet.charAt(r.nextInt(n));
		} catch (NoSuchAlgorithmException e) {
			logger.debug("Exception in CommonUtilites-genRandomAlphaNumeric():" + e);
		}
		return result;
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
		return dateFormat.format(cal.getTime());
	}
}
