package com.src.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.AppConfig;
import com.src.entity.UserBizEntity;
import com.src.entity.UserEntity;
import com.src.entity.UserRoleEntity;
import com.src.exception.RestCustomException;

@Repository
@Transactional(rollbackFor = { Exception.class })
public class UserRestDAOImpl extends AbstractDAOManager implements UserRestDAO {

	final Logger logger = LoggerFactory.getLogger(UserRestDAOImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.src.dao.UserRestDAO#findByUsername(java.lang.String)
	 */

	@Transactional
	public UserEntity findByUsername(String username) {
		logger.info("Inside USER DAO findByUsername method");
		UserEntity userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("username", username));
		userEntity = (UserEntity) criteria.uniqueResult();
		if (userEntity != null) {
			return userEntity;
		}
		throw new RestCustomException(
				HttpStatus.NO_CONTENT,
				applicationConfigProperties
						.getProperty(AppConfig.FINDBYUSERNAME_USERNOTFOUND_ERRORMSG)
						+ " for user name :" + username);
	}

	@Transactional
	public UserEntity checkUsername(String username) {
		logger.info("Inside User DAO CheckUsername method ");
		UserEntity userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("username", username));
		userEntity = (UserEntity) criteria.uniqueResult();
		if (userEntity != null) {
			return userEntity;
		}
		throw new RestCustomException(
				HttpStatus.NO_CONTENT,
				applicationConfigProperties
						.getProperty(AppConfig.CHECK_USERNAME_USERNOTFOUND_ERRORMSG)
						+ username);
	}

	@Transactional
	public UserEntity saveUser(UserEntity userEntity) {
		logger.info("Inside USER DAO saveUser method");
		Set<UserRoleEntity> userRoleEntities = new HashSet<UserRoleEntity>();
		for (UserRoleEntity userRoleEntity : userEntity.getUserroles()) {
			userRoleEntities.add(userRoleEntity);
			userRoleEntity.setUserdetails(userEntity);
		}
		Set<UserBizEntity> userBizEntities = new HashSet<UserBizEntity>();
		for (UserBizEntity userBizEntity : userEntity.getUserbizdetails()) {
			userBizEntities.add(userBizEntity);
			userBizEntity.setUserdetails(userEntity);
		}
		userEntity.setUserroles(userRoleEntities);
		userEntity.setUserbizdetails(userBizEntities);
		int savedId = (Integer) sessionFactory.getCurrentSession().save(
				userEntity);
		logger.debug("At User DAO saveUser method :  Saved User Details Succesfully : New User Id :"
				+ savedId);
		if (savedId > 0) {
			return userEntity;
		}
		throw new RestCustomException(
				HttpStatus.BAD_REQUEST,
				applicationConfigProperties
						.getProperty(AppConfig.SAVEUSER_UNABLE_TO_SAVE_ERRORMSG));
	}

	@Transactional
	public UserEntity getUserByUserId(int userId) {
		logger.info("Inside USER DAO getUserByUserId method");
		UserEntity userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("userid", userId));
		userEntity = (UserEntity) criteria.uniqueResult();
		if (userEntity != null) {
			return userEntity;
		}
		throw new RestCustomException(
				HttpStatus.NO_CONTENT,
				applicationConfigProperties
						.getProperty(AppConfig.GETUSERBYUSERID_USERNOTFOUND_ERRORMSG)
						+ " for user Id : " + userId);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<UserEntity> getAllUsers() {
		logger.info("Inside USER DAO getAllUsers method");
		List<UserEntity> userEntity = this.sessionFactory.getCurrentSession()
				.createCriteria(UserEntity.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userEntity != null ? userEntity.size() : 0;
		logger.debug("Inside USER DAO getAllUsers method : Get All Users :"
				+ size);
		if (size > 0) {
			return (ArrayList<UserEntity>) userEntity;
		}
		throw new RestCustomException(
				HttpStatus.NO_CONTENT,
				applicationConfigProperties
						.getProperty(AppConfig.GETALLUSERS_NOUSERSFOUND_ERRORMSG));
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<UserEntity> getUsersByRole(String role) {
		logger.info("Inside DAO getUsersByRole method ");
		List<UserEntity> userEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(UserEntity.class);
		criteria.createAlias("userroles", "urole", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("urole.rolecode", role));
		userEntity = criteria.setResultTransformer(
				Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = userEntity != null ? userEntity.size() : 0;
		logger.debug("Inside USER DAO getUsersByRole method : Get All Users By Role :"
				+ size);
		if (size > 0) {
			return (ArrayList<UserEntity>) userEntity;
		}
		throw new RestCustomException(
				HttpStatus.NO_CONTENT,
				applicationConfigProperties
						.getProperty(AppConfig.GETALLUSERSBYROLE_NOADMINUSERSFOUND_ERRORMSG));
	}

	@Transactional
	public void saveorupdateUserDetails(UserEntity userEntity) {
		try {
			logger.info("Inside USER DAO saveorupdateUserDetails method ");
			Set<UserRoleEntity> userRoleEntities = new HashSet<UserRoleEntity>();
			for (UserRoleEntity userRoleEntity : userEntity.getUserroles()) {
				userRoleEntities.add(userRoleEntity);
				userRoleEntity.setUserdetails(userEntity);
			}
			Set<UserBizEntity> userBizEntities = new HashSet<UserBizEntity>();
			for (UserBizEntity userBizEntity : userEntity.getUserbizdetails()) {
				userBizEntities.add(userBizEntity);
				userBizEntity.setUserdetails(userEntity);
			}
			userEntity.setUserroles(userRoleEntities);
			userEntity.setUserbizdetails(userBizEntities);
			sessionFactory.getCurrentSession().saveOrUpdate(userEntity);
			logger.info("Inside DAO saveorupdateUserDetails method : User Details Updated for UserId :"
					+ userEntity.getUserId());
		} catch (RestCustomException e) {
			throw new RestCustomException(
					HttpStatus.BAD_REQUEST,
					applicationConfigProperties
							.getProperty(AppConfig.SAVEORUPDATEUSERDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}

}
