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

import com.hawcode.vinculum.service.CMSService;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This class contains the all the resources needed for rendering a view
 */
public class ContentManagedData {

	public Map<String, String> map = new HashMap<String, String>();

	/**
	 * Constructor for the ContentManagedData class. It retrieves all the resources of a Table.
	 * The table that is going to be queried is specified in the service. The service is configured before calling the
	 * contructor and passed as an argument.
	 * @param EntityType The CMS Service.
	 * @param language The language in which the text will be displayed.
	 */
	ContentManagedData(CMSService cmsService, Class<?> EntityType, String language) {
        cmsService.setClassType(EntityType);
	    map = cmsService.getAllTextContents(language);
	}

    public String getMappedContent(String id) {
        return map.get(id);
    }
}