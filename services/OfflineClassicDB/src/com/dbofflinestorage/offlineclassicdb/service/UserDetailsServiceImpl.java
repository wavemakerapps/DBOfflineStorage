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

import com.dbofflinestorage.offlineclassicdb.UserDetails;


/**
 * ServiceImpl object for domain model class UserDetails.
 *
 * @see UserDetails
 */
@Service("OfflineClassicDB.UserDetailsService")
@Validated
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    @Autowired
    @Qualifier("OfflineClassicDB.UserDetailsDao")
    private WMGenericDao<UserDetails, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<UserDetails, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "OfflineClassicDBTransactionManager")
    @Override
    public UserDetails create(UserDetails userDetails) {
        LOGGER.debug("Creating a new UserDetails with information: {}", userDetails);

        UserDetails userDetailsCreated = this.wmGenericDao.create(userDetails);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(userDetailsCreated);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public UserDetails getById(Integer userdetailsId) {
        LOGGER.debug("Finding UserDetails by id: {}", userdetailsId);
        return this.wmGenericDao.findById(userdetailsId);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public UserDetails findById(Integer userdetailsId) {
        LOGGER.debug("Finding UserDetails by id: {}", userdetailsId);
        try {
            return this.wmGenericDao.findById(userdetailsId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No UserDetails found with id: {}", userdetailsId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public List<UserDetails> findByMultipleIds(List<Integer> userdetailsIds, boolean orderedReturn) {
        LOGGER.debug("Finding UserDetails by ids: {}", userdetailsIds);

        return this.wmGenericDao.findByMultipleIds(userdetailsIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "OfflineClassicDBTransactionManager")
    @Override
    public UserDetails update(UserDetails userDetails) {
        LOGGER.debug("Updating UserDetails with information: {}", userDetails);

        this.wmGenericDao.update(userDetails);
        this.wmGenericDao.refresh(userDetails);

        return userDetails;
    }

    @Transactional(value = "OfflineClassicDBTransactionManager")
    @Override
    public UserDetails delete(Integer userdetailsId) {
        LOGGER.debug("Deleting UserDetails with id: {}", userdetailsId);
        UserDetails deleted = this.wmGenericDao.findById(userdetailsId);
        if (deleted == null) {
            LOGGER.debug("No UserDetails found with id: {}", userdetailsId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), UserDetails.class.getSimpleName(), userdetailsId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "OfflineClassicDBTransactionManager")
    @Override
    public void delete(UserDetails userDetails) {
        LOGGER.debug("Deleting UserDetails with {}", userDetails);
        this.wmGenericDao.delete(userDetails);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public Page<UserDetails> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all UserDetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager")
    @Override
    public Page<UserDetails> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all UserDetails");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service OfflineClassicDB for table UserDetails to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "OfflineClassicDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service OfflineClassicDB for table UserDetails to {} format", options.getExportType());
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