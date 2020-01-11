package com.src.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.src.constant.CustomMsgConfig;
import com.src.entity.ReferenceLookUpTemplateEntity;
import com.src.exception.RestCustomException;

@Repository
@Transactional(rollbackFor = { Exception.class })
public class LookUpTemplateDAOImpl extends AbstractDAOManager implements LookUpTemplateDAO {

	final Logger logger = LoggerFactory.getLogger(LookUpTemplateDAOImpl.class);

	@Transactional
	public ReferenceLookUpTemplateEntity getLookupTemplateEntityByShortkey(String shortkey) {
		ReferenceLookUpTemplateEntity lookUpTemplateEntity = null;
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ReferenceLookUpTemplateEntity.class);
		criteria.add(Restrictions.eq("shortkey", shortkey));
		lookUpTemplateEntity = (ReferenceLookUpTemplateEntity) criteria.uniqueResult();
		if (lookUpTemplateEntity != null) {
			return lookUpTemplateEntity;
		}
		throw new RestCustomException(HttpStatus.NO_CONTENT,
				applicationConfigProperties.getProperty(CustomMsgConfig.LOOKUPTEMPALTE_NAME_ERRORMSG) + " for name :"
						+ shortkey);

	}

}
