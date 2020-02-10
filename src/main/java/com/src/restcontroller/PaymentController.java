package com.src.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.entity.PaymentCBATranscationHistEntity;
import com.src.entity.PaymentEntity;
import com.src.entity.PaymentFUTranscationHistEntity;
import com.src.entity.PaymentRefundTranscationHistEntity;

@Controller
public class PaymentController extends AbstractRestManager {

	final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@RequestMapping(value = "/savepayments", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentEntity> savepayments(@RequestBody PaymentEntity paymentEntity) {
		PaymentEntity paymentEnityRespObj = paymentService.savepayments(paymentEntity);
		return new ResponseEntity<PaymentEntity>(paymentEnityRespObj, HttpStatus.OK);
	}

	@RequestMapping(value = "/savepaymentsfutranscations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentFUTranscationHistEntity> savepaymentsfutranscations(
			@RequestBody PaymentFUTranscationHistEntity fuTranscationHistEntity) {
		PaymentFUTranscationHistEntity paymentEnityRespObj = paymentService
				.savepaymentsfutranscations(fuTranscationHistEntity);
		return new ResponseEntity<PaymentFUTranscationHistEntity>(paymentEnityRespObj, HttpStatus.OK);
	}

	@RequestMapping(value = "/savepaymentscbatranscations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentCBATranscationHistEntity> savepaymentscbatranscations(
			@RequestBody PaymentCBATranscationHistEntity cbaTranscationHistEntity) {
		PaymentCBATranscationHistEntity paymentEnityRespObj = paymentService
				.savepaymentscbatranscations(cbaTranscationHistEntity);
		return new ResponseEntity<PaymentCBATranscationHistEntity>(paymentEnityRespObj, HttpStatus.OK);
	}

	@RequestMapping(value = "/savepaymentsrefundtranscations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentRefundTranscationHistEntity> savepaymentsrefundtranscations(
			@RequestBody PaymentRefundTranscationHistEntity refundTranscationHistEntity) {
		PaymentRefundTranscationHistEntity paymentEnityRespObj = paymentService
				.savepaymentsrefundtranscations(refundTranscationHistEntity);
		return new ResponseEntity<PaymentRefundTranscationHistEntity>(paymentEnityRespObj, HttpStatus.OK);
	}

}