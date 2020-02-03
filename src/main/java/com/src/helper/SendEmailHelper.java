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

public class SendEmailHelper {

	final Logger logger = LoggerFactory.getLogger(SendEmailHelper.class);

	public UtilEntity sendEmail(UtilEntity utilEntity) throws Exception {

		VelocityHelper velocityHelper = new VelocityHelper();
		JSONArray jsonarray = new JSONArray();

		if (utilEntity.getArrayfromui() == null) {
			jsonarray = utilEntity.getJsonarray();
		} else {

			JSONObject jsonObj = new JSONObject(utilEntity.getArrayfromui());
			jsonarray.put(jsonObj);
		}
		VelocityContext velocityContext = velocityHelper.generateVelocityObject(jsonarray);
		String htmlFormat = velocityHelper.generateEmailInHtmlFormat(utilEntity.getTemplateurl(), velocityContext);
		if (htmlFormat != null) {
			utilEntity.setBody(htmlFormat);
			utilEntity = prepareEmail(utilEntity);
		}
		return utilEntity;
	}

	private UtilEntity prepareEmail(UtilEntity utilEntity) throws Exception {
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
		t.connect(UtilityConfig.HOST_DEV_SMTP, UtilityConfig.USERNAME_DEV_SMTP, UtilityConfig.PASSWORD_DEV_SMTP);
		t.sendMessage(msg, msg.getAllRecipients());
		logger.debug("Inside the prepareEmail method of SendEmailHelper class   : Is Email Sent  "
				+ t.getLastServerResponse());
		utilEntity.setLastserverresponse(t.getLastServerResponse());
		utilEntity.setLastreturncode(t.getLastReturnCode());
		return utilEntity;
	}
}
