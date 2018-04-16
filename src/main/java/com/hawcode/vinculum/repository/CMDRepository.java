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

package com.hawcode.vinculum.repository;

import java.util.Map;

/**
 * Interface for the CMS DAO - Abstraction layer between the application and the CMS.
 */
public interface CMDRepository {

	/**
	 * Set the class type of the Entity that is going to be used for doing the query.
	 * @param classType Class type of the Entity defined by the developer.
	 */
	void setClassType(Class<?> classType);

	/**
	 * Search for the all corresponding texts of the whole table for a specific language.
	 * @param language The content language.
	 * @return Associative array with texts. The selector is the content ID.
	 */
	Map<String, String> getAllTextContents(String language);
}
