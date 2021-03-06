package com.src.service;

import com.src.entity.FreelancerPaymentInput;
import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentMode;
import com.src.entity.PaymentNotificationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;
import com.src.entity.PayoutTransferResponse;
import com.src.entity.PayoutVerifyAccountRequest;

/**
 * The <code> PaymentService </code> interface defines payment service Details.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
public interface PaymentService {

	/**
	 * To save payments details.
	 * 
	 * @param paymentEntity
	 */
	public PaymentEntity savePayments(PaymentEntity paymentEntity);

	/**
	 * To save payment FU Transaction Details.
	 * 
	 * @param fuTranscationHistEntity
	 */
	public PaymentFUTranscationHistEntity savePaymentsFUTranscations(
			PaymentFUTranscationHistEntity fuTranscationHistEntity);

	/**
	 * To Save Payment CBA Transactions Details.
	 * 
	 * @param cbaTranscationHistEntity
	 */
	public PaymentCBATranscationHistEntity savePaymentsCBATranscations(
			PaymentCBATranscationHistEntity cbaTranscationHistEntity);

	/**
	 * To Save Payment Refunds Transactions.
	 * 
	 * @param refundTranscationHistEntity
	 */
	public PaymentRefundTranscationHistEntity savePaymentsRefundTranscations(
			PaymentRefundTranscationHistEntity refundTranscationHistEntity);

	/**
	 * To Save Transactions Notification History.
	 * 
	 * @param savePaymentsNotificationHistory
	 */
	public PaymentNotificationHistEntity savePaymentsNotificationHistory(
			PaymentNotificationHistEntity paymentNotificationHistEntity);

	/**
	 * Get the Payment Details by UserId.
	 * 
	 * @param userId
	 */
	public PaymentEntity getPaymentDetailsByUserId(int userId);

	/**
	 * Get the Payment Refund transaction Details by UserId.
	 *  
	 * @param userId
	 */
	public PaymentRefundTranscationHistEntity getPaymentRefundTranHistByUserId(int userId);

	public String payuCallback(String mihpayid, String txnid, PaymentMode mode, String hash, String status);
	
	public PaymentEntity getPaymentDetailsByTxnId(String txnid);
		
	/**
	 * It creates a unqiue benficiary id, which helps payout transfers.
	 * 
	 * @param userId
	 */
	public String createBenificiaryPayout(PayoutVerifyAccountRequest payoutVerifyAccountRequest) throws Exception ;

	/**
	 * It validates the account and sends beneficiary name as response.
	 * 
	 * @param accountNumber
	 * @param ifscCode
	 */
	public String verifyAccountPayout( PayoutVerifyAccountRequest payoutVerifyAccountRequest) throws Exception ;

	/**
	 * Method for intiating transfer (payout). 
	 * 
	 * @param userId
	 */
	public PayoutTransferResponse payoutTransfer(FreelancerPaymentInput freelancerPaymentInputs) throws Exception;

}
