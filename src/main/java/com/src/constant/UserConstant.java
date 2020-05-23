package com.src.constant;

/**
 * The <code> UserConstant </code> class contains constants for
 * <code>UserDetails</code>.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */
public class UserConstant {

	private UserConstant() {
		super();
	}

	// Logger Message
	public static final String USER_DAO_FINDBYUSERNAME = "Inside USER DAO findByUsername method";
	public static final String USER_DAO_CHECKUSERNAME = "Inside User DAO CheckUsername method";
	public static final String USER_DAO_SAVEUSER = "Inside USER DAO saveUser method";
	public static final String USER_DAO_SAVEUSERNOTIFICATIONS = "Inside USER NOTIFICATION DAO saveUserNotification method";
	public static final String USER_DAO_SUCCESSFULL_SAVEUSERNOTIFICATION = "At User DAO saveUserNotification method :  Saved User Notification Details Succesfully : New Notification Id :";
	public static final String USER_DAO_SUCCESSFULL_SAVEUSER = "At User DAO saveUser method :  Saved User Details Succesfully : New User Id :";
	public static final String USER_DAO_GETUSERBYUSERID = "Inside USER DAO getUserByUserId method";
	public static final String USER_DAO_GETALLUSERS = "Inside USER DAO getAllUsers method";
	public static final String USER_DAO_INSIDE_GETALLUSERS = "Inside USER DAO getAllUsers method : Get All Users :";
	public static final String USER_DAO_GETUSERSBYROLE = "Inside DAO getUsersByRole method ";
	public static final String USER_DAO_GETALLUSERDETAILSWHENPROFILEINCOMPLETED = "Inside DAO getFUUserDetailsWhenInCompleteProfile method ";
	public static final String USER_DAO_INSIDE_GETUSERSBYROLE = "Inside USER DAO getUsersByRole method : Get All Users By Role :";
	public static final String USER_DAO_SAVEORUPDATEUSERDETAILS = "Inside USER DAO saveorupdateUserDetails method ";
	public static final String USER_DAO_INSIDE_SAVEORUPDATEUSERDETAILS = "Inside DAO saveorupdateUserDetails method : User Details Updated for UserId :";
	public static final String USER_DAO_GETUSERSBYRECOVERYPD = "Inside USER DAO getUserByRecoveryPwd method";
	public static final String USER_SERVICE_DAO_GETUSERSERVICEBYUSERID = "Inside New Service DAO getUserServiceDetailsByUserId method";
	public static final String USER_SERVICE_DAO_GETUSERSERVICEBYSERVICEID = "Inside New Service DAO getUserServiceDetailsByServiceId method";
	public static final String USER_SERVICE_DAO_INSIDE_GETUSERBYRECOVERYPD = "Inside User Service DAO getUserByRecoveryPwd method : get All User Service Details :";
	public static final String USER_DAO_GETNOTIFICATIONUSEDETAILSBYUSERID = "Inside USER DAO getNotificationDetailsByUserId method";
	public static final String NEW_SERVICE_DAO_GETALLUSERSERVICEDETAILSBYMANAGEID = "Inside New Service DAO getAllNewServiceDetailsByManagerId method";
	public static final String USER_DAO_GETALLFREELANCEONSERVICE = "Inside USER DAO getAllFreelanceOnServiceDetails method";
	public static final String USER_DAO_INSIDE_GETALLFREELANCEONSERVICE = "Inside USER DAO getAllFreelanceOnServiceDetails method : Get All Free Lance On Service :";
	public static final String USER_DETAILS = "userdetails";
	public static final String USER_DETAILS_ISRECOVERYPD = "isrecoverypwd";
	public static final String FREELANCE_ON_SERVICE_DAO_GETUSERSERVICEBYUSERID = "Inside New Service DAO getFreeLanceOnServiceDetailsByUserId method";
	public static final String USER_DAO_USERROLE = "Inside USER DAO userRole method";
	public static final String USERNAME = "username";
	public static final String USERPSWD = "password";
	public static final String USERID = "userId";
	public static final String JOB_ID = "jobId";
	public static final String JOB_CREATED_ON = "jobCreatedOn";
	public static final String JOB_SUBCATEGORY = "scategory";
	public static final String TXTID = "txnid";
	public static final String ISACTIVE = "isactive";
	public static final String FREELANCEDETAILS = "freeLanceDetails";
	public static final String FREELANCEDETAILS_ALIAS = "fUDetails";
	public static final String FU_IS_PROFILE_COMPLETED = "fUDetails.isprofilecompleted";
	public static final String FU_ISJOBAVAILABLE = "fUDetails.isJobAvailable";
	public static final String FU_ISBGDONE = "fUDetails.isbgdone";
	public static final String USERBIZDETAILS = "userbizdetails";
	public static final String USERBIZDETAILS_ALIAS = "BizDetails";
	public static final String FU_FULLADDRESS = "BizDetails.fulladdress";
	public static final String USERMANAGERDETAILS = "usermanagerdetailsentity";
	public static final String USERMANAGERDETAILS_ALIAS = "usermanager";
	public static final String UROLE = "urole";
	public static final String USERROLES = "userroles";
	public static final String UROLE_ROLECODE = "urole.rolecode";
	public static final String USER_MANAGER = "userManager";
	public static final String ROLE = "role";
	public static final String SERVICEID = "serviceId";
	public static final String FREELANCEHIST = "freelancehis";
	public static final String FREELANCEHISOTRY = "freelancehistoryentity";
	public static final String FHISTORY_ISLOCKED = "freelancehis.islocked";
	public static final String FHISTORY_BGSTATUS = "freelancehis.bgstatus";
	public static final String FHISTORY_BGSTATUS_CSSM = "BG_SENTTOCSSM";
	public static final String FHISTORY_BGSTATUS_CSST = "BG_SENTTOCSST";
	public static final String CLIENT_BUSINESS_ADMINISTRATOR = "CLIENT_BUSINESS_ADMINISTRATOR";
	public static final String FREELANCER_USER = "FREELANCER_USER";
	public static final Object CORE_SERVICE_SUPPORT_MANAGER = "CORE_SERVICE_SUPPORT_MANAGER";
	public static final Object CORE_SERVICE_SUPPORT_TEAM = "CORE_SERVICE_SUPPORT_TEAM";

}
