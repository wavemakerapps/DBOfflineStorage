/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db.service;

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

import com.dbofflinestorage.school_db.ViewResults;
import com.dbofflinestorage.school_db.ViewResultsId;

/**
 * Service object for domain model class {@link ViewResults}.
 */
public interface ViewResultsService {

    /**
     * Creates a new ViewResults. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ViewResults if any.
     *
     * @param viewResults Details of the ViewResults to be created; value cannot be null.
     * @return The newly created ViewResults.
     */
    ViewResults create(@Valid ViewResults viewResults);


	/**
     * Returns ViewResults by given id if exists.
     *
     * @param viewresultsId The id of the ViewResults to get; value cannot be null.
     * @return ViewResults associated with the given viewresultsId.
	 * @throws EntityNotFoundException If no ViewResults is found.
     */
    ViewResults getById(ViewResultsId viewresultsId);

    /**
     * Find and return the ViewResults by given id if exists, returns null otherwise.
     *
     * @param viewresultsId The id of the ViewResults to get; value cannot be null.
     * @return ViewResults associated with the given viewresultsId.
     */
    ViewResults findById(ViewResultsId viewresultsId);

	/**
     * Find and return the list of ViewResults by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param viewresultsIds The id's of the ViewResults to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return ViewResults associated with the given viewresultsIds.
     */
    List<ViewResults> findByMultipleIds(List<ViewResultsId> viewresultsIds, boolean orderedReturn);


    /**
     * Updates the details of an existing ViewResults. It replaces all fields of the existing ViewResults with the given viewResults.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ViewResults if any.
     *
     * @param viewResults The details of the ViewResults to be updated; value cannot be null.
     * @return The updated ViewResults.
     * @throws EntityNotFoundException if no ViewResults is found with given input.
     */
    ViewResults update(@Valid ViewResults viewResults);

    /**
     * Deletes an existing ViewResults with the given id.
     *
     * @param viewresultsId The id of the ViewResults to be deleted; value cannot be null.
     * @return The deleted ViewResults.
     * @throws EntityNotFoundException if no ViewResults found with the given id.
     */
    ViewResults delete(ViewResultsId viewresultsId);

    /**
     * Deletes an existing ViewResults with the given object.
     *
     * @param viewResults The instance of the ViewResults to be deleted; value cannot be null.
     */
    void delete(ViewResults viewResults);

    /**
     * Find all ViewResults matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ViewResults.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<ViewResults> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all ViewResults matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ViewResults.
     *
     * @see Pageable
     * @see Page
     */
    Page<ViewResults> findAll(String query, Pageable pageable);

    /**
     * Exports all ViewResults matching the given input query to the given exportType format.
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
     * Exports all ViewResults matching the given input query to the given exportType format.
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
     * Retrieve the count of the ViewResults in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the ViewResults.
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