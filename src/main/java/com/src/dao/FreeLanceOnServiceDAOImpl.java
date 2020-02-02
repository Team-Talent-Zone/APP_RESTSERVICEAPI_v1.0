package com.src.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.AppConfig;
import com.src.constant.NewServiceConstant;
import com.src.entity.FreeLanceOnServiceEntity;
import com.src.entity.FreeLanceStarReviewFBEntity;
import com.src.exception.RestCustomException;

/**
 * The <code> FreeLanceOnServiceDAOImpl </code> class handles data access
 * operation for <code>Free Lance On Service</code>.
 * 
 * @author Shanoor
 *
 */
@Repository
@Transactional(rollbackFor = { Exception.class })
public class FreeLanceOnServiceDAOImpl extends AbstractDAOManager implements FreeLanceOnServiceDAO {
	final Logger LOGGER = LoggerFactory.getLogger(FreeLanceOnServiceDAOImpl.class);

	/**
	 * To save the freelance on Service.
	 */
	@Transactional
	public FreeLanceOnServiceEntity saveFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVE_FREELANCE_ONSERVICE);
		int userServiceDetailsID = (Integer) sessionFactory.getCurrentSession().save(freeLanceOnServiceEntity);
		LOGGER.debug(NewServiceConstant.CONFIRM_SAVE_FREELANCE_ONSERVICE + userServiceDetailsID);
		if (userServiceDetailsID > 0) {
			return freeLanceOnServiceEntity;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(AppConfig.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

	/**
	 * To save or Update the New Service Details.
	 */
	@Transactional
	public void saveOrUpdateFreeLanceOnService(FreeLanceOnServiceEntity freeLanceOnServiceEntity) {
		try {
			LOGGER.info(NewServiceConstant.INSIDE_SAVEORUPDATE_FREELANCE_ON_SERVICE);
			sessionFactory.getCurrentSession().saveOrUpdate(freeLanceOnServiceEntity);
			LOGGER.info(NewServiceConstant.CONFIRMED_SAVEORUPDATE_FREELANCE_ON_SERVICE
					+ freeLanceOnServiceEntity.getJobId());
		} catch (RestCustomException e) {
			throw new RestCustomException(HttpStatus.BAD_REQUEST, applicationConfigProperties
					.getProperty(AppConfig.SAVEORUPDATESERVICEDETAILS_UNABLETOUPDATE_ERRORMSG));
		}
	}

	@Override
	public FreeLanceStarReviewFBEntity saveFreeLanceStarReviewFB(FreeLanceStarReviewFBEntity freeLanceStarReviewFB) {
		LOGGER.info(NewServiceConstant.INSIDE_SAVE_FREELANCE_STAR_REVIEW_FB);
		int freeLanceStarReviewFBID = (Integer) sessionFactory.getCurrentSession().save(freeLanceStarReviewFB);
		LOGGER.debug(NewServiceConstant.CONFIRM_SAVE_FREELANCE_STAR_REVIEW_FB + freeLanceStarReviewFBID);
		if (freeLanceStarReviewFBID > 0) {
			return freeLanceStarReviewFB;
		}
		throw new RestCustomException(HttpStatus.BAD_REQUEST,
				applicationConfigProperties.getProperty(AppConfig.NEWSERVICE_UNABLE_TO_SAVE_ERRORMSG));
	}

}