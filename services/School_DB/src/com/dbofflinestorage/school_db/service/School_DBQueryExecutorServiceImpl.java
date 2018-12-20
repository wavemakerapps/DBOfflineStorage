/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.HashMap;
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

import com.dbofflinestorage.school_db.models.query.*;

@Service
public class School_DBQueryExecutorServiceImpl implements School_DBQueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(School_DBQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("School_DBWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvSubStrResponse> executeSV_SubStr(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_SubStr", params, SvSubStrResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_SubStr(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_SubStr", params, SvSubStrResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvInnerJoinsResponse> executeSV_InnerJoins(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_InnerJoins", params, SvInnerJoinsResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_InnerJoins(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_InnerJoins", params, SvInnerJoinsResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvNotnullResponse> executeSV_NOTNULL(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_NOTNULL", params, SvNotnullResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_NOTNULL(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_NOTNULL", params, SvNotnullResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvStudentDetailsResponse> executeSV_StudentDetails(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_StudentDetails", params, SvStudentDetailsResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public InputStream getProfilePicContentForSV_StudentDetails(Integer studentId) throws EntityNotFoundException {
        Map<String, Object> params = new HashMap<>(0);

        params.put("studentId", studentId);

        SvStudentDetailsResponse _result =  queryExecutor.executeNamedQuery("SV_StudentDetails__identifier", params, SvStudentDetailsResponse.class);
        if(_result.getProfilePic() == null) {
            LOGGER.debug("Blob content not exists for profilePic in query SV_StudentDetails");
            throw new BlobContentNotFoundException("Blob content not found for profilePic in query SV_StudentDetails");
        }
        return new ByteArrayInputStream(_result.getProfilePic());
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_StudentDetails(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_StudentDetails", params, SvStudentDetailsResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvLeftOuterJoinResponse> executeSV_LeftOuterJoin(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_LeftOuterJoin", params, SvLeftOuterJoinResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_LeftOuterJoin(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_LeftOuterJoin", params, SvLeftOuterJoinResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvDateFormatSyntaxResponse> executeSV_DateFormatSyntax(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_DateFormatSyntax", params, SvDateFormatSyntaxResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_DateFormatSyntax(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_DateFormatSyntax", params, SvDateFormatSyntaxResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvInnerJoinWithOrderByResponse> executeSV_InnerJoinWithOrderBy(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_InnerJoinWithOrderBy", params, SvInnerJoinWithOrderByResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public InputStream getPicUrlContentForSV_InnerJoinWithOrderBy(Integer empId) throws EntityNotFoundException {
        Map<String, Object> params = new HashMap<>(0);

        params.put("empId", empId);

        SvInnerJoinWithOrderByResponse _result =  queryExecutor.executeNamedQuery("SV_InnerJoinWithOrderBy__identifier", params, SvInnerJoinWithOrderByResponse.class);
        if(_result.getPicUrl() == null) {
            LOGGER.debug("Blob content not exists for picUrl in query SV_InnerJoinWithOrderBy");
            throw new BlobContentNotFoundException("Blob content not found for picUrl in query SV_InnerJoinWithOrderBy");
        }
        return new ByteArrayInputStream(_result.getPicUrl());
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_InnerJoinWithOrderBy(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_InnerJoinWithOrderBy", params, SvInnerJoinWithOrderByResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<HqlCountDistinctResponse> executeHQL_COUNT_DISTINCT(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("HQL_COUNT_DISTINCT", params, HqlCountDistinctResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportHQL_COUNT_DISTINCT(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("HQL_COUNT_DISTINCT", params, HqlCountDistinctResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvMaxfunctionResponse> executeSV_MAXFunction(String academicYear, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        return queryExecutor.executeNamedQuery("SV_MAXFunction", params, SvMaxfunctionResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_MAXFunction(String academicYear, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_MAXFunction", params, SvMaxfunctionResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvLowerFunctionResponse> executeSV_LowerFunction(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_LowerFunction", params, SvLowerFunctionResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_LowerFunction(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_LowerFunction", params, SvLowerFunctionResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvSumFunctionResponse> executeSV_SumFunction(String academicYear, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        return queryExecutor.executeNamedQuery("SV_SumFunction", params, SvSumFunctionResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_SumFunction(String academicYear, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_SumFunction", params, SvSumFunctionResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvGroupByHavingClauseResponse> executeSV_GroupByHavingClause(String academicYear, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        return queryExecutor.executeNamedQuery("SV_GroupByHavingClause", params, SvGroupByHavingClauseResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_GroupByHavingClause(String academicYear, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_GroupByHavingClause", params, SvGroupByHavingClauseResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvMinFunctionResponse> executeSV_MinFunction(String academicYear, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        return queryExecutor.executeNamedQuery("SV_MinFunction", params, SvMinFunctionResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_MinFunction(String academicYear, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_MinFunction", params, SvMinFunctionResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<HqlGroupByResponse> executeHQL_GroupBy(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("HQL_GroupBy", params, HqlGroupByResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportHQL_GroupBy(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("HQL_GroupBy", params, HqlGroupByResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvAliasResponse> executeSV_Alias(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_Alias", params, SvAliasResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_Alias(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_Alias", params, SvAliasResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvGroupByResponse> executeSV_GroupBy(String academicYear, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        return queryExecutor.executeNamedQuery("SV_GroupBy", params, SvGroupByResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_GroupBy(String academicYear, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_GroupBy", params, SvGroupByResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvUnionAllResponse> executeSV_UnionAll(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_UnionAll", params, SvUnionAllResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public InputStream getZipContentForSV_UnionAll(Integer empId) throws EntityNotFoundException {
        Map<String, Object> params = new HashMap<>(0);

        params.put("empId", empId);

        SvUnionAllResponse _result =  queryExecutor.executeNamedQuery("SV_UnionAll__identifier", params, SvUnionAllResponse.class);
        if(_result.getZip() == null) {
            LOGGER.debug("Blob content not exists for zip in query SV_UnionAll");
            throw new BlobContentNotFoundException("Blob content not found for zip in query SV_UnionAll");
        }
        return new ByteArrayInputStream(_result.getZip());
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public InputStream getPicUrlContentForSV_UnionAll(Integer empId) throws EntityNotFoundException {
        Map<String, Object> params = new HashMap<>(0);

        params.put("empId", empId);

        SvUnionAllResponse _result =  queryExecutor.executeNamedQuery("SV_UnionAll__identifier", params, SvUnionAllResponse.class);
        if(_result.getPicUrl() == null) {
            LOGGER.debug("Blob content not exists for picUrl in query SV_UnionAll");
            throw new BlobContentNotFoundException("Blob content not found for picUrl in query SV_UnionAll");
        }
        return new ByteArrayInputStream(_result.getPicUrl());
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_UnionAll(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_UnionAll", params, SvUnionAllResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvUpperFunctionResponse> executeSV_UpperFunction(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_UpperFunction", params, SvUpperFunctionResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_UpperFunction(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_UpperFunction", params, SvUpperFunctionResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvCountSyntaxResponse> executeSV_CountSyntax(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_CountSyntax", params, SvCountSyntaxResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_CountSyntax(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_CountSyntax", params, SvCountSyntaxResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvAvgfunctionResponse> executeSV_AVGFunction(Integer studentId, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("STUDENT_ID", studentId);

        return queryExecutor.executeNamedQuery("SV_AVGFunction", params, SvAvgfunctionResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_AVGFunction(Integer studentId, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("STUDENT_ID", studentId);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_AVGFunction", params, SvAvgfunctionResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvFullJoinResponse> executeSV_FullJoin(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_FullJoin", params, SvFullJoinResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_FullJoin(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_FullJoin", params, SvFullJoinResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvNestedQueryResponse> executeSV_NestedQuery(String academicYear, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        return queryExecutor.executeNamedQuery("SV_NestedQuery", params, SvNestedQueryResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_NestedQuery(String academicYear, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("ACADEMIC_YEAR", academicYear);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_NestedQuery", params, SvNestedQueryResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvConcatQueryResponse> executeSV_ConcatQuery(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_ConcatQuery", params, SvConcatQueryResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_ConcatQuery(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_ConcatQuery", params, SvConcatQueryResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvLengthFunctionResponse> executeSV_LengthFunction(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_LengthFunction", params, SvLengthFunctionResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_LengthFunction(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_LengthFunction", params, SvLengthFunctionResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvQueryWithDateResponse> executeSV_QueryWithDate(Date jdate, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("JDATE", jdate);

        return queryExecutor.executeNamedQuery("SV_QueryWithDate", params, SvQueryWithDateResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public InputStream getProfilePicContentForSV_QueryWithDate(Integer studentId, Date jdate) throws EntityNotFoundException {
        Map<String, Object> params = new HashMap<>(1);

        params.put("studentId", studentId);
        params.put("JDATE", jdate);

        SvQueryWithDateResponse _result =  queryExecutor.executeNamedQuery("SV_QueryWithDate__identifier", params, SvQueryWithDateResponse.class);
        if(_result.getProfilePic() == null) {
            LOGGER.debug("Blob content not exists for profilePic in query SV_QueryWithDate");
            throw new BlobContentNotFoundException("Blob content not found for profilePic in query SV_QueryWithDate");
        }
        return new ByteArrayInputStream(_result.getProfilePic());
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_QueryWithDate(Date jdate, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("JDATE", jdate);

        QueryProcedureInput queryInput = new QueryProcedureInput("SV_QueryWithDate", params, SvQueryWithDateResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvIsNullResponse> executeSV_IsNULL(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_IsNULL", params, SvIsNullResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_IsNULL(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_IsNULL", params, SvIsNullResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "School_DBTransactionManager", readOnly = true)
    @Override
    public Page<SvRightJoinResponse> executeSV_RightJoin(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("SV_RightJoin", params, SvRightJoinResponse.class, pageable);
    }

    @Transactional(value = "School_DBTransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportSV_RightJoin(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput queryInput = new QueryProcedureInput("SV_RightJoin", params, SvRightJoinResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

}