package com.src.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import com.src.constant.PaymentConstant;
import com.src.entity.PaymentEntity;

public class PaymentUtil {



	public PaymentEntity populatePaymentDetail(PaymentEntity paymentDetail , String fUrl , String sUrl , String paymentSalt , String paymentKey ) {
		String hashString = "";
		Random rand = new Random();
		String randomId = Integer.toString(rand.nextInt()) + (System.currentTimeMillis() / 1000L);
		String txnId = "Dev" + hashCal("SHA-256", randomId).substring(0, 12);
		paymentDetail.setTxnid(txnId);
		String hash = "";
		// String otherPostParamSeq =
		// "phone|surl|furl|lastname|curl|address1|address2|city|state|country|zipcode|pg";
		String hashSequence = "key|txnid|amount|productinfo|firstname|email|||||||||||";
		hashString = hashSequence.concat(paymentSalt);
		hashString = hashString.replace("key", paymentKey);
		hashString = hashString.replace("txnid", txnId);
		hashString = hashString.replace("amount", paymentDetail.getAmount());
		hashString = hashString.replace("productinfo", paymentDetail.getProductinfo());
		hashString = hashString.replace("firstname", paymentDetail.getName());
		hashString = hashString.replace("email", paymentDetail.getEmail());

		hash = hashCal("SHA-512", hashString);
		paymentDetail.setHash(hash);
		paymentDetail.setFurl(fUrl);
		paymentDetail.setSurl(sUrl);
		paymentDetail.setKey(paymentKey);
		paymentDetail.setService_provider(PaymentConstant.serviceProvider);
		return paymentDetail;
	}

	public static String hashCal(String type, String str) {
		byte[] hashseq = str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest algorithm = MessageDigest.getInstance(type);
			algorithm.reset();
			algorithm.update(hashseq);
			byte messageDigest[] = algorithm.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1) {
					hexString.append("0");
				}
				hexString.append(hex);
			}

		} catch (NoSuchAlgorithmException nsae) {
		}
		return hexString.toString();
	}

}
