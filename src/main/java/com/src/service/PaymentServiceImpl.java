package com.src.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;
import com.src.utils.CommonUtilites;

@Service("paymentdManager")
@Transactional(rollbackFor = { Exception.class })
public class PaymentServiceImpl extends AbstractServiceManager implements PaymentService {

	final static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Override
	public PaymentEntity savepayments(PaymentEntity paymentEntity) {
		paymentEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());
		return paymentDAO.savepayments(paymentEntity);
	}

	@Override
	public PaymentFUTranscationHistEntity savepaymentsfutranscations(
			PaymentFUTranscationHistEntity fuTranscationHistEntity) {
		return paymentDAO.savepaymentsfutranscations(fuTranscationHistEntity);
	}

	@Override
	public PaymentCBATranscationHistEntity savepaymentscbatranscations(
			PaymentCBATranscationHistEntity cbaTranscationHistEntity) {
		return paymentDAO.savepaymentscbatranscations(cbaTranscationHistEntity);
	}

	@Override
	public PaymentRefundTranscationHistEntity savepaymentsrefundtranscations(
			PaymentRefundTranscationHistEntity refundTranscationHistEntity) {
		return paymentDAO.savepaymentsrefundtranscations(refundTranscationHistEntity);
	}
}
