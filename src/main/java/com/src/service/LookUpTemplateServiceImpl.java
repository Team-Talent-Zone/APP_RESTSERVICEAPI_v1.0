package com.src.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.LookUpTemplateEntity;

@Service("referenceLookUpManager")
@Transactional(rollbackFor = { Exception.class })
public class LookUpTemplateServiceImpl extends AbstractServiceManager implements LookUpTemplateService {

	public LookUpTemplateEntity getLookupTemplateByName(String name) {
		return lookUpTemplateDAO.getLookupTemplateByName(name);
	}

}
