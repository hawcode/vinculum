/*
 * ************************************************************************
 *
 *  Copyright (c) 2018. Hawcode - Diseño Atómico SL
 *
 *  This file is subject to the terms and conditions defined in
 *  file 'LICENSE.txt', which is part of this source code package.
 *
 * ************************************************************************
 */

package com.hawcode.vinculum.service;

import com.hawcode.vinculum.dao.CMSDataAccessObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

/**
 * Service to retrieve the information from the CMS.
 * <p>Makes use of the DAO as abstraction layer.
 */
@Service("cmsService")
@Transactional("transactionManagerCms")
public class CMSService {

	@Autowired
	private CMSDataAccessObject dao;

	public void setClassType(Class<?> type){
		this.dao.setClassType(type);
	}

	public String findTextByContentId(String id, String language) {
        return dao.findTextByContentId(id, language);
	}

	public Map<String, String> getAllTextContents(String language){
		return dao.getAllTextContents(language);
	}

}
