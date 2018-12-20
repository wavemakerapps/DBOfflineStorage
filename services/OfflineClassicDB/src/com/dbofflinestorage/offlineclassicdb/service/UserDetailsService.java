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

import com.dbofflinestorage.offlineclassicdb.UserDetails;

/**
 * Service object for domain model class {@link UserDetails}.
 */
public interface UserDetailsService {

    /**
     * Creates a new UserDetails. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on UserDetails if any.
     *
     * @param userDetails Details of the UserDetails to be created; value cannot be null.
     * @return The newly created UserDetails.
     */
    UserDetails create(@Valid UserDetails userDetails);


	/**
     * Returns UserDetails by given id if exists.
     *
     * @param userdetailsId The id of the UserDetails to get; value cannot be null.
     * @return UserDetails associated with the given userdetailsId.
	 * @throws EntityNotFoundException If no UserDetails is found.
     */
    UserDetails getById(Integer userdetailsId);

    /**
     * Find and return the UserDetails by given id if exists, returns null otherwise.
     *
     * @param userdetailsId The id of the UserDetails to get; value cannot be null.
     * @return UserDetails associated with the given userdetailsId.
     */
    UserDetails findById(Integer userdetailsId);

	/**
     * Find and return the list of UserDetails by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param userdetailsIds The id's of the UserDetails to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return UserDetails associated with the given userdetailsIds.
     */
    List<UserDetails> findByMultipleIds(List<Integer> userdetailsIds, boolean orderedReturn);


    /**
     * Updates the details of an existing UserDetails. It replaces all fields of the existing UserDetails with the given userDetails.
     *
     * This method overrides the input field values using Server side or database managed properties defined on UserDetails if any.
     *
     * @param userDetails The details of the UserDetails to be updated; value cannot be null.
     * @return The updated UserDetails.
     * @throws EntityNotFoundException if no UserDetails is found with given input.
     */
    UserDetails update(@Valid UserDetails userDetails);

    /**
     * Deletes an existing UserDetails with the given id.
     *
     * @param userdetailsId The id of the UserDetails to be deleted; value cannot be null.
     * @return The deleted UserDetails.
     * @throws EntityNotFoundException if no UserDetails found with the given id.
     */
    UserDetails delete(Integer userdetailsId);

    /**
     * Deletes an existing UserDetails with the given object.
     *
     * @param userDetails The instance of the UserDetails to be deleted; value cannot be null.
     */
    void delete(UserDetails userDetails);

    /**
     * Find all UserDetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UserDetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<UserDetails> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all UserDetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UserDetails.
     *
     * @see Pageable
     * @see Page
     */
    Page<UserDetails> findAll(String query, Pageable pageable);

    /**
     * Exports all UserDetails matching the given input query to the given exportType format.
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
     * Exports all UserDetails matching the given input query to the given exportType format.
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
     * Retrieve the count of the UserDetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the UserDetails.
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