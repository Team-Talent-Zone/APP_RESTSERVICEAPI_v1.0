package com.src.helper;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.src.constant.UtilConfig;

public class S3AWSHelper {

	final Logger logger = LoggerFactory.getLogger(S3AWSHelper.class);

	public String uploadAvatarsInS3(File inputFile, int userid) {
		String fileExtension = getFileExtension(inputFile);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		try {
			logger.debug("Attempting to upload profile picture of user");

			String fileName = getFileNameWithoutExtension(inputFile) + "_userProfile." + fileExtension;
			String folderToCreate = UtilConfig.FOLDER_USER_AVATAR + UtilConfig.SUFFIX + userid;
			String docURL = createFolderOrUploadObject(UtilConfig.S3_BUCKETNAME_PROFILES, fileName, s3, inputFile,
					folderToCreate);
			return docURL;

		} catch (AmazonServiceException ase) {
			logger.error("Caught an AmazonServiceException, which means your request made it "
					+ "to Amazon S3, but was rejected with an error response for some reason.");
			logger.error("Error Message:    " + ase.getMessage());
			logger.error("HTTP Status Code: " + ase.getStatusCode());
			logger.error("AWS Error Code:   " + ase.getErrorCode());
			logger.error("Error Type:       " + ase.getErrorType());
			logger.error("Request ID:       " + ase.getRequestId());

		} catch (AmazonClientException ace) {
			logger.error("Caught an AmazonClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with S3, "
					+ "such as not being able to access the network.");
			logger.error("Error Message: " + ace.getMessage());

		}
		return null;
	}

	public String uploadBgDocsInS3(File inputFile, int userid) {
		String fileExtension = getFileExtension(inputFile);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		try {
			logger.debug("Attempting to upload documents relared to background of the freelance user");
			String fileName = getFileNameWithoutExtension(inputFile) + "." + fileExtension;
			String folderToCreate = UtilConfig.FOLDER_USER_AVATAR + UtilConfig.SUFFIX + userid + UtilConfig.SUFFIX
					+ UtilConfig.FOLDER_BG;
			String docURL = createFolderOrUploadObject(UtilConfig.S3_BUCKETNAME_PROFILES, fileName, s3, inputFile,
					folderToCreate);
			return docURL;

		} catch (AmazonServiceException ase) {
			logger.error("Caught an AmazonServiceException, which means your request made it "
					+ "to Amazon S3, but was rejected with an error response for some reason.");
			logger.error("Error Message:    " + ase.getMessage());
			logger.error("HTTP Status Code: " + ase.getStatusCode());
			logger.error("AWS Error Code:   " + ase.getErrorCode());
			logger.error("Error Type:       " + ase.getErrorType());
			logger.error("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			logger.error("Caught an AmazonClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with S3, "
					+ "such as not being able to access the network.");
			logger.error("Error Message: " + ace.getMessage());
		}
		return null;
	}

	public String uploadWidgetPicsInS3(File inputFile, int userid) {

		String fileExtension = getFileExtension(inputFile);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		try {
			logger.debug("Attempting to upload widgets of the new host site for the CBA user");
			String fileName = getFileNameWithoutExtension(inputFile) + "." + fileExtension;
			String folderToCreate = UtilConfig.FOLDER_USER_AVATAR + UtilConfig.SUFFIX + userid + UtilConfig.SUFFIX
					+ UtilConfig.FOLDER_WIDGETS;
			String docURL = createFolderOrUploadObject(UtilConfig.S3_BUCKETNAME_PROFILES, fileName, s3, inputFile,
					folderToCreate);
			return docURL;

		} catch (AmazonServiceException ase) {
			logger.error("Caught an AmazonServiceException, which means your request made it "
					+ "to Amazon S3, but was rejected with an error response for some reason.");
			logger.error("Error Message:    " + ase.getMessage());
			logger.error("HTTP Status Code: " + ase.getStatusCode());
			logger.error("AWS Error Code:   " + ase.getErrorCode());
			logger.error("Error Type:       " + ase.getErrorType());
			logger.error("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			logger.error("Caught an AmazonClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with S3, "
					+ "such as not being able to access the network.");
			logger.error("Error Message: " + ace.getMessage());
		}
		return null;
	}

	private String createFolderOrUploadObject(String bucketName, String folderName, AmazonS3 client, File inputFile,
			String fileName) {
		logger.debug("Uploading the File to S3");
		// create meta-data for your folder and set content-length to 0
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName + UtilConfig.SUFFIX + fileName,
				inputFile).withCannedAcl(CannedAccessControlList.PublicRead);// Making the
																				// URL
																				// public to
																				// access
																				// it.
		// send request to S3 to create folder
		client.putObject(putObjectRequest);
		logger.debug("Returning the URL of uploaded document in the S3");
		return client.getUrl(bucketName, folderName + UtilConfig.SUFFIX + fileName).toString();

	}

	private String getFileExtension(File file) {
		logger.debug("Attempting to get extension of File uploaded");
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	private String getFileNameWithoutExtension(File file) {
		String fileName = file.getName();
		if (fileName.indexOf(".") > 0)
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		return fileName;
	}

}
