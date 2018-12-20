/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlineclassicdb.service;

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

import com.dbofflinestorage.offlineclassicdb.AssignedType;


/**
 * ServiceImpl object for domain model class AssignedType.
 *
 * @see AssignedType
 */
@Service("OfflineClassicDB.AssignedTypeService")
@Validated
public class AssignedTypeServiceImpl implements AssignedTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssignedTypeServiceImpl.class);


    @Autowired
    @Qualifier("OfflineClassicDB.AssignedTypeDao")
    private WMGenericDao<AssignedType, Double> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<AssignedType, Double> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "OfflineClassicDBTransactionManager")
    @Override
    public AssignedType create(AssignedType assignedType) {
        LOGGER.debug("Creating a new AssignedType with information: {}", assignedType);

        AssignedType assignedTypeCreated = this.wmGenericDao.create(assignedType);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(assignedTypeCreated);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public AssignedType getById(Double assignedtypeId) {
        LOGGER.debug("Finding AssignedType by id: {}", assignedtypeId);
        return this.wmGenericDao.findById(assignedtypeId);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public AssignedType findById(Double assignedtypeId) {
        LOGGER.debug("Finding AssignedType by id: {}", assignedtypeId);
        try {
            return this.wmGenericDao.findById(assignedtypeId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No AssignedType found with id: {}", assignedtypeId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public List<AssignedType> findByMultipleIds(List<Double> assignedtypeIds, boolean orderedReturn) {
        LOGGER.debug("Finding AssignedTypes by ids: {}", assignedtypeIds);

        return this.wmGenericDao.findByMultipleIds(assignedtypeIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "OfflineClassicDBTransactionManager")
    @Override
    public AssignedType update(AssignedType assignedType) {
        LOGGER.debug("Updating AssignedType with information: {}", assignedType);

        this.wmGenericDao.update(assignedType);
        this.wmGenericDao.refresh(assignedType);

        return assignedType;
    }

    @Transactional(value = "OfflineClassicDBTransactionManager")
    @Override
    public AssignedType delete(Double assignedtypeId) {
        LOGGER.debug("Deleting AssignedType with id: {}", assignedtypeId);
        AssignedType deleted = this.wmGenericDao.findById(assignedtypeId);
        if (deleted == null) {
            LOGGER.debug("No AssignedType found with id: {}", assignedtypeId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), AssignedType.class.getSimpleName(), assignedtypeId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "OfflineClassicDBTransactionManager")
    @Override
    public void delete(AssignedType assignedType) {
        LOGGER.debug("Deleting AssignedType with {}", assignedType);
        this.wmGenericDao.delete(assignedType);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public Page<AssignedType> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all AssignedTypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public Page<AssignedType> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all AssignedTypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service OfflineClassicDB for table AssignedType to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service OfflineClassicDB for table AssignedType to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}