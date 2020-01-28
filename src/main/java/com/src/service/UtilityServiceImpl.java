package com.src.service;

import java.io.File;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.src.entity.UtilEntity;
import com.src.helper.S3AWSHelper;
import com.src.helper.SendEmailHelper;

@Service("utilService")
public class UtilityServiceImpl implements UtilityService {

	final static Logger logger = LoggerFactory.getLogger(UtilityServiceImpl.class);

	public UtilEntity sendEmail(UtilEntity utilEntity) throws JSONException {
		SendEmailHelper emailHelper = new SendEmailHelper();
		return emailHelper.sendEmail(utilEntity);
	}

	public String uploadAvatarsInS3(File inputFile, int userid) {

		S3AWSHelper s3awsHelper = new S3AWSHelper();
		return s3awsHelper.uploadAvatarsInS3(inputFile, userid);
	}

	public String uploadBgDocsInS3(File inputFile, int userid) {

		S3AWSHelper s3awsHelper = new S3AWSHelper();
		return s3awsHelper.uploadBgDocsInS3(inputFile, userid);
	}

	public String uploadWidgetPicsInS3(File inputFile, int userid) {
		S3AWSHelper s3awsHelper = new S3AWSHelper();
		return s3awsHelper.uploadWidgetPicsInS3(inputFile, userid);
	}

}