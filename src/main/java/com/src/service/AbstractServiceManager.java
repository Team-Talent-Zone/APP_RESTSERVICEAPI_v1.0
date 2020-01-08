package com.src.service;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.src.dao.ReferenceLookUpDAO;
import com.src.dao.UserRestDAO;

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

}
