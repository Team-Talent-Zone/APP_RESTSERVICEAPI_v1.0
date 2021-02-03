package com.src.helper;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.VelocityContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.src.constant.UtilityConfig;
import com.src.entity.UtilEntity;
import com.sun.mail.smtp.SMTPTransport;

/**
 * This <code>SendEmailHelper</code>defines preparing and sending emails.
 * 
 * @author Ishaq.
 * @version 1.0
 *
 */
public class SendEmailHelper {

	final Logger logger = LoggerFactory.getLogger(SendEmailHelper.class);

	/**
	 * This method is to prepare email.
	 * 
	 * @param utilEntity
	 * @throws Exception
	 */
	public UtilEntity prepareEmail(UtilEntity utilEntity, String apikey, String applicationName) throws Exception {
		logger.debug("Inside the SendEmailHelper Class : prepareEmail method");
		VelocityHelper velocityHelper = new VelocityHelper();
		JSONArray jsonarray = new JSONArray();
		JSONObject jsonObj = new JSONObject(utilEntity.getTemplatedynamicdata());
		jsonarray.put(jsonObj);
		VelocityContext velocityContext = velocityHelper.generateVelocityObject(jsonarray);
		String htmlFormat = velocityHelper.generateEmailInHtmlFormat(utilEntity.getTemplateurl(), velocityContext);
		if (htmlFormat != null) {
			if (utilEntity.getPreferlang().equals(UtilityConfig.PREFERED_LANGUAGE_TELUGU)
					|| utilEntity.getPreferlang().equals(UtilityConfig.PREFERED_LANGUAGE_HINDI)) {
				TranslateHelper translateHelper = new TranslateHelper();
				htmlFormat = translateHelper.translateText(utilEntity.getPreferlang(), htmlFormat,
						UtilityConfig.MIME_TYPE_HTML, apikey, applicationName);
			//	String subject = translateHelper.translateText(utilEntity.getPreferlang(), utilEntity.getSubject(),
			//			UtilityConfig.MIME_TYPE_TEXT, apikey, applicationName);
			//	utilEntity.setSubject(subject);
				utilEntity.setSubject(utilEntity.getSubject());
			}
			utilEntity.setBody(htmlFormat);
			utilEntity = sendEmail(utilEntity);
		}
		return utilEntity;
	}

	/**
	 * This method is for Sending Emails.
	 * 
	 * @param utilEntity
	 * @throws Exception
	 */
	private UtilEntity sendEmail(UtilEntity utilEntity) throws Exception {
		logger.debug(
				"Inside he SendEmailHelper Class : sendEmail method : sending email to : " + utilEntity.getTouser());
		SMTPTransport t = null;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", UtilityConfig.HOST_DEV_SMTP);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(utilEntity.getFromuser()));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(utilEntity.getTouser(), false));
		msg.setSubject(utilEntity.getSubject());
		msg.setContent(utilEntity.getBody(), "text/html; charset=utf-8");
		msg.setSentDate(new Date());
		t = (SMTPTransport) session.getTransport("smtp");
		t.connect(UtilityConfig.HOST_DEV_SMTP, UtilityConfig.USERNAME_DEV_SMTP, UtilityConfig.PSWD_DEV_SMTP);
		t.sendMessage(msg, msg.getAllRecipients());
		utilEntity.setLastserverresponse(t.getLastServerResponse());
		utilEntity.setLastreturncode(t.getLastReturnCode());
		logger.debug("Inside he SendEmailHelper Class : sendEmail method : service response  "
				+ utilEntity.getLastserverresponse());
		return utilEntity;
	}
}
