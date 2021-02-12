package com.src.helper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.src.constant.UtilityConfig;
import com.src.entity.UploadUtilEntity;

/**
 * This <code>S3AWSHelper</code>defines uploading avatars, Background documents
 * and files.
 * 
 * @author Ishaq.
 * @version 1.0
 *
 */
public class S3AWSHelper {
	final Logger logger = LoggerFactory.getLogger(S3AWSHelper.class);

	/**
	 * This method is for Uploading avatars in s3.
	 * 
	 * @param inputFile
	 * @param userid
	 * @exception AmazonServiceException
	 */
	public String uploadAvatarsInS3(UploadUtilEntity uploadUtilEntity) {
		logger.debug("=====Inside the S3AWSHelper Class uploadAvatarsInS3 Method======");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(UtilityConfig.API_KEY, UtilityConfig.API_KEY_SECERT);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
		try { 
			logger.debug("=====Attempting to upload profile picture of user====== Bucket Name "
					+ UtilityConfig.S3_BUCKETNAME_AVATAR);
			String base64Image = uploadUtilEntity.getBase64image().split(",")[1];
	        byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Image);
			String folderToCreate = UtilityConfig.FOLDER_USER_AVATAR + UtilityConfig.SUFFIX + uploadUtilEntity.getUserid();
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(imageBytes.length);
			metadata.setContentType("image/png");
			metadata.setCacheControl("public, max-age=31536000");
			InputStream fis = new ByteArrayInputStream(imageBytes);
			String filename = uploadUtilEntity.getFilename();
			PutObjectRequest putObjectRequest = new PutObjectRequest(UtilityConfig.S3_BUCKETNAME_AVATAR,
					folderToCreate + UtilityConfig.SUFFIX + filename , fis,metadata)
							.withCannedAcl(CannedAccessControlList.PublicRead);
			s3.putObject(putObjectRequest);
			logger.debug("Returning the URL of uploaded document in the S3");
			return s3.getUrl(UtilityConfig.S3_BUCKETNAME_AVATAR, folderToCreate + UtilityConfig.SUFFIX + filename).toString();
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

	/**
	 * This method is for uploading background document in s3.
	 * 
	 * @param inputFile
	 * @param userid
	 * @exception AmazonServiceException
	 */
	public String uploadBgDocsInS3(UploadUtilEntity uploadUtilEntity) {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(UtilityConfig.API_KEY, UtilityConfig.API_KEY_SECERT);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
		try {
			logger.debug(
					"====Attempting to upload documents relared to background of the skilled worker===== Bucket name "
							+ UtilityConfig.S3_BUCKETNAME_BG_DOCS);
			String base64Image = uploadUtilEntity.getBase64image().split(",")[1];
	        byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Image);
			String folderToCreate = UtilityConfig.FOLDER_FREELANCE_BG + UtilityConfig.SUFFIX + uploadUtilEntity.getUserid();
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(imageBytes.length);
			metadata.setContentType("application/pdf");
			metadata.setCacheControl("public, max-age=31536000");
			InputStream fis = new ByteArrayInputStream(imageBytes);
			PutObjectRequest putObjectRequest = new PutObjectRequest(UtilityConfig.S3_BUCKETNAME_BG_DOCS,
					folderToCreate + UtilityConfig.SUFFIX + uploadUtilEntity.getFilename(), fis,metadata)
							.withCannedAcl(CannedAccessControlList.PublicRead);
			s3.putObject(putObjectRequest);
			logger.debug("Returning the URL of uploaded document in the S3");
			return s3.getUrl(UtilityConfig.S3_BUCKETNAME_BG_DOCS, folderToCreate + UtilityConfig.SUFFIX + uploadUtilEntity.getFilename()).toString();

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

	/**
	 * This method is for uploading widget pictures in s3.
	 * 
	 * @param inputFile
	 * @param userid
	 * @exception AmazonServiceException
	 */
	public String uploadWidgetPicsInS3(UploadUtilEntity uploadUtilEntity) {

		BasicAWSCredentials awsCreds = new BasicAWSCredentials(UtilityConfig.API_KEY, UtilityConfig.API_KEY_SECERT);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

		try {
			logger.debug(
					"=======Attempting to upload widgets of the new host site for the CBA user ===== Bucket Name : "
							+ UtilityConfig.S3_BUCKETNAME_SITE_WIDGETS);
			String base64Image = uploadUtilEntity.getBase64image().split(",")[1];
	        byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Image);
				String folderToCreate = UtilityConfig.FOLDER_SITE_WIDGETS + UtilityConfig.SUFFIX + uploadUtilEntity.getUserid();
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(imageBytes.length);
			metadata.setContentType("image/png");
			metadata.setCacheControl("public, max-age=31536000");
			InputStream fis = new ByteArrayInputStream(imageBytes);
			PutObjectRequest putObjectRequest = new PutObjectRequest(UtilityConfig.S3_BUCKETNAME_SITE_WIDGETS,
					folderToCreate + UtilityConfig.SUFFIX + uploadUtilEntity.getFilename(), fis,metadata)
							.withCannedAcl(CannedAccessControlList.PublicRead);
			s3.putObject(putObjectRequest);
			logger.debug("Returning the URL of uploaded document in the S3");
			return s3.getUrl(UtilityConfig.S3_BUCKETNAME_SITE_WIDGETS, folderToCreate + UtilityConfig.SUFFIX + uploadUtilEntity.getFilename()).toString();
	

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


}
