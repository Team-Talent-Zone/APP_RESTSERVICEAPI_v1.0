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

import com.src.constant.CustomMsgProperties;
import com.src.constant.NewServiceConstant;
import com.src.entity.NewServiceEntity;
import com.src.entity.NewServiceHistoryEntity;
import com.src.exception.RestCustomException;
import com.src.utils.CommonUtilites;

/**
 * The <code> NewServiceDAOImpl </code> class handles data access operation for
 * <code>New Service</code>.
 * 
 * @author Shanoor
 * @version 1.0
 *
 */
@Repository
@Transactional(rollbackFor = { Exception.class })
public class NewServiceDAOImpl extends AbstractDAOManager implements NewServiceDAO {
	final Logger LOGGER = LoggerFactory.getLogger(NewServiceDAOImpl.class);

	/**
	 * To save the New Service Details.
	 * 
	 * @param newServiceEntity
	 * @throw RestCustomException
	 */

	@Transactional
	public NewServiceEntity saveNewService(NewServiceEntity newServiceEntity) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVENEWSERVICE);
		int serviceSavedID = (Integer) sessionFactory.getCurrentSession().save(newServiceEntity);
		LOGGER.debug(NewServiceConstant.CONFIRM_SAVE_NEWSERVICE + serviceSavedID);
		if (serviceSavedID > 0) {
			return newServiceEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To save or Update the New Service Details.
	 * 
	 * @param newServiceEntity
	 * @throw RestCustomException
	 */
	@Transactional
	public void saveOrUpdateNewService(NewServiceEntity newServiceEntity) {
		try {
			LOGGER.info(NewServiceConstant.INSIDE_SAVEORUPDATE_NEWSERVICE);
			sessionFactory.getCurrentSession().saveOrUpdate(newServiceEntity);
			LOGGER.info(NewServiceConstant.CONFIRMED_SAVEORUPDATE_NEWSERVICE + newServiceEntity.getOurserviceId());
		} catch (RestCustomException e) {
			throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
					.getProperty(CustomMsgProperties.SAVEORUPDATESERVICEDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}

	/**
	 * To save New Service History Details.
	 * 
	 * @param newServiceHistoryEntity
	 * @throw RestCustomException
	 */
	@Transactional
	public NewServiceHistoryEntity saveNewServiceHistory(NewServiceHistoryEntity newServiceHistoryEntity) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVENEWSERVICEHISTORY);
		int serviceHistorySavedID = (Integer) sessionFactory.getCurrentSession().save(newServiceHistoryEntity);
		LOGGER.debug(NewServiceConstant.INSIDE_SAVENEWSERVICEHISTORY + serviceHistorySavedID);
		if (serviceHistorySavedID > 0) {
			return newServiceHistoryEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To Get all the Service Details.
	 * 
	 * @throw RestCustomException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<NewServiceEntity> getAllNewServices() {
		LOGGER.info(NewServiceConstant.NEW_SERVICE_DAO_GETALLSERVICEDETAILS);
		List<NewServiceEntity> newServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(NewServiceEntity.class);
	 
		newServiceEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = newServiceEntity != null ? newServiceEntity.size() : 0;
		LOGGER.debug(NewServiceConstant.NEW_SERVICE_DAO_INSIDE_GETALLSERVICEDETAILS + size);
		if (size > 0) {
			return (ArrayList<NewServiceEntity>) newServiceEntity;
		}
		return null;
	}

	/**
	 * Get All New Service Details by managerId.
	 * 
	 * @throw RestCustomException
	 * 
	 * @param managerId
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public ArrayList<NewServiceHistoryEntity> getAllNewServiceDetailsByManagerId(int managerId) {
		LOGGER.info(NewServiceConstant.NEW_SERVICE_DAO_GETALLSERVICEDETAILSBYMANAGERID);
		List<NewServiceHistoryEntity> newServiceHistoryEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(NewServiceEntity.class);
		criteria.createAlias(NewServiceConstant.SERVICE_HISTORY_ALIAS_MAPPING,
				NewServiceConstant.SERVICE_HISTORY_MAPPING_OBJ, JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq(NewServiceConstant.SERVICE_HISTORY_USING_MANAGERID, managerId));
		newServiceHistoryEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = newServiceHistoryEntity != null ? newServiceHistoryEntity.size() : 0;
		LOGGER.debug(NewServiceConstant.NEW_SERVICE_DAO_INSIDE_GETALLSERVICEDETAILSBYMANAGERID + size);
		if (size > 0) {
			return (ArrayList<NewServiceHistoryEntity>) newServiceHistoryEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.SERVICE_NOTFOUND_ERRORMSG)
						+ " for managerId : " + managerId);
	}

	/**
	 * Get All New Service Details by userId.
	 * 
	 * @throw RestCustomException
	 * @param userId
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public ArrayList<NewServiceHistoryEntity> getAllNewServiceDetailsByUserId(int userId) {
		LOGGER.info(NewServiceConstant.NEW_SERVICE_DAO_GETALLSERVICEDETAILSBYUSERID);
		List<NewServiceHistoryEntity> newServiceHistoryEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(NewServiceEntity.class);
		criteria.createAlias(NewServiceConstant.SERVICE_HISTORY_ALIAS_MAPPING,
				NewServiceConstant.SERVICE_HISTORY_MAPPING_OBJ, JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq(NewServiceConstant.SERVICE_HISTORY_USING_USERID, userId));
		newServiceHistoryEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = newServiceHistoryEntity != null ? newServiceHistoryEntity.size() : 0;
		LOGGER.debug(NewServiceConstant.NEW_SERVICE_DAO_INSIDE_GETALLSERVICEDETAILSBYUSERID + size);
		if (size > 0) {
			return (ArrayList<NewServiceHistoryEntity>) newServiceHistoryEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.SERVICE_NOTFOUND_ERRORMSG)
						+ " for userId : " + userId);
	}

	/**
	 * Get New Service Details created.
	 * 
	 * @throw RestCustomException
	 */
	@SuppressWarnings("unchecked") 
	@Override
	public ArrayList<NewServiceEntity> getNewServiceDetailsCreated() {
		List<NewServiceEntity> newServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(NewServiceEntity.class);
		criteria.add(Restrictions.eq("createdOn", CommonUtilites.getPreviousDate()));
		criteria.createAlias(NewServiceConstant.SERVICE_HISTORY, NewServiceConstant.SERVICE_HISTORY_ALIAS,
				JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq(NewServiceConstant.SERVICE_HISTORY_ALIAS_STATUS,
				NewServiceConstant.NEW_SERVICE_STATUS_APPROVED));
		newServiceEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = newServiceEntity != null ? newServiceEntity.size() : 0;
		if (size > 0) {
			return (ArrayList<NewServiceEntity>) newServiceEntity;
		}
		return null;
	} 

	/**
	 * To check if the service name is exist by passing service name.
	 * 
	 * @param servicename
	 */
	public boolean checkNewServiceIsExist(String servicename) {

		NewServiceEntity newServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(NewServiceEntity.class);
		criteria.add(Restrictions.eq(NewServiceConstant.NAME, servicename));
		newServiceEntity = (NewServiceEntity) criteria.uniqueResult();
		if (newServiceEntity != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * To Get the all Service Details by service id.
	 * 
	 * @return
	 */
	public NewServiceEntity getNewServiceDetailsByServiceId(int ourserviceId) {

		NewServiceEntity newServiceEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(NewServiceEntity.class);
		criteria.add(Restrictions.eq(NewServiceConstant.OURSERVICEID, ourserviceId));
		newServiceEntity = (NewServiceEntity) criteria.uniqueResult();
		if (newServiceEntity != null) {
			return newServiceEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgProperties.NEWSERVICE_NOTFOUND_ERRORMSG) + " "
						+ newServiceEntity);
	
	}
}
