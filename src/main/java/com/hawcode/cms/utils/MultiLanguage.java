package com.hawcode.cms.utils;

/**
 *
 * Interface that all the Entities have to implement for being able to be used by the DAO.
 *  @author Benjamin Vega
 */
public interface MultiLanguage {
	
	/**
     * Get the corresponding text according to the language.
     * @param language The language that is required.
     * @return The text in the selected language.
     */
	String getText(Enum<?> language);

	/**
	 * Get the corresponding content ID value of the Entity that implements the Interface.
	 * @return The content ID value of the Entity.
	 */
	String getCid();
}
