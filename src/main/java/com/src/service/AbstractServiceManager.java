package com.src.service;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.src.dao.FreeLanceOnServiceDAO;
import com.src.dao.NewServiceDAO;
import com.src.dao.PaymentDAO;
import com.src.dao.ReferenceLookUpDAO;
import com.src.dao.UserRestDAO;
import com.src.dao.UserServiceDetailsDAO;

/**
 * The <code> AbstractServiceManager </code>interface used to provides
 * functionality details.
 *
 */
public class AbstractServiceManager {

	@Resource(name = "applicationConfigProperties")
	protected Properties applicationConfigProperties;

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected UserRestDAO userRestDAO;

	@Autowired
	protected PasswordEncoder encoder;

	@Autowired
	protected ReferenceLookUpDAO referenceLookUpDAO;

	@Autowired
	protected PaymentDAO paymentDAO;

	@Autowired
	protected NewServiceDAO newServiceRestDAO;

	@Autowired
	protected UserServiceDetailsDAO userServiceDetailsDAO;

	@Autowired
	protected FreeLanceOnServiceDAO freeLanceOnServiceDAO;

}
