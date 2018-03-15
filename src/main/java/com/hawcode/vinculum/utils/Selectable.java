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

package com.hawcode.vinculum.utils;

/**
 * Interface that all the Entities have to implement for being able to be used by the DAO.
 */
public interface Selectable {
	
	/**
     * Get the corresponding text according to the language.
     * @param language The language that is required.
     * @return The text in the selected language.
     */
	String getText(String language);

	/**
	 * Get the corresponding content ID value of the Entity that implements the Interface.
	 * @return The content ID value of the Entity.
	 */
	String getCid();
}
