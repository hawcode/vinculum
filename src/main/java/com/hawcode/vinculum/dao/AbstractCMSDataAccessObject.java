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

package com.hawcode.vinculum.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Abstract class for the CMS DAO - Abstraction layer between the application and the CMS.
 */
public abstract class AbstractCMSDataAccessObject {

	private final SessionFactory sessionFactoryCms;

    @Autowired
    public AbstractCMSDataAccessObject(@Qualifier("sessionFactoryCms") SessionFactory sessionFactoryCms) {
        this.sessionFactoryCms = sessionFactoryCms;
    }

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