/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlineclassicdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
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

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.exception.BlobContentNotFoundException;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportOptions;
import com.wavemaker.runtime.data.model.QueryProcedureInput;

import com.dbofflinestorage.offlineclassicdb.Customers;
import com.dbofflinestorage.offlineclassicdb.Employees;
import com.dbofflinestorage.offlineclassicdb.OrderDetails;
import com.dbofflinestorage.offlineclassicdb.models.query.*;

@Service
public class OfflineClassicDBQueryExecutorServiceImpl implements OfflineClassicDBQueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfflineClassicDBQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("OfflineClassicDBWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvOroperatorResponse> executeSV_OROperator(Integer officeCode1, Integer officeCode2, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("officeCode1", officeCode1);
        params.put("officeCode2", officeCode2);

        return queryExecutor.executeNamedQuery("SV_OROperator", params, SvOroperatorResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_OROperator(Integer officeCode1, Integer officeCode2, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("officeCode1", officeCode1);
        params.put("officeCode2", officeCode2);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_OROperator", params, SvOroperatorResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvAndoperatorResponse> executeSV_ANDOperator(String status, Integer custNumber, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("status", status);
        params.put("custNumber", custNumber);

        return queryExecutor.executeNamedQuery("SV_ANDOperator", params, SvAndoperatorResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_ANDOperator(String status, Integer custNumber, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("status", status);
        params.put("custNumber", custNumber);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_ANDOperator", params, SvAndoperatorResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<Customers> executeHQL_FromCustomer(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("HQL_FromCustomer", params, Customers.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportHQL_FromCustomer(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("HQL_FromCustomer", params, Customers.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvLessThanResponse> executeSV_LessThan(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_LessThan", params, SvLessThanResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_LessThan(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_LessThan", params, SvLessThanResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvDistinctResponse> executeSV_DISTINCT(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_DISTINCT", params, SvDistinctResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_DISTINCT(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_DISTINCT", params, SvDistinctResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvWhereClauseResponse> executeSV_WhereClause(String city, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("city", city);

        return queryExecutor.executeNamedQuery("SV_WhereClause", params, SvWhereClauseResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_WhereClause(String city, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("city", city);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_WhereClause", params, SvWhereClauseResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<HqlCustomQueryWithAliasResponse> executeHQL_CustomQueryWithAlias(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("HQL_CustomQueryWithAlias", params, HqlCustomQueryWithAliasResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportHQL_CustomQueryWithAlias(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("HQL_CustomQueryWithAlias", params, HqlCustomQueryWithAliasResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<Employees> executeHQL_GreaterThanOrderBy(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("HQL_GreaterThanOrderBy", params, Employees.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportHQL_GreaterThanOrderBy(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("HQL_GreaterThanOrderBy", params, Employees.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<Employees> executeHQL_FromEntityWhereClause(Integer empNumber, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("empNumber", empNumber);

        return queryExecutor.executeNamedQuery("HQL_FromEntityWhereClause", params, Employees.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportHQL_FromEntityWhereClause(Integer empNumber, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("empNumber", empNumber);

        QueryProcedureInput queryInput = new QueryProcedureInput("HQL_FromEntityWhereClause", params, Employees.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvBetweenOperatorResponse> executeSV_BetweenOperator(Byte bytevalue1, Byte bytevalue2, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("bytevalue1", bytevalue1);
        params.put("bytevalue2", bytevalue2);

        return queryExecutor.executeNamedQuery("SV_BetweenOperator", params, SvBetweenOperatorResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public InputStream getBlobColContentForSV_BetweenOperator(Integer pkId, Byte bytevalue1, Byte bytevalue2) throws EntityNotFoundException {
        Map<String, Object> params = new HashMap<>(2);

        params.put("pkId", pkId);
        params.put("bytevalue1", bytevalue1);
        params.put("bytevalue2", bytevalue2);

        SvBetweenOperatorResponse _result =  queryExecutor.executeNamedQuery("SV_BetweenOperator__identifier", params, SvBetweenOperatorResponse.class);
        if(_result.getBlobCol() == null) {
            LOGGER.debug("Blob content not exists for blobCol in query SV_BetweenOperator");
            throw new BlobContentNotFoundException("Blob content not found for blobCol in query SV_BetweenOperator");
        }
        return new ByteArrayInputStream(_result.getBlobCol());
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_BetweenOperator(Byte bytevalue1, Byte bytevalue2, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("bytevalue1", bytevalue1);
        params.put("bytevalue2", bytevalue2);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_BetweenOperator", params, SvBetweenOperatorResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvCombinedOrderByResponse> executeSV_CombinedOrderBy(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_CombinedOrderBy", params, SvCombinedOrderByResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public InputStream getBlobColContentForSV_CombinedOrderBy(Integer pkId) throws EntityNotFoundException {
        Map<String, Object> params = new HashMap<>(0);

        params.put("pkId", pkId);

        SvCombinedOrderByResponse _result =  queryExecutor.executeNamedQuery("SV_CombinedOrderBy__identifier", params, SvCombinedOrderByResponse.class);
        if(_result.getBlobCol() == null) {
            LOGGER.debug("Blob content not exists for blobCol in query SV_CombinedOrderBy");
            throw new BlobContentNotFoundException("Blob content not found for blobCol in query SV_CombinedOrderBy");
        }
        return new ByteArrayInputStream(_result.getBlobCol());
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_CombinedOrderBy(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_CombinedOrderBy", params, SvCombinedOrderByResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvInoperatorResponse> executeSV_INOperator(List<String> pcode, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("PCODE", pcode);

        return queryExecutor.executeNamedQuery("SV_INOperator", params, SvInoperatorResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_INOperator(List<String> pcode, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("PCODE", pcode);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_INOperator", params, SvInoperatorResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvLikeResponse> executeSV_LIKE(String jobtitle, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("jobtitle", jobtitle);

        return queryExecutor.executeNamedQuery("SV_LIKE", params, SvLikeResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_LIKE(String jobtitle, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("jobtitle", jobtitle);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_LIKE", params, SvLikeResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvGreaterThanResponse> executeSV_GreaterThan(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_GreaterThan", params, SvGreaterThanResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_GreaterThan(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_GreaterThan", params, SvGreaterThanResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<OrderDetails> executeHQL_FromEntityUsingAlias(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("HQL_FromEntityUsingAlias", params, OrderDetails.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportHQL_FromEntityUsingAlias(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("HQL_FromEntityUsingAlias", params, OrderDetails.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<HqlCustomQueryWithoutAliasNamesResponse> executeHQL_CustomQueryWithoutAliasNames(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("HQL_CustomQueryWithoutAliasNames", params, HqlCustomQueryWithoutAliasNamesResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportHQL_CustomQueryWithoutAliasNames(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("HQL_CustomQueryWithoutAliasNames", params, HqlCustomQueryWithoutAliasNamesResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", readOnly = true)
    @Override
    public Page<SvAndOrResponse> executeSV_AND_OR(String status, Integer custNumber1, Integer custNumber2, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(3);

        params.put("status", status);
        params.put("custNumber1", custNumber1);
        params.put("custNumber2", custNumber2);

        return queryExecutor.executeNamedQuery("SV_AND_OR", params, SvAndOrResponse.class, pageable);
    }

    @Transactional(value = "OfflineClassicDBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_AND_OR(String status, Integer custNumber1, Integer custNumber2, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(3);

        params.put("status", status);
        params.put("custNumber1", custNumber1);
        params.put("custNumber2", custNumber2);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_AND_OR", params, SvAndOrResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

}