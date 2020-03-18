package com.src.dao;

import java.util.Properties;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * This <code>AbstractDAOManager </code> defines Application Config Properties.
 * 
 * @author Ishaq.
 * @version 1.0
 *
 */
@Controller
class AbstractDAOManager {

	@Autowired
	protected SessionFactory sessionFactory;

	@Resource(name = "applicationConfigProperties")
	protected Properties applicationConfigProperties;
}