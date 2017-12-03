package com.hawcode.cms.utils;

/**
 * @since 1.0
 */
public interface MultiLanguage {
	
	/**
     * Get the corresponding text according to the language.
     * @param language The language that is required.
     * @return The text in the selected language.
     */
	String getText(Enum<?> language);

	String getCid();
}
