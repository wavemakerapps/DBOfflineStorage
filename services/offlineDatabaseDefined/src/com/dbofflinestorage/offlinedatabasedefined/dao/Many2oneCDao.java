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

import com.dbofflinestorage.offlinedatabasedefined.Many2oneC;

/**
 * Specifies methods used to obtain and modify Many2oneC related information
 * which is stored in the database.
 */
@Repository("offlineDatabaseDefined.Many2oneCDao")
public class Many2oneCDao extends WMGenericDaoImpl<Many2oneC, Integer> {

    @Autowired
    @Qualifier("offlineDatabaseDefinedTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}