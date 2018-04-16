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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CMDRepositoryImpl implements CMDRepository {

	private Class<FilterableByColumn> classType;

	@PersistenceContext
	private EntityManager entityManager;

	public Map<String, String> getAllTextContents(String column){
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(classType.getName());
		List<FilterableByColumn>list = criteria.list();
		Map<String, String> map = list.stream().collect(
				Collectors.toMap(FilterableByColumn::getCId, c -> c.getColumn(column))
		);
		return map;
	}

	public void setClassType(Class<?> classType) {
		this.classType = (Class<FilterableByColumn>) classType;
	}
}
