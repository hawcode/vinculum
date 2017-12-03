package com.hawcode.cms.service;

import java.util.Map;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hawcode.cms.dao.CMSDataAccessObject;

/**
 * Service to retrieve the information from the CMS.
 * <p>Makes use of the DAO as abstraction layer.
 * 
 * @author Benjamin Vega
 * @since 1.0
 */
@Entity
@Service("cmsService")
@Transactional("transactionManagerCms")
public class CMSService {

	/**
	 * DAO layer object
	 */
	@Autowired
	private CMSDataAccessObject dao;

	public void setClassType(Class<?> type){
		this.dao.setClassType(type);
	}

	/**
	 * Return the text given the content ID
	 * @param id The content ID
	 * @param language The desired language
	 * @return The corresponding text
	 */
	public String findTextByContentId(String id, String language, Class<? extends Enum> enumType) {
        return dao.findTextByContentId(id, language, enumType);
	}

	public Map<String, String> getAllTextContents(String language, Class<? extends Enum> enumType){
		return dao.getAllTextContents(language, enumType);
	}
}
