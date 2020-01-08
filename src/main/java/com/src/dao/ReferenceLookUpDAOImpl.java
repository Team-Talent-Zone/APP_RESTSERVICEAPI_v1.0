package com.src.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.AppConfig;
import com.src.entity.ReferenceLookUpEntity;
import com.src.exception.RestCustomException;

@Repository
@Transactional(rollbackFor = { Exception.class })
public class ReferenceLookUpDAOImpl extends AbstractDAOManager implements ReferenceLookUpDAO {

	final Logger logger = LoggerFactory.getLogger(ReferenceLookUpDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<ReferenceLookUpEntity> getReferenceLookupByKey(String key) {

		logger.info("Inside REFERENCE LOOKUP DAO getReferenceLookupByKey method");
		List<ReferenceLookUpEntity> referenceLookUpEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ReferenceLookUpEntity.class);
		criteria.add(Restrictions.eq("key", key));
		referenceLookUpEntity = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = referenceLookUpEntity != null ? referenceLookUpEntity.size() : 0;
		logger.debug(
				"Inside REFERENCE LOOKUP DAO getReferenceLookupByKey method : Get All Reference Look Up Data By Key :"
						+ key + " Size is: " + size);
		if (size > 0) {
			return (ArrayList<ReferenceLookUpEntity>) referenceLookUpEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(AppConfig.REFERNCELOOKUP_KEY_ERRORMSG) + " for key :" + key);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<ReferenceLookUpEntity> getAllReferenceLookupData() {
		logger.info("Inside REFERENCE LOOKUP DAO getAllReferenceLookupData method");
		List<ReferenceLookUpEntity> lookUpEntities = this.sessionFactory.getCurrentSession()
				.createCriteria(ReferenceLookUpEntity.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		int size = lookUpEntities != null ? lookUpEntities.size() : 0;
		logger.debug(
				"Inside REFERENCE LOOKUP DAO  getAllReferenceLookupData method : Get All Reference Look Up :" + size);
		if (size > 0) {
			return (ArrayList<ReferenceLookUpEntity>) lookUpEntities;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(AppConfig.REFERNCELOOKUP_ERRORMSG));
	}

	@Transactional
	public String getReferenceLookupByShortKey(String shortkey) {
		ReferenceLookUpEntity referenceLookUpEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ReferenceLookUpEntity.class);
		criteria.add(Restrictions.eq("shortkey", shortkey));
		referenceLookUpEntity = (ReferenceLookUpEntity) criteria.uniqueResult();
		if (referenceLookUpEntity != null) {
			return referenceLookUpEntity.getCode().toString();
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(AppConfig.REFERNCELOOKUP_KEY_ERRORMSG) + " for short key :"
						+ shortkey);
		
	}

}
