package com.hawcode.cms.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hawcode.cms.utils.MultiLanguage;

/**
 * Implementation class for the CMS DAO - Abstraction layer between the application and the CMS.
 * 
 * @author Benjamin Vega
 */
@Repository("cmsDao")
public class CMSDataAccessObjectImpl extends AbstractCMSDataAccessObject implements CMSDataAccessObject{

	private Class<MultiLanguage> classType;

	private Class<? extends Enum> enumType;

	public Map<String, String> getAllTextContents(String language){
		Map<String, String> map = new HashMap<String, String>();
		Enum<?> lng = Enum.valueOf(enumType, language);
		Criteria criteria = getSession().createCriteria(classType.getName());
		List<Class<MultiLanguage>>list = criteria.list();
		for (Object cid : list) {
			map.put(classType.cast(cid).getCid() ,classType.cast(cid).getText(lng));
		}
		return map;
	}

	public String findTextByContentId(String id, String language) {
		Criteria criteria = getSession().createCriteria(classType.getName() );
		criteria.add(Restrictions.eq("cnt_id", id));
		Object o = criteria.uniqueResult();
		Enum.valueOf(enumType, language);
		Enum<?> lng = Enum.valueOf(enumType, language);
		if(o != null) {
			return classType.cast(o).getText(lng);
		} else {
			return "Error trying to access DB using " + classType.getName() + " as a model";
		}
	}
	
	public void setClassType(Class<?> classType) {
		this.classType = (Class<MultiLanguage>) classType;
	}

	public void setEnumType(Class<? extends Enum> enumType) {
		this.enumType = enumType;
	}
}
