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

package com.hawcode.vinculum.dao;

import com.hawcode.vinculum.utils.Selectable;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation class for the CMS DAO - Abstraction layer between the application and the CMS.
 */
@Repository("cmsDao")
public class CMSDataAccessObjectImpl extends AbstractCMSDataAccessObject implements CMSDataAccessObject{

	private Class<Selectable> classType;

	private Class<? extends Enum> enumType;

	public CMSDataAccessObjectImpl(SessionFactory sessionFactoryCms) {
		super(sessionFactoryCms);
	}

	public Map<String, String> getAllTextContents(String language){
		Map<String, String> map = new HashMap<String, String>();
		Criteria criteria = getSession().createCriteria(classType.getName());
		List<Class<Selectable>>list = criteria.list();
		for (Object cid : list) {
			map.put(classType.cast(cid).getCid() ,classType.cast(cid).getText(language));
		}
		return map;
	}

	public String findTextByContentId(String id, String language) {
		Criteria criteria = getSession().createCriteria(classType.getName() );
		criteria.add(Restrictions.eq("cnt_id", id));
		Object o = criteria.uniqueResult();
		if(o != null) {
			return classType.cast(o).getText(language);
		} else {
			return "Error trying to access DB using " + classType.getName() + " as a model";
		}
	}
	
	public void setClassType(Class<?> classType) {
		this.classType = (Class<Selectable>) classType;
	}
}
