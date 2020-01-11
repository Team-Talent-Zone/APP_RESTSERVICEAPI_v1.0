package com.src.helper;

import java.io.File;
import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
import com.src.entity.UtilEntity;
import com.sun.mail.smtp.SMTPTransport;

public class UtilHelper {

	final Logger logger = LoggerFactory.getLogger(UtilHelper.class);

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

	public UtilEntity prepareEmail(UtilEntity utilEntity) {
		SMTPTransport t = null;

		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", UtilConfig.HOST);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");

			Session session = Session.getInstance(props, null);
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(utilEntity.getFromUser()));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(utilEntity.getToUser(), false));
			msg.setSubject(utilEntity.getSubject());
			msg.setContent(utilEntity.getBody(), "text/html; charset=utf-8");
			msg.setSentDate(new Date());
			t = (SMTPTransport) session.getTransport("smtp");
			t.connect(UtilConfig.HOST, UtilConfig.USERNAME, UtilConfig.PWD);
			t.sendMessage(msg, msg.getAllRecipients());
			logger.debug("Inside the prepareEmail method of MSEmailSend class Of AWS_MS_Utility Jar : Is Email Sent  "
					+ t.getLastServerResponse());

			utilEntity.setLastServerResponse(t.getLastServerResponse());
			utilEntity.setStatus(t.getReportSuccess());

		} catch (Exception e) {
			logger.error("Error Occured inside the prepareEmail method of MSEmailSend class Of AWS_MS_Utility Jar :"
					+ e.toString());
		} finally {
			try {
				t.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		return utilEntity;
	}

	public String createFolderOrUploadObject(String bucketName, String folderName, AmazonS3 client, File inputFile,
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

	public VelocityContext generateVelocityObject(JSONArray jsonArray) throws JSONException {
		VelocityContext context = new VelocityContext();
		try {
			logger.info("Inside the Send Email Class Of SentEmailUtility Jar : GenerateVelocityObject method");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject objectInArray = jsonArray.getJSONObject(i);
				String[] elementNames = JSONObject.getNames(objectInArray);
				for (String elementName : elementNames) {
					String value = objectInArray.getString(elementName);
					context.put(elementName, value);
				}
			}
		} catch (Exception e) {
		}
		return context;
	}

	public String generateEmailInHtmlFormat(String tempServerURLEmailTemplateName, VelocityContext context) {
		StringWriter writer = null;
		try {
			logger.debug(
					"Inside GenerateEmailInHtmlFormat method of SendEmail Utility Jar of : AbstractEmailConfig Class ");
			VelocityEngine ve = new VelocityEngine();
			ve.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
			ve.setProperty("runtime.log.logsystem.log4j.category", "velocity");
			ve.setProperty("runtime.log.logsystem.log4j.logger", "velocity");

			ve.setProperty("resource.loader", "url");
			ve.setProperty("url.resource.loader.class",
					"org.apache.velocity.runtime.resource.loader.URLResourceLoader");
			ve.setProperty("url.resource.loader.root", (Object) tempServerURLEmailTemplateName.substring(0,
					tempServerURLEmailTemplateName.lastIndexOf('/') + 1));
			logger.debug(
					"Inside GenerateEmailInHtmlFormat method of SendEmail Utility Jar of : AbstractEmailConfig Class : Template URL :  "
							+ tempServerURLEmailTemplateName);
			ve.init();
			Template t = ve.getTemplate(
					tempServerURLEmailTemplateName.substring(tempServerURLEmailTemplateName.lastIndexOf('/') + 1));
			writer = new StringWriter();
			t.merge(context, writer);
		} catch (Exception e) {
			logger.error(
					"Inside GenerateEmailInHtmlFormat method of SendEmail Utility Jar of : AbstractEmailConfig Class : Error Occured :"
							+ e.toString());
			return null;
		}
		return writer.toString();
	}

	public String getFileExtension(File file) {
		logger.debug("Attempting to get extension of File uploaded");
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public String getFileNameWithoutExtension(File file) {
		String fileName = file.getName();
		if (fileName.indexOf(".") > 0)
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		return fileName;
	}
}
