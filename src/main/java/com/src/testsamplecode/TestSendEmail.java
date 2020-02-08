package com.src.testsamplecode;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.src.constant.UtilityConfig;
import com.sun.mail.smtp.SMTPTransport;

public class TestSendEmail {

	public static void main(String[] args) throws MessagingException {
		sendEmail();
	}

	public static void sendEmail() throws MessagingException {
		SMTPTransport t = null;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", UtilityConfig.HOST_DEV_SMTP);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress("team.spprt2019@gmail.com"));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("komal.singhFU@yahoo.com", false));
		msg.setSubject("FeedBack To Azmiri ");
		msg.setContent("<html><h1><u>Azmiri your doing great JOB</u></h1></html>", "text/html; charset=utf-8");
		msg.setSentDate(new Date());
		t = (SMTPTransport) session.getTransport("smtp");
		t.connect(UtilityConfig.HOST_DEV_SMTP, UtilityConfig.USERNAME_DEV_SMTP, UtilityConfig.PASSWORD_DEV_SMTP);
		t.sendMessage(msg, msg.getAllRecipients());
		System.out.println("Inside the prepareEmail method of MSEmailSend class Of AWS_MS_Utility Jar : Is Email Sent  "
				+ t.getLastServerResponse());

		System.out.println(t.getLastServerResponse());
		System.out.println(t.getLastReturnCode());

	}

}
