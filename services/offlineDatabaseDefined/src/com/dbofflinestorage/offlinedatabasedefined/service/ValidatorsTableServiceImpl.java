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

import com.dbofflinestorage.offlinedatabasedefined.ValidatorsTable;


/**
 * ServiceImpl object for domain model class ValidatorsTable.
 *
 * @see ValidatorsTable
 */
@Service("offlineDatabaseDefined.ValidatorsTableService")
@Validated
public class ValidatorsTableServiceImpl implements ValidatorsTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorsTableServiceImpl.class);


    @Autowired
    @Qualifier("offlineDatabaseDefined.ValidatorsTableDao")
    private WMGenericDao<ValidatorsTable, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ValidatorsTable, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public ValidatorsTable create(ValidatorsTable validatorsTable) {
        LOGGER.debug("Creating a new ValidatorsTable with information: {}", validatorsTable);

        ValidatorsTable validatorsTableCreated = this.wmGenericDao.create(validatorsTable);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(validatorsTableCreated);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public ValidatorsTable getById(Integer validatorstableId) {
        LOGGER.debug("Finding ValidatorsTable by id: {}", validatorstableId);
        return this.wmGenericDao.findById(validatorstableId);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public ValidatorsTable findById(Integer validatorstableId) {
        LOGGER.debug("Finding ValidatorsTable by id: {}", validatorstableId);
        try {
            return this.wmGenericDao.findById(validatorstableId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No ValidatorsTable found with id: {}", validatorstableId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public List<ValidatorsTable> findByMultipleIds(List<Integer> validatorstableIds, boolean orderedReturn) {
        LOGGER.debug("Finding ValidatorsTables by ids: {}", validatorstableIds);

        return this.wmGenericDao.findByMultipleIds(validatorstableIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public ValidatorsTable update(ValidatorsTable validatorsTable) {
        LOGGER.debug("Updating ValidatorsTable with information: {}", validatorsTable);

        this.wmGenericDao.update(validatorsTable);
        this.wmGenericDao.refresh(validatorsTable);

        return validatorsTable;
    }

    @Transactional(value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public ValidatorsTable delete(Integer validatorstableId) {
        LOGGER.debug("Deleting ValidatorsTable with id: {}", validatorstableId);
        ValidatorsTable deleted = this.wmGenericDao.findById(validatorstableId);
        if (deleted == null) {
            LOGGER.debug("No ValidatorsTable found with id: {}", validatorstableId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), ValidatorsTable.class.getSimpleName(), validatorstableId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public void delete(ValidatorsTable validatorsTable) {
        LOGGER.debug("Deleting ValidatorsTable with {}", validatorsTable);
        this.wmGenericDao.delete(validatorsTable);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public Page<ValidatorsTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ValidatorsTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager")
    @Override
    public Page<ValidatorsTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ValidatorsTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service offlineDatabaseDefined for table ValidatorsTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "offlineDatabaseDefinedTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service offlineDatabaseDefined for table ValidatorsTable to {} format", options.getExportType());
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