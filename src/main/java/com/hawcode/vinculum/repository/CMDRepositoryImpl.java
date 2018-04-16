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

import com.hawcode.vinculum.model.FilterableByColumn;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CMDRepositoryImpl implements CMDRepository {

	private Class<FilterableByColumn> classType;

	@PersistenceContext
	private EntityManager entityManager;

	public Map<String, String> getAllTextContents(String column){
        List<FilterableByColumn> list = getFilterableByColumnList();

        return list.stream().collect(
                Collectors.toMap(FilterableByColumn::getCId, c -> c.getColumn(column))
        );
	}

    private List<FilterableByColumn> getFilterableByColumnList() {
        CriteriaBuilder builder = entityManager.unwrap(Session.class).getCriteriaBuilder();
        CriteriaQuery<FilterableByColumn> query = builder.createQuery(classType);
        Root<FilterableByColumn> root = query.from(classType);
        query.select(root);
        Query<FilterableByColumn> q = entityManager.unwrap(Session.class).createQuery(query);

        return q.getResultList();
    }

    public void setClassType(Class<?> classType) {
		this.classType = (Class<FilterableByColumn>) classType;
	}
}
