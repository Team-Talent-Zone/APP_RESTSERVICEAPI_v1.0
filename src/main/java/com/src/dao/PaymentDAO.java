package com.src.dao;

import java.util.ArrayList;

import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentHistoryCBAView;
import com.src.entity.PaymentHistoryFUView;
import com.src.entity.PaymentNotificationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;

/**
 * This <code> PaymentDAOImpl </code> Interface handles data access operation
 * for Payments Details.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
public interface PaymentDAO {
	/**
	 * This method savepayments is to save the Payment Details.
	 * 
	 * @param paymentEntity
	 */
	public PaymentEntity savePayments(PaymentEntity paymentEntity);

	/**
	 * This method savepaymentsfutranscations is to save the FU Transaction Details.
	 * 
	 * @param fuTranscationHistEntity
	 */
	public PaymentFUTranscationHistEntity savePaymentsFUTranscations(
			PaymentFUTranscationHistEntity fuTranscationHistEntity);

	/**
	 * This method savepaymentscbatranscations is to save the CBA Transaction
	 * Details.
	 * 
	 * @param cbaTranscationHistEntity
	 */
	public PaymentCBATranscationHistEntity savePaymentsCBATranscations(
			PaymentCBATranscationHistEntity cbaTranscationHistEntity);

	/**
	 * This method savepaymentsrefundtranscations is to save the Payment Refund
	 * Transaction Details.
	 * 
	 * @param refundTranscationHistEntity
	 */
	public PaymentRefundTranscationHistEntity savePaymentsRefundTranscations(
			PaymentRefundTranscationHistEntity refundTranscationHistEntity);

	/**
	 * This method savePaymentsNotificationHistory is to save the Payment
	 * Notification History details.
	 * 
	 * @param savePaymentsNotificationHistory
	 */
	public PaymentNotificationHistEntity savePaymentsNotificationHistory(
			PaymentNotificationHistEntity paymentNotiHistEntity);

	/**
	 * Get the Payment Details by UserId.
	 * 
	 * @param userId
	 */
	public PaymentEntity getPaymentDetailsByUserId(int userId);

	/**
	 * Get the FU Payment Details by UserId.
	 * 
	 * @param userId
	 */
	public  ArrayList<PaymentHistoryFUView> getPaymentFUDetailsByUserId(int userId);

	/**
	 * Get the CBA Payment Details by UserId.
	 * 
	 * @param userId
	 */
	public  ArrayList<PaymentHistoryCBAView> getPaymentCBADetailsByUserId(int userId);

	/**
	 * Get the Payment Refund transaction Details by UserId.
	 * 
	 * @param userId
	 */
	public PaymentRefundTranscationHistEntity getPaymentRefundTranHistByUserId(int userId);
	
	/**
	 * Get the Payment Details by UserId.
	 * 
	 * @param userId
	 */
	public PaymentEntity getPaymentDetailsByTxnId(String txnid);
	
	public void saveorupdatePayments(PaymentEntity paymentEntity);

}