package com.src.dao;

import com.src.entity.ReferenceLookUpTemplateEntity;

public interface LookUpTemplateDAO {

	public ReferenceLookUpTemplateEntity getLookupTemplateEntityByShortkey(String shortkey);

}