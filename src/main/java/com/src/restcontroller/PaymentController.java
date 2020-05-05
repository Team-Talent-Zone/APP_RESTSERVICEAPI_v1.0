package com.src.restcontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.src.constant.UserConstant;
import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentMode;
import com.src.entity.PaymentNotificationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;

/**
 * The <code> PaymentController </code> class defines managed beans which
 * provides back-end functionality on the <code>Payment</code> Details.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Controller
public class PaymentController extends AbstractRestManager {
	final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	/**
	 * Method is to save Payment Details.
	 * 
	 * @param paymentEntity
	 */
	@RequestMapping(value = "/savePayments/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentEntity> savePayments(@RequestBody PaymentEntity paymentEntity) {
		PaymentEntity paymentEnityRespObj = paymentService.savePayments(paymentEntity);
		return new ResponseEntity<PaymentEntity>(paymentEnityRespObj, HttpStatus.OK);
	}

	/**
	 * Method is to save PaymentFU Transaction Details.
	 * 
	 * @param fuTranscationHistEntity
	 */
	@RequestMapping(value = "/savePaymentsFUTranscations/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentFUTranscationHistEntity> savePaymentsFUTranscations(
			@RequestBody PaymentFUTranscationHistEntity fuTranscationHistEntity) {
		PaymentFUTranscationHistEntity paymentEnityRespObj = paymentService
				.savePaymentsFUTranscations(fuTranscationHistEntity);
		return new ResponseEntity<PaymentFUTranscationHistEntity>(paymentEnityRespObj, HttpStatus.OK);
	}

	@RequestMapping(path = "/payment-response", method = RequestMethod.POST)
	public @ResponseBody void payuCallback(@RequestParam String mihpayid, @RequestParam String status,
			@RequestParam PaymentMode mode, @RequestParam String txnid, @RequestParam String hash,
			HttpServletResponse res) throws IOException {
		if (mihpayid != null) {
			String transcationid = paymentService.payuCallback(mihpayid, txnid, mode, hash, status);
			res.sendRedirect("http://localhost:4200/dashboard/" + transcationid);
		} else {
			res.sendRedirect("http://localhost:4200/dashboard/");
		}
	}

	/**
	 * Method is to save Payment CBA Transaction Details.
	 * 
	 * @param cbaTranscationHistEntity
	 */
	@RequestMapping(value = "/savePaymentsCBATranscations/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentCBATranscationHistEntity> savePaymentsCBATranscations(
			@RequestBody PaymentCBATranscationHistEntity cbaTranscationHistEntity) {
		PaymentCBATranscationHistEntity paymentEnityRespObj = paymentService
				.savePaymentsCBATranscations(cbaTranscationHistEntity);
		return new ResponseEntity<PaymentCBATranscationHistEntity>(paymentEnityRespObj, HttpStatus.OK);
	}

	/**
	 * Method is to Save Refund Payment Transaction Details.
	 * 
	 * @param refundTranscationHistEntity
	 */
	@RequestMapping(value = "/savePaymentsRefundTranscations/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentRefundTranscationHistEntity> savePaymentsRefundTranscations(
			@RequestBody PaymentRefundTranscationHistEntity refundTranscationHistEntity) {
		PaymentRefundTranscationHistEntity paymentEnityRespObj = paymentService
				.savePaymentsRefundTranscations(refundTranscationHistEntity);
		return new ResponseEntity<PaymentRefundTranscationHistEntity>(paymentEnityRespObj, HttpStatus.OK);
	}

	/**
	 * Method is to Save Transaction Notification History Details.
	 * 
	 * @param savePaymentsNotificationHistory
	 */
	@RequestMapping(value = "/savePaymentsNotificationHistory/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentNotificationHistEntity> savePaymentsNotificationHistory(
			@RequestBody PaymentNotificationHistEntity paymentNotificationHistEntity) {
		PaymentNotificationHistEntity paymentEnityRespObj = paymentService
				.savePaymentsNotificationHistory(paymentNotificationHistEntity);
		return new ResponseEntity<PaymentNotificationHistEntity>(paymentEnityRespObj, HttpStatus.OK);
	}

	/**
	 * Get the Complete Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getPaymentDetailsByUserId/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentEntity> getPaymentDetailsByUserId(@PathVariable(UserConstant.USERID) int userId) {
		PaymentEntity paymentEntity = paymentService.getPaymentDetailsByUserId(userId);
		return new ResponseEntity<PaymentEntity>(paymentEntity, HttpStatus.OK);
	}

	@RequestMapping(value = "/getPaymentDetailsByTxnId/{txnid}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentEntity> getPaymentDetailsByTxnId(@PathVariable String txnid) {
		PaymentEntity paymentEntity = paymentService.getPaymentDetailsByTxnId(txnid);
		return new ResponseEntity<PaymentEntity>(paymentEntity, HttpStatus.OK);
	}

	/**
	 * Get the FU Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getPaymentFUDetailsByUserId/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentFUTranscationHistEntity> getPaymentFUDetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		PaymentFUTranscationHistEntity paymentEntity = paymentService.getPaymentFUDetailsByUserId(userId);
		return new ResponseEntity<PaymentFUTranscationHistEntity>(paymentEntity, HttpStatus.OK);
	}

	/**
	 * Get the CBA Payment Details by UserId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getPaymentCBADetailsByUserId/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentCBATranscationHistEntity> getPaymentCBADetailsByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		PaymentCBATranscationHistEntity paymentEntity = paymentService.getPaymentCBADetailsByUserId(userId);
		return new ResponseEntity<PaymentCBATranscationHistEntity>(paymentEntity, HttpStatus.OK);
	}

	/**
	 * Get the Refund Transaction History Details by UserId.
	 * 
	 * @param userId
	 */
	@RequestMapping(value = "/getPaymentRefundTranHistByUserId/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentRefundTranscationHistEntity> getPaymentRefundTranHistByUserId(
			@PathVariable(UserConstant.USERID) int userId) {
		PaymentRefundTranscationHistEntity paymentEntity = paymentService.getPaymentRefundTranHistByUserId(userId);
		return new ResponseEntity<PaymentRefundTranscationHistEntity>(paymentEntity, HttpStatus.OK);
	}

}