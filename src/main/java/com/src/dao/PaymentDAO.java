package com.src.dao;

import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;

/**
 * This <code> PaymentDAOImpl </code> Interface handles data access operation
 * for Payments Details.
 * 
 * @author Ishaq.
 *
 */
public interface PaymentDAO {
	/**
	 * This method savepayments is to save the payment details.
	 * 
	 * @param paymentEntity
	 */
	public PaymentEntity savepayments(PaymentEntity paymentEntity);

	/**
	 * This method savepaymentsfutranscations is to save the FU Transaction details.
	 * 
	 * @param fuTranscationHistEntity
	 */
	public PaymentFUTranscationHistEntity savepaymentsfutranscations(
			PaymentFUTranscationHistEntity fuTranscationHistEntity);

	/**
	 * This method savepaymentscbatranscations is to save the CBA Transaction
	 * details.
	 * 
	 * @param cbaTranscationHistEntity
	 */
	public PaymentCBATranscationHistEntity savepaymentscbatranscations(
			PaymentCBATranscationHistEntity cbaTranscationHistEntity);

	/**
	 * This method savepaymentsrefundtranscations is to save the payment Refund
	 * Transaction details.
	 * 
	 * @param refundTranscationHistEntity
	 */
	public PaymentRefundTranscationHistEntity savepaymentsrefundtranscations(
			PaymentRefundTranscationHistEntity refundTranscationHistEntity);

}