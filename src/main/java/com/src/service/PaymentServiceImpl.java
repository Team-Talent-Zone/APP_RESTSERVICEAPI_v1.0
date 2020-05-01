package com.src.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentNotificationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;
import com.src.entity.ReferenceLookUpTemplateEntity;
import com.src.entity.UserEntity;
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

		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(paymentEntity.getUserId());
		paymentEntity.setUserdetails(userEntity); 
		
		 PaymentUtil paymentUtil = new PaymentUtil();
		 paymentEntity = paymentUtil.populatePaymentDetail(paymentEntity);
	         
		return paymentEntity;
		//paymentDAO.savePayments(paymentEntity);
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
	public PaymentFUTranscationHistEntity getPaymentFUDetailsByUserId(int userId) {
		return paymentDAO.getPaymentFUDetailsByUserId(userId);
	}

	/**
	 * Get the CBA Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@Override
	public PaymentCBATranscationHistEntity getPaymentCBADetailsByUserId(int userId) {
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
}
