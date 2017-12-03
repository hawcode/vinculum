package com.hawcode.cms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Abstract class for the CMS DAO - Abstraction layer between the application and the CMS.
 * 
 * @author Benjamin Vega
 * @since 1.0
 */
public abstract class AbstractCMSDataAccessObject {

	@Autowired
	@Qualifier("sessionFactoryCms")
    private SessionFactory sessionFactoryCms;

	/**
	 * Get session method.
	 * @return The current session.
	 */
    Session getSession() {
        return sessionFactoryCms.getCurrentSession();
    }
 
    /**
     * Persist method.
     * @param entity Persistence target.
     */
    public void persist(Object entity) {
        getSession().persist(entity);
    }
 
    /**
     * Delete method.
     * @param entity Deletion target.
     */
    public void delete(Object entity) {
        getSession().delete(entity);
    }
}