package com.src.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.src.constant.UtilityConfig;
import com.src.entity.UtilEntity;
import com.src.helper.S3AWSHelper;
import com.src.helper.SendEmailHelper;
import com.src.helper.TranslateHelper;

/**
 * The <code> UtilityServiceImpl </code> class is Utility service for emails.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@Service("utilService")
public class UtilityServiceImpl extends AbstractServiceManager implements UtilityService {
	final static Logger logger = LoggerFactory.getLogger(UtilityServiceImpl.class);

	/**
	 * This method is for sending emails.
	 */
	public UtilEntity sendEmail(UtilEntity utilEntity) throws Exception {
		String applicationName = referenceLookUpDAO.getReferenceLookupByShortKey("appname");
		String apiKey = referenceLookUpDAO.getReferenceLookupByShortKey("googleapikey");
		SendEmailHelper emailHelper = new SendEmailHelper();
		return emailHelper.prepareEmail(utilEntity , apiKey, applicationName);
	}

	/**
	 * This method is for uploading avatas in S3.
	 */
	public String uploadAvatarsInS3(File inputFile, int userid) {
		S3AWSHelper s3awsHelper = new S3AWSHelper();
		return s3awsHelper.uploadAvatarsInS3(inputFile, userid);
	}

	/**
	 * This method is for uploading Background document in S3.
	 */
	public String uploadBgDocsInS3(File inputFile, int userid) {
		S3AWSHelper s3awsHelper = new S3AWSHelper();
		return s3awsHelper.uploadBgDocsInS3(inputFile, userid);
	}

	/**
	 * This method is for uploading widget picture in S3.
	 */
	public String uploadWidgetPicsInS3(File inputFile, int userid) {
		S3AWSHelper s3awsHelper = new S3AWSHelper();
		return s3awsHelper.uploadWidgetPicsInS3(inputFile, userid);
	}

	/**
	 * This method is translate text.
	 */
	public String translateText(String targetLanguage, String targetText) {
		String applicationName = referenceLookUpDAO.getReferenceLookupByShortKey("appname");
		String apiKey = referenceLookUpDAO.getReferenceLookupByShortKey("googleapikey");

		TranslateHelper translateHelper = new TranslateHelper();
		return translateHelper.translateText(targetLanguage, targetText, UtilityConfig.MIME_TYPE_TEXT, apiKey,
				applicationName);
	}

}