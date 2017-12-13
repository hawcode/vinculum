package com.hawcode.cms.utils;

import com.hawcode.cms.service.CMSService;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This class contains the all the resources needed for rendering a view
 * 
 * @author Benjamin Vega
 */
public class ContentManagedData {


	public Map<String, String> map = new HashMap<String, String>();


	/**
	 * Constructor for the ContentManagedData class. It retrieves all the resources of a Table.
	 * The table that is going to be queried is specified in the service. The service is configured before calling the
	 * contructor and passed as an argument.
	 * @param cmsService The CMS Service.
	 * @param language The language in which the text will be displayed.
	 */
	public ContentManagedData(CMSService cmsService, String language) {
		map = cmsService.getAllTextContents(language);
	}

	
}