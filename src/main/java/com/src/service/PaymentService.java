package com.src.service;

import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;

/**
 * The <code> PaymentService </code> interface defines payment service Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
public interface PaymentService {

	/**
	 * To save payments details.
	 * 
	 * @param paymentEntity
	 */
	public PaymentEntity savepayments(PaymentEntity paymentEntity);

	/**
	 * To save payment FU Transaction Details.
	 * 
	 * @param fuTranscationHistEntity
	 */
	public PaymentFUTranscationHistEntity savepaymentsfutranscations(
			PaymentFUTranscationHistEntity fuTranscationHistEntity);

	/**
	 * To Save Payment CBA Transactions Details.
	 * 
	 * @param cbaTranscationHistEntity
	 */
	public PaymentCBATranscationHistEntity savepaymentscbatranscations(
			PaymentCBATranscationHistEntity cbaTranscationHistEntity);

	/**
	 * To Save Payment Refunds Transactions.
	 * 
	 * @param refundTranscationHistEntity
	 */
	public PaymentRefundTranscationHistEntity savepaymentsrefundtranscations(
			PaymentRefundTranscationHistEntity refundTranscationHistEntity);

}
