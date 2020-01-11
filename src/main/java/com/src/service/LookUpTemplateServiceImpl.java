package com.src.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.src.entity.ReferenceLookUpTemplateEntity;

@Service("referenceLookUpManager")
@Transactional(rollbackFor = { Exception.class })
public class LookUpTemplateServiceImpl extends AbstractServiceManager implements LookUpTemplateService {

	public ReferenceLookUpTemplateEntity getLookupTemplateEntityByShortkey(String shortkey) {
		return lookUpTemplateDAO.getLookupTemplateEntityByShortkey(shortkey);
	}

}
