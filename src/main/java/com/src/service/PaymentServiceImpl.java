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

/**
 * The <code> PaymentServiceImpl </code> class defines Payment Service Details.
 * 
 * @author Ishaq
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
	public PaymentEntity savepayments(PaymentEntity paymentEntity) {
		paymentEntity.setCreatedon(CommonUtilites.getCurrentDateInNewFormat());
		return paymentDAO.savepayments(paymentEntity);
	}

	/**
	 * To Save payment FU Transaction Details.
	 */
	@Override
	public PaymentFUTranscationHistEntity savepaymentsfutranscations(
			PaymentFUTranscationHistEntity fuTranscationHistEntity) {
		return paymentDAO.savepaymentsfutranscations(fuTranscationHistEntity);
	}

	/**
	 * To Save Payments CBA Transaction Details.
	 */
	@Override
	public PaymentCBATranscationHistEntity savepaymentscbatranscations(
			PaymentCBATranscationHistEntity cbaTranscationHistEntity) {
		return paymentDAO.savepaymentscbatranscations(cbaTranscationHistEntity);
	}

	/**
	 * To Save Payment Refund Transactions Details.
	 */
	@Override
	public PaymentRefundTranscationHistEntity savepaymentsrefundtranscations(
			PaymentRefundTranscationHistEntity refundTranscationHistEntity) {
		return paymentDAO.savepaymentsrefundtranscations(refundTranscationHistEntity);
	}
}
