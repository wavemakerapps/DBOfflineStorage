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

import com.dbofflinestorage.offlineclassicdb.AllTypes;


/**
 * ServiceImpl object for domain model class AllTypes.
 *
 * @see AllTypes
 */
@Service("OfflineClassicDB.AllTypesService")
@Validated
public class AllTypesServiceImpl implements AllTypesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllTypesServiceImpl.class);


    @Autowired
    @Qualifier("OfflineClassicDB.AllTypesDao")
    private WMGenericDao<AllTypes, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<AllTypes, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "OfflineClassicDBTransactionManager")
    @Override
    public AllTypes create(AllTypes allTypes) {
        LOGGER.debug("Creating a new AllTypes with information: {}", allTypes);

        AllTypes allTypesCreated = this.wmGenericDao.create(allTypes);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(allTypesCreated);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public AllTypes getById(Integer alltypesId) {
        LOGGER.debug("Finding AllTypes by id: {}", alltypesId);
        return this.wmGenericDao.findById(alltypesId);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public AllTypes findById(Integer alltypesId) {
        LOGGER.debug("Finding AllTypes by id: {}", alltypesId);
        try {
            return this.wmGenericDao.findById(alltypesId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No AllTypes found with id: {}", alltypesId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public List<AllTypes> findByMultipleIds(List<Integer> alltypesIds, boolean orderedReturn) {
        LOGGER.debug("Finding AllTypes by ids: {}", alltypesIds);

        return this.wmGenericDao.findByMultipleIds(alltypesIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "OfflineClassicDBTransactionManager")
    @Override
    public AllTypes update(AllTypes allTypes) {
        LOGGER.debug("Updating AllTypes with information: {}", allTypes);

        this.wmGenericDao.update(allTypes);
        this.wmGenericDao.refresh(allTypes);

        return allTypes;
    }

    @Transactional(value = "OfflineClassicDBTransactionManager")
    @Override
    public AllTypes delete(Integer alltypesId) {
        LOGGER.debug("Deleting AllTypes with id: {}", alltypesId);
        AllTypes deleted = this.wmGenericDao.findById(alltypesId);
        if (deleted == null) {
            LOGGER.debug("No AllTypes found with id: {}", alltypesId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), AllTypes.class.getSimpleName(), alltypesId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "OfflineClassicDBTransactionManager")
    @Override
    public void delete(AllTypes allTypes) {
        LOGGER.debug("Deleting AllTypes with {}", allTypes);
        this.wmGenericDao.delete(allTypes);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public Page<AllTypes> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all AllTypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public Page<AllTypes> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all AllTypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service OfflineClassicDB for table AllTypes to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service OfflineClassicDB for table AllTypes to {} format", options.getExportType());
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