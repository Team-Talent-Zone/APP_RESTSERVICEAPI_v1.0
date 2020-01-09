package com.src.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.AppConfig;
import com.src.entity.LookUpTemplateEntity;
import com.src.exception.RestCustomException;

@Repository
@Transactional(rollbackFor = { Exception.class })
public class LookUpTemplateDAOImpl extends AbstractDAOManager implements LookUpTemplateDAO {

	final Logger logger = LoggerFactory.getLogger(LookUpTemplateDAOImpl.class);

	@Transactional
	public LookUpTemplateEntity getLookupTemplateByName(String name) {
		LookUpTemplateEntity lookUpTemplateEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(LookUpTemplateEntity.class);
		criteria.add(Restrictions.eq("name", name));
		lookUpTemplateEntity = (LookUpTemplateEntity) criteria.uniqueResult();
		if (lookUpTemplateEntity != null) {
			return lookUpTemplateEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(AppConfig.LOOKUPTEMPALTE_NAME_ERRORMSG) + " for name :" + name);

	}

}
