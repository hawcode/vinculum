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

package com.hawcode.vinculum.service;

import com.hawcode.vinculum.model.ContentManagedData;
import com.hawcode.vinculum.repository.CMDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CMDService {

    @Autowired
    private CMDRepository cmdRepository;

    private Map<String, String> getAllByColumn(String column) {
	    return cmdRepository.getAllTextContents(column);
    }

    private void setClassType(Class<?> type){
        this.cmdRepository.setClassType(type);
    }

    public ContentManagedData getCMD(Class<?> entity, String column){
        setClassType(entity);
        return new ContentManagedData(getAllByColumn(column));
    }
}

