/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlineclassicdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.dbofflinestorage.offlineclassicdb.AppEnvTable;

/**
 * Service object for domain model class {@link AppEnvTable}.
 */
public interface AppEnvTableService {

    /**
     * Creates a new AppEnvTable. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AppEnvTable if any.
     *
     * @param appEnvTable Details of the AppEnvTable to be created; value cannot be null.
     * @return The newly created AppEnvTable.
     */
    AppEnvTable create(@Valid AppEnvTable appEnvTable);


	/**
     * Returns AppEnvTable by given id if exists.
     *
     * @param appenvtableId The id of the AppEnvTable to get; value cannot be null.
     * @return AppEnvTable associated with the given appenvtableId.
	 * @throws EntityNotFoundException If no AppEnvTable is found.
     */
    AppEnvTable getById(Integer appenvtableId);

    /**
     * Find and return the AppEnvTable by given id if exists, returns null otherwise.
     *
     * @param appenvtableId The id of the AppEnvTable to get; value cannot be null.
     * @return AppEnvTable associated with the given appenvtableId.
     */
    AppEnvTable findById(Integer appenvtableId);

	/**
     * Find and return the list of AppEnvTables by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param appenvtableIds The id's of the AppEnvTable to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return AppEnvTables associated with the given appenvtableIds.
     */
    List<AppEnvTable> findByMultipleIds(List<Integer> appenvtableIds, boolean orderedReturn);


    /**
     * Updates the details of an existing AppEnvTable. It replaces all fields of the existing AppEnvTable with the given appEnvTable.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AppEnvTable if any.
     *
     * @param appEnvTable The details of the AppEnvTable to be updated; value cannot be null.
     * @return The updated AppEnvTable.
     * @throws EntityNotFoundException if no AppEnvTable is found with given input.
     */
    AppEnvTable update(@Valid AppEnvTable appEnvTable);

    /**
     * Deletes an existing AppEnvTable with the given id.
     *
     * @param appenvtableId The id of the AppEnvTable to be deleted; value cannot be null.
     * @return The deleted AppEnvTable.
     * @throws EntityNotFoundException if no AppEnvTable found with the given id.
     */
    AppEnvTable delete(Integer appenvtableId);

    /**
     * Deletes an existing AppEnvTable with the given object.
     *
     * @param appEnvTable The instance of the AppEnvTable to be deleted; value cannot be null.
     */
    void delete(AppEnvTable appEnvTable);

    /**
     * Find all AppEnvTables matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AppEnvTables.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<AppEnvTable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all AppEnvTables matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AppEnvTables.
     *
     * @see Pageable
     * @see Page
     */
    Page<AppEnvTable> findAll(String query, Pageable pageable);

    /**
     * Exports all AppEnvTables matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all AppEnvTables matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the AppEnvTables in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the AppEnvTable.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}