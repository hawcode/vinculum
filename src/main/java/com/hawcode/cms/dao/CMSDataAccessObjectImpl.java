package com.hawcode.cms.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hawcode.cms.utils.Selectable;

/**
 * Implementation class for the CMS DAO - Abstraction layer between the application and the CMS.
 * 
 * @author Benjamin Vega
 */
@Repository("cmsDao")
public class CMSDataAccessObjectImpl extends AbstractCMSDataAccessObject implements CMSDataAccessObject{

	private Class<Selectable> classType;

	private Class<? extends Enum> enumType;

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
