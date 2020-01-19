package com.src.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.AppConfig;
import com.src.constant.NewServiceConstant;
import com.src.entity.NewServiceEntity;
import com.src.exception.RestCustomException;

/**
 * The <code> NewServiceDAOImpl </code> class handles data access operation for
 * <code>New Service</code>.
 * 
 * @author Shanoor
 *
 */
@Repository
@Transactional(rollbackFor = { Exception.class })
public class NewServiceDAOImpl extends AbstractDAOManager implements NewServiceDAO {
	final Logger logger = LoggerFactory.getLogger(NewServiceDAOImpl.class);

	@Transactional
	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity) {
		logger.info(NewServiceConstant.INSIDE_SAVENEWSERVICE);
		int serviceSavedID = (Integer) sessionFactory.getCurrentSession().save(newServiceEntity);
		logger.debug(NewServiceConstant.CONFIRM_SAVE_NEWSERVICE + serviceSavedID);
		if (serviceSavedID > 0) {
			return newServiceEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(AppConfig.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}
}
