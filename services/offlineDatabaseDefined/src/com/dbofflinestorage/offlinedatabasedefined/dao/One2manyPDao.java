/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlinedatabasedefined.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;
import com.wavemaker.runtime.data.dao.query.types.wmql.WMQLTypeHelper;

import com.dbofflinestorage.offlinedatabasedefined.One2manyP;

/**
 * Specifies methods used to obtain and modify One2manyP related information
 * which is stored in the database.
 */
@Repository("offlineDatabaseDefined.One2manyPDao")
public class One2manyPDao extends WMGenericDaoImpl<One2manyP, String> {

    @Autowired
    @Qualifier("offlineDatabaseDefinedTemplate")
    private HibernateTemplate template;

    @Autowired
    @Qualifier("offlineDatabaseDefinedWMQLTypeHelper")
    private WMQLTypeHelper wmqlTypeHelper;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }

    @Override
    public WMQLTypeHelper getWMQLTypeHelper() {
        return this.wmqlTypeHelper;
    }

}