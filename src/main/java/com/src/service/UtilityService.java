package com.src.service;

import com.src.entity.UploadUtilEntity;
import com.src.entity.UtilEntity;

/**
 * The <code> UtilityService </code> Interface is Utility service for emails.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
public interface UtilityService {
	/**
	 * This Method is for Sending Emails.
	 * 
	 * @param utilEntity
	 * @throws Exception
	 */
	public UtilEntity sendEmail(UtilEntity utilEntity) throws Exception;

	/**
	 * This method is for uploading avatar in S3.
	 * 
	 * @param inputFile
	 * @param userid
	 */
	public String uploadAvatarsInS3(UploadUtilEntity uploadUtilEntity);

	/**
	 * This method is for uploading Background documents in S3.
	 * 
	 * @param inputFile
	 * @param userid
	 */
	public String uploadBgDocsInS3(UploadUtilEntity uploadUtilEntity);

	/**
	 * This method is for uploading widget pictures in S3.
	 * 
	 * @param inputFile
	 * @param userid
	 */
	public String uploadWidgetPicsInS3(UploadUtilEntity uploadUtilEntity);

	/**
	 * This method is for Translating Text.
	 * 
	 * @param targetLanguage
	 * @param targetText
	 * @throws Exception
	 */
	public String translateText(String targetLanguage, String targetText);

}
