/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.dbofflinestorage.school_db.AcademicSubjects;
import com.dbofflinestorage.school_db.AcademicSubjectsId;

/**
 * Specifies methods used to obtain and modify AcademicSubjects related information
 * which is stored in the database.
 */
@Repository("School_DB.AcademicSubjectsDao")
public class AcademicSubjectsDao extends WMGenericDaoImpl<AcademicSubjects, AcademicSubjectsId> {

    @Autowired
    @Qualifier("School_DBTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}