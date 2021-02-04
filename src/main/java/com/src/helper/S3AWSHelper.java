package com.src.helper;

import java.io.File;

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
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.src.constant.UtilityConfig;

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
	public String uploadAvatarsInS3(File inputFile, int userid) {
		String fileExtension = getFileExtension(inputFile);
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(UtilityConfig.API_KEY, UtilityConfig.API_KEY_SECERT);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
		try {
			logger.debug("=====Attempting to upload profile picture of user====== Bucket Name " +UtilityConfig.S3_BUCKETNAME_AVATAR);

			String fileName = getFileNameWithoutExtension(inputFile) + "_avatar." + fileExtension;
			String folderToCreate = UtilityConfig.FOLDER_USER_AVATAR + UtilityConfig.SUFFIX + userid;
			String docURL = createFolderOrUploadObject(UtilityConfig.S3_BUCKETNAME_AVATAR, fileName, s3, inputFile,
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

	/**
	 * This method is for uploading background document in s3.
	 * 
	 * @param inputFile
	 * @param userid
	 * @exception AmazonServiceException
	 */
	public String uploadBgDocsInS3(File inputFile, int userid) {
		String fileExtension = getFileExtension(inputFile);
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(UtilityConfig.API_KEY, UtilityConfig.API_KEY_SECERT);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	
		try {
			logger.debug("====Attempting to upload documents relared to background of the skilled worker===== Bucket name " + UtilityConfig.S3_BUCKETNAME_BG_DOCS);
			String fileName = getFileNameWithoutExtension(inputFile) + "." + fileExtension;
			String folderToCreate = UtilityConfig.FOLDER_FREELANCE_BG + UtilityConfig.SUFFIX + userid;
			String docURL = createFolderOrUploadObject(UtilityConfig.S3_BUCKETNAME_BG_DOCS, fileName, s3, inputFile,
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

	/**
	 * This method is for uploading widget pictures in s3.
	 * 
	 * @param inputFile
	 * @param userid
	 * @exception AmazonServiceException
	 */
	public String uploadWidgetPicsInS3(File inputFile, int userid) {

		String fileExtension = getFileExtension(inputFile);
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(UtilityConfig.API_KEY, UtilityConfig.API_KEY_SECERT);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	
		try {
			logger.debug("=======Attempting to upload widgets of the new host site for the CBA user ===== Bucket Name : "+UtilityConfig.S3_BUCKETNAME_SITE_WIDGETS);
			String fileName = getFileNameWithoutExtension(inputFile) + "." + fileExtension;
			String folderToCreate = UtilityConfig.FOLDER_SITE_WIDGETS + UtilityConfig.SUFFIX + userid;
			String docURL = createFolderOrUploadObject(UtilityConfig.S3_BUCKETNAME_SITE_WIDGETS, fileName, s3,
					inputFile, folderToCreate);
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

	/**
	 * This method is for creating folder or uploading objects.
	 * 
	 * @param bucketName
	 * @param fileName
	 * @param client
	 * @param inputFile
	 * @param folderName
	 */
	private String createFolderOrUploadObject(String bucketName, String fileName, AmazonS3 client, File inputFile,
			String folderName) {
		logger.debug("Uploading the File to S3");
		// create meta-data for your folder and set content-length to 0
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
				folderName + UtilityConfig.SUFFIX + fileName, inputFile)
						.withCannedAcl(CannedAccessControlList.PublicRead);
		// Making the URL public to access it.
		// send request to S3 to create folder
		client.putObject(putObjectRequest);
		logger.debug("Returning the URL of uploaded document in the S3");
		return client.getUrl(bucketName, folderName + UtilityConfig.SUFFIX + fileName).toString();

	}

	/**
	 * This method is to get File Extension.
	 * 
	 * @param file
	 */
	private String getFileExtension(File file) {
		logger.debug("Attempting to get extension of File uploaded");
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	/**
	 * This method is to get file name without extension.
	 * 
	 * @param file
	 */
	private String getFileNameWithoutExtension(File file) {
		String fileName = file.getName();
		if (fileName.indexOf(".") > 0)
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		return fileName;
	}

}
