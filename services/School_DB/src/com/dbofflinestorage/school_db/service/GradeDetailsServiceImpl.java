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

import com.dbofflinestorage.school_db.GradeDetails;
import com.dbofflinestorage.school_db.Results;


/**
 * ServiceImpl object for domain model class GradeDetails.
 *
 * @see GradeDetails
 */
@Service("School_DB.GradeDetailsService")
@Validated
public class GradeDetailsServiceImpl implements GradeDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GradeDetailsServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("School_DB.ResultsService")
    private ResultsService resultsService;

    @Autowired
    @Qualifier("School_DB.GradeDetailsDao")
    private WMGenericDao<GradeDetails, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<GradeDetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
    public GradeDetails create(GradeDetails gradeDetails) {
        LOGGER.debug("Creating a new GradeDetails with information: {}", gradeDetails);

        GradeDetails gradeDetailsCreated = this.wmGenericDao.create(gradeDetails);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(gradeDetailsCreated);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public GradeDetails getById(Integer gradedetailsId) {
        LOGGER.debug("Finding GradeDetails by id: {}", gradedetailsId);
        return this.wmGenericDao.findById(gradedetailsId);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public GradeDetails findById(Integer gradedetailsId) {
        LOGGER.debug("Finding GradeDetails by id: {}", gradedetailsId);
        try {
            return this.wmGenericDao.findById(gradedetailsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No GradeDetails found with id: {}", gradedetailsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public List<GradeDetails> findByMultipleIds(List<Integer> gradedetailsIds, boolean orderedReturn) {
        LOGGER.debug("Finding GradeDetails by ids: {}", gradedetailsIds);

        return this.wmGenericDao.findByMultipleIds(gradedetailsIds, orderedReturn);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public GradeDetails getByGrade(String grade) {
        Map<String, Object> gradeMap = new HashMap<>();
        gradeMap.put("grade", grade);

        LOGGER.debug("Finding GradeDetails by unique keys: {}", gradeMap);
        return this.wmGenericDao.findByUniqueKey(gradeMap);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "School_DBTransactionManager")
    @Override
    public GradeDetails update(GradeDetails gradeDetails) {
        LOGGER.debug("Updating GradeDetails with information: {}", gradeDetails);

        this.wmGenericDao.update(gradeDetails);
        this.wmGenericDao.refresh(gradeDetails);

        return gradeDetails;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
    public GradeDetails delete(Integer gradedetailsId) {
        LOGGER.debug("Deleting GradeDetails with id: {}", gradedetailsId);
        GradeDetails deleted = this.wmGenericDao.findById(gradedetailsId);
        if (deleted == null) {
            LOGGER.debug("No GradeDetails found with id: {}", gradedetailsId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), GradeDetails.class.getSimpleName(), gradedetailsId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "School_DBTransactionManager")
    @Override
    public void delete(GradeDetails gradeDetails) {
        LOGGER.debug("Deleting GradeDetails with {}", gradeDetails);
        this.wmGenericDao.delete(gradeDetails);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<GradeDetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all GradeDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager")
    @Override
    public Page<GradeDetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all GradeDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service School_DB for table GradeDetails to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "School_DBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service School_DB for table GradeDetails to {} format", options.getExportType());
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
    public Page<Results> findAssociatedResultses(Integer gradeId, Pageable pageable) {
        LOGGER.debug("Fetching all associated resultses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("gradeDetails.gradeId = '" + gradeId + "'");

        return resultsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service ResultsService instance
     */
    protected void setResultsService(ResultsService service) {
        this.resultsService = service;
    }

}