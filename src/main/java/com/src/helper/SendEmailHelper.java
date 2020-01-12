package com.src.helper;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.VelocityContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.src.constant.AppConfig;
import com.src.constant.UtilityConfig;
import com.src.entity.UserEntity;
import com.src.entity.UtilEntity;
import com.sun.mail.smtp.SMTPTransport;

public class SendEmailHelper {

	final Logger logger = LoggerFactory.getLogger(SendEmailHelper.class);

	public UtilEntity sendEmail(UtilEntity utilEntity) throws JSONException {

		VelocityHelper velocityHelper = new VelocityHelper();
		VelocityContext velocityContext = velocityHelper.generateVelocityObject(utilEntity.getJsonArray());
		String htmlFormat = velocityHelper.generateEmailInHtmlFormat(utilEntity.getTemplateURL(), velocityContext);

		if (htmlFormat != null) {

			utilEntity.setBody(htmlFormat);
			utilEntity = prepareEmail(utilEntity);
		}
		return utilEntity;

	}

	private UtilEntity prepareEmail(UtilEntity utilEntity) {
		SMTPTransport t = null;

		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", UtilityConfig.HOST);
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
			t.connect(UtilityConfig.HOST, UtilityConfig.USERNAME, UtilityConfig.PWD);
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

	public UtilEntity returnUtilEntityObjByShortKey(Object obj, String shortKey, String templateURL)
			throws JSONException {
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		UtilEntity utilEntity = null;

		if (obj instanceof UserEntity) {
			UserEntity userEntity = (UserEntity) obj;
			if (shortKey.equals(AppConfig.EMAIL_SHORTKEY_VERIFYEMAILADDRESS)) {
				jsonObj.put("fullName", userEntity.getFirstname() + userEntity.getLastname());
				utilEntity = createUtilEntity(userEntity.getUsername(), AppConfig.EMAIL_SUBJECT_VERIFYEMAILADDRESS,
						templateURL);
			}
			if (shortKey.equals(AppConfig.EMAIL_SHORTKEY_SOMETHINGWENTWRONG)) {
				jsonObj.put("fullName", userEntity.getFirstname() + userEntity.getLastname());
				utilEntity = createUtilEntity(userEntity.getUsername(), AppConfig.EMAIL_SUBJECT_SOMETHINGWENTWRONG,
						templateURL);
			}
		}
		
		jsonArray.put(jsonObj);
		utilEntity.setJsonArray(jsonArray);
		return utilEntity;
	}

	private static UtilEntity createUtilEntity(String emailToUser, String emailSubject, String templateURL) {
		UtilEntity utilEntity = new UtilEntity();
		utilEntity.setFromUser(AppConfig.EMAIL_SENT_FROMUSER);
		utilEntity.setToUser(emailToUser);
		utilEntity.setSubject(emailSubject);
		utilEntity.setTemplateURL(templateURL);
		return utilEntity;
	}
}
