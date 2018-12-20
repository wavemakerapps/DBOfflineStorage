/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlinedatabasedefined.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.dbofflinestorage.offlinedatabasedefined.One2oneC;


/**
 * ServiceImpl object for domain model class One2oneC.
 *
 * @see One2oneC
 */
@Service("offlineDatabaseDefined.One2oneCService")
@Validated
public class One2oneCServiceImpl implements One2oneCService {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneCServiceImpl.class);


    @Autowired
    @Qualifier("offlineDatabaseDefined.One2oneCDao")
    private WMGenericDao<One2oneC, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<One2oneC, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public One2oneC create(One2oneC one2oneC) {
        LOGGER.debug("Creating a new One2oneC with information: {}", one2oneC);

        One2oneC one2oneCCreated = this.wmGenericDao.create(one2oneC);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(one2oneCCreated);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public One2oneC getById(Integer one2onecId) {
        LOGGER.debug("Finding One2oneC by id: {}", one2onecId);
        return this.wmGenericDao.findById(one2onecId);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public One2oneC findById(Integer one2onecId) {
        LOGGER.debug("Finding One2oneC by id: {}", one2onecId);
        try {
            return this.wmGenericDao.findById(one2onecId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No One2oneC found with id: {}", one2onecId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public List<One2oneC> findByMultipleIds(List<Integer> one2onecIds, boolean orderedReturn) {
        LOGGER.debug("Finding One2oneCs by ids: {}", one2onecIds);

        return this.wmGenericDao.findByMultipleIds(one2onecIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public One2oneC update(One2oneC one2oneC) {
        LOGGER.debug("Updating One2oneC with information: {}", one2oneC);

        this.wmGenericDao.update(one2oneC);
        this.wmGenericDao.refresh(one2oneC);

        return one2oneC;
    }

    @Transactional(value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public One2oneC delete(Integer one2onecId) {
        LOGGER.debug("Deleting One2oneC with id: {}", one2onecId);
        One2oneC deleted = this.wmGenericDao.findById(one2onecId);
        if (deleted == null) {
            LOGGER.debug("No One2oneC found with id: {}", one2onecId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), One2oneC.class.getSimpleName(), one2onecId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public void delete(One2oneC one2oneC) {
        LOGGER.debug("Deleting One2oneC with {}", one2oneC);
        this.wmGenericDao.delete(one2oneC);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public Page<One2oneC> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all One2oneCs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public Page<One2oneC> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all One2oneCs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service offlineDatabaseDefined for table One2oneC to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service offlineDatabaseDefined for table One2oneC to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}