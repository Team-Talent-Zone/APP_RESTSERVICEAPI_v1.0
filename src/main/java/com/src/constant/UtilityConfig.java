package com.src.constant;

/**
 * The <code> UtilityConfig </code> class contains constants for
 * <code>Utility</code>.
 * 
 * @author Ishaq.
 * @version 1.0
 */
public class UtilityConfig {

	private UtilityConfig() {
		super();
	}

	/*
	 * Email SMTP Configuration Details
	 */
	public static final String HOST_DEV_SMTP = "email-smtp.us-east-1.amazonaws.com";
	public static final String USERNAME_DEV_SMTP = "AKIA4COD2FPEFOPKUJF5";
	public static final String PSWD_DEV_SMTP = "BFt46X+ez01UXbFJSNKy6mMf9cxHfCJt5UMMz0ApfYLo";

	/*
	 * AWS S3 Bucket Configuration Details
	 */
	public static final String PROJECT_ID_DEV = "astral-scout-261009";
	public static final String SUFFIX = "/";
	public static final String S3_BUCKETNAME_AVATAR = "platform-user-avatars";
	public static final String S3_BUCKETNAME_BG_DOCS = "platform-freelancer-bg-documents";
	public static final String S3_BUCKETNAME_SITE_WIDGETS = "platform-site-widgets";
	public static final String FOLDER_USER_AVATAR = "avatars";
	public static final String FOLDER_FREELANCE_BG = "bgcheck";
	public static final String FOLDER_SITE_WIDGETS = "widgets";
	public static final String FOLDER_WIDGETS = "WIDGETS";

	/*
	 * Email Template short keys details
	 * 
	 */
	public static final String EMAIL_SHORTKEY_VERIFYEMAILADDRESS = "eventgen28";
	public static final String PREFERED_LANGUAGE_TELUGU = "te";
	public static final String PREFERED_LANGUAGE_HINDI = "hi";
	public static final String MIME_TYPE_HTML = "html";
	public static final String MIME_TYPE_TEXT = "text";
}
