/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.dbofflinestorage.school_db.AcademicSubjects;
import com.dbofflinestorage.school_db.Academics;
import com.dbofflinestorage.school_db.AcademicsId;
import com.dbofflinestorage.school_db.StudentAcademics;


/**
 * ServiceImpl object for domain model class Academics.
 *
 * @see Academics
 */
@Service("School_DB.AcademicsService")
@Validated
public class AcademicsServiceImpl implements AcademicsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AcademicsServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("School_DB.AcademicSubjectsService")
    private AcademicSubjectsService academicSubjectsService;

    @Lazy
    @Autowired
    @Qualifier("School_DB.StudentAcademicsService")
    private StudentAcademicsService studentAcademicsService;

    @Autowired
    @Qualifier("School_DB.AcademicsDao")
    private WMGenericDao<Academics, AcademicsId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Academics, AcademicsId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
    public Academics create(Academics academics) {
        LOGGER.debug("Creating a new Academics with information: {}", academics);

        Academics academicsCreated = this.wmGenericDao.create(academics);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(academicsCreated);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Academics getById(AcademicsId academicsId) {
        LOGGER.debug("Finding Academics by id: {}", academicsId);
        return this.wmGenericDao.findById(academicsId);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Academics findById(AcademicsId academicsId) {
        LOGGER.debug("Finding Academics by id: {}", academicsId);
        try {
            return this.wmGenericDao.findById(academicsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Academics found with id: {}", academicsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public List<Academics> findByMultipleIds(List<AcademicsId> academicsIds, boolean orderedReturn) {
        LOGGER.debug("Finding Academics by ids: {}", academicsIds);

        return this.wmGenericDao.findByMultipleIds(academicsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "School_DBTransactionManager")
    @Override
    public Academics update(Academics academics) {
        LOGGER.debug("Updating Academics with information: {}", academics);

        this.wmGenericDao.update(academics);
        this.wmGenericDao.refresh(academics);

        return academics;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
    public Academics delete(AcademicsId academicsId) {
        LOGGER.debug("Deleting Academics with id: {}", academicsId);
        Academics deleted = this.wmGenericDao.findById(academicsId);
        if (deleted == null) {
            LOGGER.debug("No Academics found with id: {}", academicsId);
            throw new EntityNotFoundException(String.valueOf(academicsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
    public void delete(Academics academics) {
        LOGGER.debug("Deleting Academics with {}", academics);
        this.wmGenericDao.delete(academics);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<Academics> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Academics");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<Academics> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Academics");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service School_DB for table Academics to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service School_DB for table Academics to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<AcademicSubjects> findAssociatedAcademicSubjectses(String academicYear, Integer standardId, Pageable pageable) {
        LOGGER.debug("Fetching all associated academicSubjectses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("academics.academicYear = '" + academicYear + "'");
        queryBuilder.append(" and ");
        queryBuilder.append("academics.standardId = '" + standardId + "'");

        return academicSubjectsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<StudentAcademics> findAssociatedStudentAcademicses(String academicYear, Integer standardId, Pageable pageable) {
        LOGGER.debug("Fetching all associated studentAcademicses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("academics.academicYear = '" + academicYear + "'");
        queryBuilder.append(" and ");
        queryBuilder.append("academics.standardId = '" + standardId + "'");

        return studentAcademicsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service AcademicSubjectsService instance
     */
    protected void setAcademicSubjectsService(AcademicSubjectsService service) {
        this.academicSubjectsService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service StudentAcademicsService instance
     */
    protected void setStudentAcademicsService(StudentAcademicsService service) {
        this.studentAcademicsService = service;
    }

}