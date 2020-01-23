package com.src.service;

import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;

public interface PaymentService {

	public PaymentEntity savepayments(PaymentEntity paymentEntity);

	public PaymentFUTranscationHistEntity savepaymentsfutranscations(
			PaymentFUTranscationHistEntity fuTranscationHistEntity);

	public PaymentCBATranscationHistEntity savepaymentscbatranscations(
			PaymentCBATranscationHistEntity cbaTranscationHistEntity);

	public PaymentRefundTranscationHistEntity savepaymentsrefundtranscations(
			PaymentRefundTranscationHistEntity refundTranscationHistEntity);

}
