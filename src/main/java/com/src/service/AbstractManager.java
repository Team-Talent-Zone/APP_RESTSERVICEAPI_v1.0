package com.src.service;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.src.dao.UserRestDAO;

public class AbstractManager {

	@Resource(name = "applicationConfigProperties")
	protected Properties applicationConfigProperties;

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected UserRestDAO userRestDAO;

	 

}
