/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.HashMap;
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

import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.dbofflinestorage.school_db.AcademicTestSubjects;
import com.dbofflinestorage.school_db.TestDetails;


/**
 * ServiceImpl object for domain model class TestDetails.
 *
 * @see TestDetails
 */
@Service("School_DB.TestDetailsService")
@Validated
public class TestDetailsServiceImpl implements TestDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestDetailsServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("School_DB.AcademicTestSubjectsService")
    private AcademicTestSubjectsService academicTestSubjectsService;

    @Autowired
    @Qualifier("School_DB.TestDetailsDao")
    private WMGenericDao<TestDetails, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TestDetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
    public TestDetails create(TestDetails testDetails) {
        LOGGER.debug("Creating a new TestDetails with information: {}", testDetails);

        TestDetails testDetailsCreated = this.wmGenericDao.create(testDetails);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(testDetailsCreated);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public TestDetails getById(Integer testdetailsId) {
        LOGGER.debug("Finding TestDetails by id: {}", testdetailsId);
        return this.wmGenericDao.findById(testdetailsId);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public TestDetails findById(Integer testdetailsId) {
        LOGGER.debug("Finding TestDetails by id: {}", testdetailsId);
        try {
            return this.wmGenericDao.findById(testdetailsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No TestDetails found with id: {}", testdetailsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public List<TestDetails> findByMultipleIds(List<Integer> testdetailsIds, boolean orderedReturn) {
        LOGGER.debug("Finding TestDetails by ids: {}", testdetailsIds);

        return this.wmGenericDao.findByMultipleIds(testdetailsIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public TestDetails getByTestName(String testName) {
        Map<String, Object> testNameMap = new HashMap<>();
        testNameMap.put("testName", testName);

        LOGGER.debug("Finding TestDetails by unique keys: {}", testNameMap);
        return this.wmGenericDao.findByUniqueKey(testNameMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "School_DBTransactionManager")
    @Override
    public TestDetails update(TestDetails testDetails) {
        LOGGER.debug("Updating TestDetails with information: {}", testDetails);

        this.wmGenericDao.update(testDetails);
        this.wmGenericDao.refresh(testDetails);

        return testDetails;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
    public TestDetails delete(Integer testdetailsId) {
        LOGGER.debug("Deleting TestDetails with id: {}", testdetailsId);
        TestDetails deleted = this.wmGenericDao.findById(testdetailsId);
        if (deleted == null) {
            LOGGER.debug("No TestDetails found with id: {}", testdetailsId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), TestDetails.class.getSimpleName(), testdetailsId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
    public void delete(TestDetails testDetails) {
        LOGGER.debug("Deleting TestDetails with {}", testDetails);
        this.wmGenericDao.delete(testDetails);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<TestDetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TestDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<TestDetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TestDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service School_DB for table TestDetails to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service School_DB for table TestDetails to {} format", options.getExportType());
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
    public Page<AcademicTestSubjects> findAssociatedAcademicTestSubjectses(Integer testId, Pageable pageable) {
        LOGGER.debug("Fetching all associated academicTestSubjectses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("testDetails.testId = '" + testId + "'");

        return academicTestSubjectsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service AcademicTestSubjectsService instance
     */
    protected void setAcademicTestSubjectsService(AcademicTestSubjectsService service) {
        this.academicTestSubjectsService = service;
    }

}