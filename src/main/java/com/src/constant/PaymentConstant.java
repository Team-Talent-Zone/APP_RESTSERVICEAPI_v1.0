package com.src.constant;

/**
 * The <code> PaymentConstant </code> class contains constants for
 * <code>Payments</code>.
 * 
 * @author Shanoor
 * @version 1.0
 * 
 */
public class PaymentConstant {
	
	//SAVE
	public static final String  SAVE_PAYMENT = "At Payment DAO save savePayments method :  Saved Payment Details Succesfully : Payment Id :";
	public static final String  SAVEPAYMENTSFUTRANS = "At Payment DAO save method :  Payment FU Transcation Details Succesfully : New User Id :";
	public static final String  SAVEPAYMENTSCBATRANSACTIONS = "At Payment DAO save method :  Saved Payment CBA Transcation Details Succesfully : Id :";
	public static final String  SAVEPAYMENTSREFUNDTRANSACTION = "At Payment DAO saveUser method :  Payment REFUND Transcation Details Succesfully : Id :";
	public static final String  SAVEPAYMENTSNOTIFICATIONHISTORY = "At Payment DAO saveUser method :  Payment Notification History Details Succesfully : Id :";

	//GET
	public static final String PAYMENT_GETPAYMENT_DETAILSBYUSERID = "Inside Payment DAO getPaymentDetailsByUserId method";
	public static final String PAYMENT_GETFUPAYMENT_DETAILSBYUSERID = "Inside Payment DAO getPaymentFUDetailsByUserId method";
	public static final String PAYMENT_GETCBAPAYMENT_DETAILSBYUSERID = "Inside Payment DAO getPaymentCBADetailsByUserId method";
	public static final String PAYMENT_GETPAYMENTHISTNOTI_DETAILSBYUSERID = "Inside Payment DAO getPaymentRefundTranHistByUserId method";
	
	public static final String paymentKey = "mkey";

	public static final String paymentSalt = "salt"; 
	
	public static final String serviceProvider = "payu_paisa"; 

	public static final String sUrl = "surlServer";

	public static final String fUrl = "furlServer";
}
