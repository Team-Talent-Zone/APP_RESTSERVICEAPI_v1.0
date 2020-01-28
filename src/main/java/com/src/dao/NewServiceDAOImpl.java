package com.src.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.AppConfig;
import com.src.constant.NewServiceConstant;
import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.entity.NewServicePackageEntity;
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
	final Logger LOGGER = LoggerFactory.getLogger(NewServiceDAOImpl.class);

	@Transactional
	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVENEWSERVICE);
		int serviceSavedID = (Integer) sessionFactory.getCurrentSession().save(newServiceEntity);
		LOGGER.debug(NewServiceConstant.CONFIRM_SAVE_NEWSERVICE + serviceSavedID);
		if (serviceSavedID > 0) {
			return newServiceEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(AppConfig.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	@Transactional
	public void saveOrUpdateNewService(NewServiceEntity newServiceEntity) {
		try {
			LOGGER.info(NewServiceConstant.INSIDE_SAVEORUPDATE_NEWSERVICE);
			sessionFactory.getCurrentSession().saveOrUpdate(newServiceEntity);
			LOGGER.info(NewServiceConstant.CONFIRMED_SAVEORUPDATE_NEWSERVICE + newServiceEntity.getOurserviceId());
		} catch (RestCustomException e) {
			throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
					.getProperty(AppConfig.SAVEORUPDATESERVICEDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}

	@Transactional
	public NewServiceHistoryEntity saveNewServiceHistory(NewServiceHistoryEntity newServiceHistoryEntity) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVENEWSERVICEHISTORY);
		int serviceHistorySavedID = (Integer) sessionFactory.getCurrentSession().save(newServiceHistoryEntity);
		LOGGER.debug(NewServiceConstant.INSIDE_SAVENEWSERVICEHISTORY + serviceHistorySavedID);
		if (serviceHistorySavedID > 0) {
			return newServiceHistoryEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(AppConfig.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	@Transactional
	public NewServicePackageEntity saveNewServicePackage(NewServicePackageEntity newServicePackageEntity) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVENEWSERVICEPACKAGE);
		int servicePackageSavedID = (Integer) sessionFactory.getCurrentSession().save(newServicePackageEntity);
		LOGGER.debug(NewServiceConstant.CONFIRM_SAVE_NEWSERVICEPACKAGE + servicePackageSavedID);
		if (servicePackageSavedID > 0) {
			return newServicePackageEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(AppConfig.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<NewServiceEntity> getAllServiceDetails() {
		LOGGER.info(NewServiceConstant.NEW_SERVICE_DAO_GETALLSERVICEDETAILS);
		List<NewServiceEntity> newServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(NewServiceEntity.class);
		criteria.createAlias(NewServiceConstant.SERVICE_HISTORY, NewServiceConstant.SERVICE_HISTORY_ALIAS,
				JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq(NewServiceConstant.SERVICE_HISTORY_ALIAS_STATUS,
				NewServiceConstant.NEW_SERVICE_STATUS_APPROVED));
		newServiceEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = newServiceEntity != null ? newServiceEntity.size() : 0;
		LOGGER.debug(NewServiceConstant.NEW_SERVICE_DAO_INSIDE_GETALLSERVICEDETAILS + size);
		if (size > 0) {
			return (ArrayList<NewServiceEntity>) newServiceEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(AppConfig.GETALLUSERS_NOUSERSFOUND_ERRORMSG));
	}

}
