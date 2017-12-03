package com.hawcode.cms.dao;

import java.util.Map;

/**
 * Interface for the CMS DAO - Abstraction layer between the application and the CMS.
 * 
 * @author Benjamin Vega
 * @since 1.0
 */
public interface CMSDataAccessObject {

	void setClassType(Class<?> classType);
	
	/**
	 * Search for the corresponding text of the given ID and the given language
	 * @param id The content ID
	 * @param language The content language
	 * @return The corresponding text given the parameters
	 */
    String findTextByContentId(String id, String language,Class<? extends Enum> enumType);
	
	Map<String, String> getAllTextContents(String language, Class<? extends Enum> enumType);
}
