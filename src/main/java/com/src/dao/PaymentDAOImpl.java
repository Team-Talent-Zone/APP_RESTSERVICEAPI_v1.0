package com.src.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.CustomMsgProperties;
import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;
import com.src.exception.RestCustomException;

@Repository
@Transactional(rollbackFor = { Exception.class })
public class PaymentDAOImpl extends AbstractDAOManager implements PaymentDAO {

	final Logger logger = LoggerFactory.getLogger(PaymentDAOImpl.class);

	@Transactional
	public PaymentEntity savepayments(PaymentEntity paymentEntity) {
		int savedId = (Integer) sessionFactory.getCurrentSession().save(paymentEntity);
		logger.debug("At Payment DAO save  method :  Saved Payment Details Succesfully : Payment Id :" + savedId);
		if (savedId > 0) {
			return paymentEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.SAVEPAYMENTDETAILS_UNABLETOSAVE_ERRORMSG));

	}

	@Transactional
	public PaymentFUTranscationHistEntity savepaymentsfutranscations(
			PaymentFUTranscationHistEntity fuTranscationHistEntity) {
		int savedId = (Integer) sessionFactory.getCurrentSession().save(fuTranscationHistEntity);
		logger.debug(
				"At Payment DAO save method :  Payment FU Transcation Details Succesfully : New User Id :" + savedId);
		if (savedId > 0) {
			return fuTranscationHistEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.SAVEPAYMENTFUTRANSDETAILS_UNABLETOSAVE_ERRORMSG));

	}

	@Transactional
	public PaymentCBATranscationHistEntity savepaymentscbatranscations(
			PaymentCBATranscationHistEntity cbaTranscationHistEntity) {
		int savedId = (Integer) sessionFactory.getCurrentSession().save(cbaTranscationHistEntity);
		logger.debug(
				"At Payment DAO save method :  Saved Payment CBA Transcation Details Succesfully : Id :" + savedId);
		if (savedId > 0) {
			return cbaTranscationHistEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.SAVEPAYMENTCBATRANSDETAILS_UNABLETOSAVE_ERRORMSG));

	}

	@Transactional
	public PaymentRefundTranscationHistEntity savepaymentsrefundtranscations(
			PaymentRefundTranscationHistEntity refundTranscationHistEntity) {
		int savedId = (Integer) sessionFactory.getCurrentSession().save(refundTranscationHistEntity);
		logger.debug(
				"At Payment DAO saveUser method :  Payment REFUND Transcation Details Succesfully : Id :" + savedId);
		if (savedId > 0) {
			return refundTranscationHistEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.SAVEPAYMENTREFUNDTRANSDETAILS_UNABLETOSAVE_ERRORMSG));

	}
}
