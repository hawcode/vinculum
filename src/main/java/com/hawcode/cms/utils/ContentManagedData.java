package com.hawcode.cms.utils;

import com.hawcode.cms.service.CMSService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This class contains the all the resources needed for rendering a view
 * 
 * @author Benjamin Vega
 */
public class ContentManagedData {


	private Map<String, String> map = new HashMap<String, String>();

	/**
	 * Constructor for the ContentManagedData class. It retrieves all the resources of a Table.
	 * The table that is going to be queried is specified in the service. The service is configured before calling the
	 * contructor and passed as an argument.
	 * @param EntityType The CMS Service.
	 * @param language The language in which the text will be displayed.
	 */
	public ContentManagedData(CMSService cmsService, Class<?> EntityType, String language) {
        cmsService.setClassType(EntityType);
	    map = cmsService.getAllTextContents(language);
	}

    public String getMappedContent(String id) {
        return map.get(id);
    }
}