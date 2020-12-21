package com.src.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.src.constant.NewServiceConstant;
import com.src.constant.UserConstant;
import com.src.constant.UtilityConfig;
import com.src.entity.CreatePayOutBeneficiary;
import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentHistoryCBAView;
import com.src.entity.PaymentHistoryFUView;
import com.src.entity.PaymentMode;
import com.src.entity.PaymentNotificationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;
import com.src.entity.PayoutToken;
import com.src.entity.PayoutTransferRequest;
import com.src.entity.PayoutTransferResponse;
import com.src.entity.PayoutVerifyAccountRequest;
import com.src.entity.PayoutVerifyAccountResponseData;
import com.src.entity.ReferenceLookUpTemplateEntity;
import com.src.entity.UserEntity;
import com.src.entity.UserServiceDetailsEntity;
import com.src.utils.CommonUtilites;
import com.src.utils.PaymentUtil;

/**
 * The <code> PaymentServiceImpl </code> class defines Payment Service Details.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Service("paymentdManager")
@Transactional(rollbackFor = { Exception.class })
public class PaymentServiceImpl extends AbstractServiceManager implements PaymentService {
	final static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	/**
	 * To Save Payments details.
	 */
	@Override
	public PaymentEntity savePayments(PaymentEntity paymentEntity) {
		paymentEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());

		UserEntity userEntity = userRestDAO.getUserByUserId(paymentEntity.getUserId());
		userEntity.setUserId(paymentEntity.getUserId());
		paymentEntity.setUserdetails(userEntity);

		PaymentUtil paymentUtil = new PaymentUtil();
		paymentEntity = paymentUtil.populatePaymentDetail(paymentEntity);
		if (userEntity.getUserroles().getRolecode().equals(UserConstant.FREELANCER_USER)) {
			PaymentFUTranscationHistEntity fuTranscationHistEntity = new PaymentFUTranscationHistEntity();
			fuTranscationHistEntity.setAmount(Float.parseFloat(paymentEntity.getAmount()));
			fuTranscationHistEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());
			fuTranscationHistEntity.setEmail(paymentEntity.getEmail());
			fuTranscationHistEntity.setMobile(paymentEntity.getPhone());
			fuTranscationHistEntity.setPayments(paymentEntity);
			fuTranscationHistEntity.setUserId(paymentEntity.getUserId());
			fuTranscationHistEntity.setHash(paymentEntity.getHash());
			fuTranscationHistEntity.setTxnid(paymentEntity.getTxnid());
			fuTranscationHistEntity.setUserdetails(userEntity);
			paymentEntity.setPaymentsFUTrans(fuTranscationHistEntity);
		}
		if (userEntity.getUserroles().getRolecode().equals(UserConstant.CLIENT_BUSINESS_ADMINISTRATOR)) {
			PaymentCBATranscationHistEntity cbaTranscationHistEntity = new PaymentCBATranscationHistEntity();
			cbaTranscationHistEntity.setAmount(Float.parseFloat(paymentEntity.getAmount()));
			cbaTranscationHistEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());
			cbaTranscationHistEntity.setEmail(paymentEntity.getEmail());
			cbaTranscationHistEntity.setMobile(paymentEntity.getPhone());
			cbaTranscationHistEntity.setPayments(paymentEntity);
			cbaTranscationHistEntity.setUserId(paymentEntity.getUserId());
			cbaTranscationHistEntity.setHash(paymentEntity.getHash());
			cbaTranscationHistEntity.setTxnid(paymentEntity.getTxnid());
			cbaTranscationHistEntity.setUserdetails(userEntity);
			paymentEntity.setPaymentsCBATrans(cbaTranscationHistEntity);
		}

		return paymentDAO.savePayments(paymentEntity);
	}

	public PaymentEntity getPaymentDetailsByTxnId(String txnid) {
		return paymentDAO.getPaymentDetailsByTxnId(txnid);
	}

	public String payuCallback(String mihpayid, String txnid, PaymentMode mode, String hash, String status) {
		PaymentEntity paymentEntity = paymentDAO.getPaymentDetailsByTxnId(txnid);
		if (paymentEntity != null) {
			String paymentStatus = null;
			if (status.equals("failure")) {
				paymentStatus = "Failed";
			} else if (status.equals("success")) {
				paymentStatus = "Success";
			}
			UserEntity userEntity = userRestDAO.getUserByUserId(paymentEntity.getUserId());
			if (userEntity.getUserroles().getRolecode().equals(UserConstant.FREELANCER_USER)) {
				PaymentFUTranscationHistEntity fuTranscationHistEntity = paymentEntity.getPaymentsFUTrans();
				fuTranscationHistEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());
				fuTranscationHistEntity.setHash(hash);
				if (mode != null) {
					fuTranscationHistEntity.setMode(mode.name());
				}
				fuTranscationHistEntity.setPayuMoneyId(mihpayid);
				fuTranscationHistEntity.setStatus(paymentStatus);
				fuTranscationHistEntity.setTxnid(txnid);
				paymentEntity.setPaymentsFUTrans(fuTranscationHistEntity);
			}
			if (userEntity.getUserroles().getRolecode().equals(UserConstant.CLIENT_BUSINESS_ADMINISTRATOR)) {
				PaymentCBATranscationHistEntity cbaTranscationHistEntity = paymentEntity.getPaymentsCBATrans();
				cbaTranscationHistEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());
				cbaTranscationHistEntity.setHash(hash);
				if (mode != null) {
					cbaTranscationHistEntity.setMode(mode.name());
				}
				cbaTranscationHistEntity.setPayuMoneyId(mihpayid);
				cbaTranscationHistEntity.setStatus(paymentStatus);
				cbaTranscationHistEntity.setTxnid(txnid);
				paymentEntity.setPaymentsCBATrans(cbaTranscationHistEntity);
			}
			paymentDAO.saveorupdatePayments(paymentEntity);
			if (userEntity.getUserroles().getRolecode().equals(UserConstant.FREELANCER_USER)) {
				if (paymentEntity.getPaymentsFUTrans().getPayuMoneyId() != null) {
					if (paymentEntity.getPaymentsFUTrans().getStatus().equals("Success")) {
						userEntity.getFreeLanceDetails().setIsregfeedone(true);
					}
					if (paymentEntity.getPaymentsFUTrans().getStatus().equals("Failed")) {
						userEntity.getFreeLanceDetails().setIsregfeedone(false);
					}
					userRestDAO.saveorupdateUserDetails(userEntity);
				}
			}

			if (userEntity.getUserroles().getRolecode().equals(UserConstant.CLIENT_BUSINESS_ADMINISTRATOR)) {
				if (paymentEntity.getPaymentsCBATrans().getPayuMoneyId() != null
						&& paymentEntity.getServiceids() != null && paymentEntity.getServiceids().length() > 0) {
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String[] serviceIds = paymentEntity.getServiceids().split(",");
					for (String serviceid : serviceIds) {
						Calendar cal = Calendar.getInstance();
						UserServiceDetailsEntity userServiceDetailsEntity = userServiceDetailsDAO
								.getUserServiceDetailsByServiceId(Integer.parseInt(serviceid));
						if (paymentEntity.getPaymentsCBATrans().getStatus().equals("Success")) {
							userServiceDetailsEntity.setIsservicepurchased(true);
							userServiceDetailsEntity.setStatus("PAYMENT_PAID");
							userServiceDetailsEntity.setTxnid(paymentEntity.getTxnid());
							userServiceDetailsEntity.setServicestarton(CommonUtilites.getCurrentDateInNewFormat());
							if (userServiceDetailsEntity.getValidPeriodCode()
									.equals(NewServiceConstant.SERVICE_TERM_3M)) {
								cal.add(Calendar.MONTH, 3);
								userServiceDetailsEntity.setServiceendon(dateFormat.format(cal.getTime()));
							} else if (userServiceDetailsEntity.getValidPeriodCode()
									.equals(NewServiceConstant.SERVICE_TERM_1MF)) {
								cal.add(Calendar.MONTH, 1);
								userServiceDetailsEntity.setServiceendon(dateFormat.format(cal.getTime()));
							} else if (userServiceDetailsEntity.getValidPeriodCode()
									.equals(NewServiceConstant.SERVICE_TERM_6M)) {
								cal.add(Calendar.MONTH, 6);
								userServiceDetailsEntity.setServiceendon(dateFormat.format(cal.getTime()));
							} else if (userServiceDetailsEntity.getValidPeriodCode()
									.equals(NewServiceConstant.SERVICE_TERM_1Y)) {
								cal.add(Calendar.MONTH, 12);
								userServiceDetailsEntity.setServiceendon(dateFormat.format(cal.getTime()));
							}
						}
						if (paymentEntity.getPaymentsCBATrans().getStatus().equals("Failed")) {
							userServiceDetailsEntity.setIsservicepurchased(false);
							userServiceDetailsEntity.setStatus("PAYMENT_FAILED");
							userServiceDetailsEntity.setServicestarton(null);
							userServiceDetailsEntity.setServiceendon(null);
						}
						userServiceDetailsDAO.saveUserServiceDetails(userServiceDetailsEntity);
					}
				}

			}

			if (userEntity.getUserroles().getRolecode().equals(UserConstant.CLIENT_BUSINESS_ADMINISTRATOR)) {
				if (paymentEntity.getPaymentsCBATrans().getPayuMoneyId() != null && paymentEntity.getJobids() != null
						&& paymentEntity.getJobids().length() > 0) {
					FreeLanceOnServiceEntity freeLanceOnServiceEntity = freeLanceOnServiceDAO
							.getAllFreelanceOnServiceDetailsByJobId(Integer.parseInt(paymentEntity.getJobids()));
					if (paymentEntity.getPaymentsCBATrans().getStatus().equals("Success")) {
						freeLanceOnServiceEntity.setIsjobamtpaidtocompany(true);
						freeLanceOnServiceEntity.setTxnid(paymentEntity.getPaymentsCBATrans().getTxnid());
					}
					if (paymentEntity.getPaymentsCBATrans().getStatus().equals("Failed")) {
						freeLanceOnServiceEntity.setTxnid(paymentEntity.getPaymentsCBATrans().getTxnid());
					}
					freeLanceOnServiceEntity.setUpdatedon(CommonUtilites.getCurrentDateInNewFormat());
					freeLanceOnServiceDAO.saveOrUpdateFreeLanceOnService(freeLanceOnServiceEntity);
				}

			}
			return txnid;
		}
		return null;
	}

	/**
	 * To Save payment FU Transaction Details.
	 */
	@Override
	public PaymentFUTranscationHistEntity savePaymentsFUTranscations(
			PaymentFUTranscationHistEntity fuTranscationHistEntity) {
		fuTranscationHistEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());

		PaymentEntity pentity = new PaymentEntity();
		pentity.setPaymentId(fuTranscationHistEntity.getPaymentId());
		fuTranscationHistEntity.setPayments(pentity);

		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(fuTranscationHistEntity.getUserId());
		fuTranscationHistEntity.setUserdetails(userEntity);
		return paymentDAO.savePaymentsFUTranscations(fuTranscationHistEntity);
	}

	/**
	 * To Save Payments CBA Transaction Details.
	 */
	@Override
	public PaymentCBATranscationHistEntity savePaymentsCBATranscations(
			PaymentCBATranscationHistEntity cbaTranscationHistEntity) {
		cbaTranscationHistEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());

		PaymentEntity pentity = new PaymentEntity();
		pentity.setPaymentId(cbaTranscationHistEntity.getPaymentId());
		cbaTranscationHistEntity.setPayments(pentity);

		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(cbaTranscationHistEntity.getUserId());
		cbaTranscationHistEntity.setUserdetails(userEntity);
		return paymentDAO.savePaymentsCBATranscations(cbaTranscationHistEntity);
	}

	/**
	 * To Save Payment Refund Transactions Details.
	 */
	@Override
	public PaymentRefundTranscationHistEntity savePaymentsRefundTranscations(
			PaymentRefundTranscationHistEntity refundTranscationHistEntity) {
		refundTranscationHistEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());

		PaymentEntity pentity = new PaymentEntity();
		pentity.setPaymentId(refundTranscationHistEntity.getPaymentId());
		refundTranscationHistEntity.setPayments(pentity);

		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(refundTranscationHistEntity.getUserId());
		refundTranscationHistEntity.setUserdetails(userEntity);
		return paymentDAO.savePaymentsRefundTranscations(refundTranscationHistEntity);
	}

	/**
	 * To Save Transactions Notification History Details.
	 */
	@Override
	public PaymentNotificationHistEntity savePaymentsNotificationHistory(
			PaymentNotificationHistEntity paymentNotificationHistEntity) {

		PaymentEntity pentity = new PaymentEntity();
		pentity.setPaymentId(paymentNotificationHistEntity.getPaymentId());
		paymentNotificationHistEntity.setPayments(pentity);

		ReferenceLookUpTemplateEntity refLookupEntity = new ReferenceLookUpTemplateEntity();
		refLookupEntity.setTemplateid(paymentNotificationHistEntity.getTemplateId());
		paymentNotificationHistEntity.setLookuptemplates(refLookupEntity);

		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(paymentNotificationHistEntity.getUserId());
		paymentNotificationHistEntity.setUserdetails(userEntity);
		return paymentDAO.savePaymentsNotificationHistory(paymentNotificationHistEntity);
	}

	/**
	 * Get the Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@Override
	public PaymentEntity getPaymentDetailsByUserId(int userId) {
		return paymentDAO.getPaymentDetailsByUserId(userId);
	}

	/**
	 * Get the FU Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@Override
	public ArrayList<PaymentHistoryFUView> getPaymentFUDetailsByUserId(int userId) {
		return paymentDAO.getPaymentFUDetailsByUserId(userId);
	}

	/**
	 * Get the CBA Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@Override
	public ArrayList<PaymentHistoryCBAView> getPaymentCBADetailsByUserId(int userId) {
		return paymentDAO.getPaymentCBADetailsByUserId(userId);
	}

	/**
	 * Get the Payment Refund Transaction History Details by UserId.
	 * 
	 * @param userId
	 */
	@Override
	public PaymentRefundTranscationHistEntity getPaymentRefundTranHistByUserId(int userId) {
		return paymentDAO.getPaymentRefundTranHistByUserId(userId);
	}

	/**
	 * It validates the account and sends beneficiary name as response.
	 * 
	 * @param accountNumber
	 * @param ifscCode
	 */
	@Override
	public String verifyAccountPayout(String accountNumber, String ifscCode) throws Exception {
		ObjectMapper objectmapper = new ObjectMapper();
		PayoutVerifyAccountRequest request = new PayoutVerifyAccountRequest();
		request.setAccountNumber(accountNumber);
		request.setIfscCode(ifscCode);
		request.setMerchantRefId(CommonUtilites.genRandomAlphaNumeric());
		URL url = new URL(
				referenceLookUpDAO.getReferenceLookupByShortKey(UtilityConfig.PAYOUT_API_VERIFY_ACCOUNT_URL_SHORTKEY));
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization", "bearer " + generateToken());
		con.setRequestProperty("payoutMerchantId",
				referenceLookUpDAO.getReferenceLookupByShortKey(UtilityConfig.PAYOUT_API_MERCHANTID_SHORTKEY));
		con.setDoOutput(true);

		String jsonString = objectmapper.writeValueAsString(request);
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		int code = con.getResponseCode();
		System.out.println(code);

		PayoutVerifyAccountResponseData response = objectmapper.readValue(con.getInputStream(),
				PayoutVerifyAccountResponseData.class);
		if (response.getError() == null) {
			return response.getBeneficiaryName();
		}
		return response.getError();
	}

	/**
	 * Method for intiating transfer (payout).
	 * 
	 * @param userId
	 */
	@Override
	public String payoutTransfer(int userId) throws Exception {
		ObjectMapper objectmapper = new ObjectMapper();
		UserEntity userEntity = userRestDAO.getUserByUserId(userId);
		PayoutTransferRequest payouttransferrequest = new PayoutTransferRequest();
		payouttransferrequest.setBeneficiaryName(userEntity.getFullname());
		payouttransferrequest.setBeneficiaryAccountNumber(userEntity.getFreeLanceDetails().getAccountno().toString());
		payouttransferrequest.setBeneficiaryIfscCode(userEntity.getFreeLanceDetails().getIfsc());
//			payouttransferrequest.setPurpose();
//			payouttransferrequest.setAmount(amount);
//			payouttransferrequest.setBatchId(batchId);
//			payouttransferrequest.getMerchantRefId();
//			payouttransferrequest.setPaymentType(paymentType);
		URL url = new URL(
				referenceLookUpDAO.getReferenceLookupByShortKey(UtilityConfig.PAYOUT_API_VERIFY_ACCOUNT_URL_SHORTKEY));
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization", generateToken());
		con.setRequestProperty("payoutMerchantId",
				referenceLookUpDAO.getReferenceLookupByShortKey(UtilityConfig.PAYOUT_API_MERCHANTID_SHORTKEY));
		con.setDoOutput(true);
		String jsonString = objectmapper.writeValueAsString(payouttransferrequest);
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		int code = con.getResponseCode();
		System.out.println(code);

		PayoutTransferResponse response = objectmapper.readValue(con.getInputStream(), PayoutTransferResponse.class);
		return response.getMsg();
	}

	/**
	 * It creates a unqiue benficiary id, which helps payout transfers.
	 * 
	 * @param userId
	 */
	@Override
	public String createBenificiaryPayout(int userId) throws Exception {
		ObjectMapper objectmapper = new ObjectMapper();
		UserEntity userEntity = userRestDAO.getUserByUserId(userId);
		JSONObject json = new JSONObject();
		json.put("name", userEntity.getFullname());
		json.put("accountNo", userEntity.getFreeLanceDetails().getAccountno().toString());
		json.put("ifsc", userEntity.getFreeLanceDetails().getIfsc());
		json.put("email", userEntity.getUsername());
		StringEntity se = new StringEntity(json.toString());
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost connection = new HttpPost(
				referenceLookUpDAO.getReferenceLookupByShortKey(UtilityConfig.PAYOUT_API_BENIFICATORY_URL_SHORTKEY));
		connection.setHeader("Content-Type", "application/json");
		connection.setHeader("Authorization", "bearer " + generateToken());
		connection.setHeader("payoutMerchantId",
				referenceLookUpDAO.getReferenceLookupByShortKey(UtilityConfig.PAYOUT_API_MERCHANTID_SHORTKEY));
		connection.setEntity(se);

		CloseableHttpResponse response = httpClient.execute(connection);
		if (response.getStatusLine().getStatusCode() == 200) {
			InputStream content = response.getEntity().getContent();
			CreatePayOutBeneficiary benficiaryResp = objectmapper.readValue(content, CreatePayOutBeneficiary.class);
			System.out.println("this is test" + benficiaryResp.getData().get("beneficiaryId"));
			if (benficiaryResp.getData().get("beneficiaryId").toString() != null) {
				userEntity.getFreeLanceDetails()
						.setBeneficiaryid(benficiaryResp.getData().get("beneficiaryId").intValue());
				userRestDAO.saveorupdateUserDetails(userEntity);
				if (userEntity.getFreeLanceDetails().getBeneficiaryid() > 0) {
					return benficiaryResp.getData().get("beneficiaryId").toString();
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * Generates unique token key for payout transfers.
	 */
	private String generateToken() throws Exception {

		List<BasicNameValuePair> parametersBody = new ArrayList<BasicNameValuePair>();
		parametersBody.add(new BasicNameValuePair("grant_type", "password"));

		parametersBody.add(new BasicNameValuePair("client_id",
				referenceLookUpDAO.getReferenceLookupByShortKey(UtilityConfig.PAYOUT_API_CLIENT_ID_SHORTKEY)));
		parametersBody.add(new BasicNameValuePair("username",
				referenceLookUpDAO.getReferenceLookupByShortKey(UtilityConfig.PAYOUT_API_USERNAME_SHORTKEY)));
		parametersBody.add(new BasicNameValuePair("password",
				referenceLookUpDAO.getReferenceLookupByShortKey(UtilityConfig.PAYOUT_API_PASSWORD_SHORTKEY)));
		parametersBody.add(new BasicNameValuePair("scope", "create_payout_transactions"));

		ObjectMapper objectmapper = new ObjectMapper();
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost connection = new HttpPost(
				referenceLookUpDAO.getReferenceLookupByShortKey(UtilityConfig.PAYOUT_API_TOKEN_URL_SHORTKEY));
		connection.setHeader("Content-Type", "application/x-www-form-urlencoded");
		connection.setEntity(new UrlEncodedFormEntity(parametersBody));

		CloseableHttpResponse response = httpClient.execute(connection);

		InputStream content = response.getEntity().getContent();
		PayoutToken tokens = objectmapper.readValue(content, PayoutToken.class);

		return tokens.getAccess_token().toString();

	}

}
