package com.src.dao;

import com.src.entity.LookUpTemplateEntity;

public interface LookUpTemplateDAO {

	public LookUpTemplateEntity getLookupTemplateByName(String key);

}