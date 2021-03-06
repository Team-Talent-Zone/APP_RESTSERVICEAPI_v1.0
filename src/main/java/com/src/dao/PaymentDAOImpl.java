package com.src.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.CustomMsgProperties;
import com.src.constant.PaymentConstant;
import com.src.constant.UserConstant;
import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentNotificationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;
import com.src.exception.RestCustomException;

/**
 * This <code> PaymentDAOImpl </code> class handles data access operation for
 * Payments Details.
 * 
 * @author Shanoor.
 * @version 1.0
 *
 */
@Repository
@Transactional(rollbackFor = { Exception.class })
public class PaymentDAOImpl extends AbstractDAOManager implements PaymentDAO {

	final Logger logger = LoggerFactory.getLogger(PaymentDAOImpl.class);

	/**
	 * This method savePayments is to save the payment details.
	 * 
	 * @throws RestCustomException
	 * @param paymentEntity
	 */
	@Transactional
	public PaymentEntity savePayments(PaymentEntity paymentEntity) {
		int paymentId = (Integer) sessionFactory.getCurrentSession().save(paymentEntity);
		logger.debug(PaymentConstant.SAVE_PAYMENT + paymentId);
		if (paymentId > 0) {
			return paymentEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.SAVEPAYMENTDETAILS_UNABLETOSAVE_ERRORMSG));

	}

	/**
	 * This method savepaymentsfutranscations is to save the FU Transaction details.
	 * 
	 * @throws RestCustomException
	 * @param fuTranscationHistEntity
	 */
	@Transactional
	public PaymentFUTranscationHistEntity savePaymentsFUTranscations(
			PaymentFUTranscationHistEntity fuTranscationHistEntity) {
		int paymentFUTransactionId = (Integer) sessionFactory.getCurrentSession().save(fuTranscationHistEntity);
		logger.debug(PaymentConstant.SAVEPAYMENTSFUTRANS + paymentFUTransactionId);
		if (paymentFUTransactionId > 0) {
			return fuTranscationHistEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
				.getProperty(CustomMsgProperties.SAVEPAYMENTFUTRANSDETAILS_UNABLETOSAVE_ERRORMSG));

	}

	/**
	 * This method savepaymentscbatranscations is to save the CBA Transaction
	 * details.
	 * 
	 * @throws RestCustomException
	 * @param cbaTranscationHistEntity
	 */
	@Transactional
	public PaymentCBATranscationHistEntity savePaymentsCBATranscations(
			PaymentCBATranscationHistEntity cbaTranscationHistEntity) {
		int paymentCBATransactionId = (Integer) sessionFactory.getCurrentSession().save(cbaTranscationHistEntity);
		logger.debug(PaymentConstant.SAVEPAYMENTSCBATRANSACTIONS + paymentCBATransactionId);
		if (paymentCBATransactionId > 0) {
			return cbaTranscationHistEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
				.getProperty(CustomMsgProperties.SAVEPAYMENTCBATRANSDETAILS_UNABLETOSAVE_ERRORMSG));

	}

	/**
	 * This method savepaymentsrefundtranscations is to save the payment Refund
	 * Transaction details.
	 * 
	 * @throws RestCustomException
	 * @param refundTranscationHistEntity
	 */
	@Transactional
	public PaymentRefundTranscationHistEntity savePaymentsRefundTranscations(
			PaymentRefundTranscationHistEntity refundTranscationHistEntity) {
		int refundTransactionID = (Integer) sessionFactory.getCurrentSession().save(refundTranscationHistEntity);
		logger.debug(PaymentConstant.SAVEPAYMENTSREFUNDTRANSACTION + refundTransactionID);
		if (refundTransactionID > 0) {
			return refundTranscationHistEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
				.getProperty(CustomMsgProperties.SAVEPAYMENTREFUNDTRANSDETAILS_UNABLETOSAVE_ERRORMSG));

	}

	/**
	 * This method savePaymentsNotificationHistory is to save the Payment
	 * Notification Details.
	 * 
	 * @throws RestCustomException
	 * @param paymentNotiHistEntity
	 */
	@Transactional
	public PaymentNotificationHistEntity savePaymentsNotificationHistory(
			PaymentNotificationHistEntity paymentNotiHistEntity) {
		int paymentNotificationHistId = (Integer) sessionFactory.getCurrentSession().save(paymentNotiHistEntity);
		logger.debug(PaymentConstant.SAVEPAYMENTSNOTIFICATIONHISTORY + paymentNotificationHistId);
		if (paymentNotificationHistId > 0) {
			return paymentNotiHistEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
				.getProperty(CustomMsgProperties.SAVEPAYMENTREFUNDTRANSDETAILS_UNABLETOSAVE_ERRORMSG));

	}

	/**
	 * Get the Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@Transactional
	public PaymentEntity getPaymentDetailsByTxnId(String txnid) {
		logger.info(PaymentConstant.PAYMENT_GETPAYMENT_DETAILSBYUSERID);
		PaymentEntity paymentEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PaymentEntity.class);
		criteria.add(Restrictions.eq(UserConstant.TXTID, txnid));
		paymentEntity = (PaymentEntity) criteria.uniqueResult();
		if (paymentEntity != null) {
			return paymentEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
						+ " for txnid  : " + txnid);
	}

	/**
	 * Get the Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@Transactional
	public PaymentEntity getPaymentDetailsByUserId(int userId) {
		logger.info(PaymentConstant.PAYMENT_GETPAYMENT_DETAILSBYUSERID);
		PaymentEntity paymentEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PaymentEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		paymentEntity = (PaymentEntity) criteria.uniqueResult();
		if (paymentEntity != null) {
			return paymentEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
						+ " for user Id : " + userId);
	}

	/**
	 * Get the Payment Refund Transaction History Details by UserId.
	 * 
	 * @param userId
	 */
	@Transactional
	public PaymentRefundTranscationHistEntity getPaymentRefundTranHistByUserId(int userId) {
		logger.info(PaymentConstant.PAYMENT_GETPAYMENTHISTNOTI_DETAILSBYUSERID);
		PaymentRefundTranscationHistEntity paymentRefundTranscationHistEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(PaymentRefundTranscationHistEntity.class);
		criteria.add(Restrictions.eq(UserConstant.USERID, userId));
		paymentRefundTranscationHistEntity = (PaymentRefundTranscationHistEntity) criteria.uniqueResult();
		if (paymentRefundTranscationHistEntity != null) {
			return paymentRefundTranscationHistEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
						+ " for user Id : " + userId);
	}

	/**
	 * To save or update the payment details.
	 * 
	 * @param paymentEntity
	 */
	@Transactional
	public void saveorupdatePayments(PaymentEntity paymentEntity) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(paymentEntity);
		} catch (RestCustomException e) {
			throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
					.getProperty(CustomMsgProperties.SAVEPAYMENTDETAILS_UNABLETOSAVE_ERRORMSG));
		}

	}
}
