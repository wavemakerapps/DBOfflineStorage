/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlinedatabasedefined.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.dbofflinestorage.offlinedatabasedefined.DateDatabaseDefined;
import com.dbofflinestorage.offlinedatabasedefined.service.DateDatabaseDefinedService;


/**
 * Controller object for domain model class DateDatabaseDefined.
 * @see DateDatabaseDefined
 */
@RestController("offlineDatabaseDefined.DateDatabaseDefinedController")
@Api(value = "DateDatabaseDefinedController", description = "Exposes APIs to work with DateDatabaseDefined resource.")
@RequestMapping("/offlineDatabaseDefined/DateDatabaseDefined")
public class DateDatabaseDefinedController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateDatabaseDefinedController.class);

    @Autowired
	@Qualifier("offlineDatabaseDefined.DateDatabaseDefinedService")
	private DateDatabaseDefinedService dateDatabaseDefinedService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new DateDatabaseDefined instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DateDatabaseDefined createDateDatabaseDefined(@RequestBody DateDatabaseDefined dateDatabaseDefined) {
		LOGGER.debug("Create DateDatabaseDefined with information: {}" , dateDatabaseDefined);

		dateDatabaseDefined = dateDatabaseDefinedService.create(dateDatabaseDefined);
		LOGGER.debug("Created DateDatabaseDefined with information: {}" , dateDatabaseDefined);

	    return dateDatabaseDefined;
	}

    @ApiOperation(value = "Returns the DateDatabaseDefined instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DateDatabaseDefined getDateDatabaseDefined(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting DateDatabaseDefined with id: {}" , id);

        DateDatabaseDefined foundDateDatabaseDefined = dateDatabaseDefinedService.getById(id);
        LOGGER.debug("DateDatabaseDefined details with id: {}" , foundDateDatabaseDefined);

        return foundDateDatabaseDefined;
    }

    @ApiOperation(value = "Updates the DateDatabaseDefined instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DateDatabaseDefined editDateDatabaseDefined(@PathVariable("id") Integer id, @RequestBody DateDatabaseDefined dateDatabaseDefined) {
        LOGGER.debug("Editing DateDatabaseDefined with id: {}" , dateDatabaseDefined.getPkid());

        dateDatabaseDefined.setPkid(id);
        dateDatabaseDefined = dateDatabaseDefinedService.update(dateDatabaseDefined);
        LOGGER.debug("DateDatabaseDefined details with id: {}" , dateDatabaseDefined);

        return dateDatabaseDefined;
    }

    @ApiOperation(value = "Deletes the DateDatabaseDefined instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDateDatabaseDefined(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting DateDatabaseDefined with id: {}" , id);

        DateDatabaseDefined deletedDateDatabaseDefined = dateDatabaseDefinedService.delete(id);

        return deletedDateDatabaseDefined != null;
    }

    /**
     * @deprecated Use {@link #findDateDatabaseDefineds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of DateDatabaseDefined instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DateDatabaseDefined> searchDateDatabaseDefinedsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DateDatabaseDefineds list by query filter:{}", (Object) queryFilters);
        return dateDatabaseDefinedService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DateDatabaseDefined instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DateDatabaseDefined> findDateDatabaseDefineds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DateDatabaseDefineds list by filter:", query);
        return dateDatabaseDefinedService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DateDatabaseDefined instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DateDatabaseDefined> filterDateDatabaseDefineds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DateDatabaseDefineds list by filter", query);
        return dateDatabaseDefinedService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportDateDatabaseDefineds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return dateDatabaseDefinedService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportDateDatabaseDefinedsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = DateDatabaseDefined.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> dateDatabaseDefinedService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of DateDatabaseDefined instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countDateDatabaseDefineds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting DateDatabaseDefineds");
		return dateDatabaseDefinedService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getDateDatabaseDefinedAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return dateDatabaseDefinedService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DateDatabaseDefinedService instance
	 */
	protected void setDateDatabaseDefinedService(DateDatabaseDefinedService service) {
		this.dateDatabaseDefinedService = service;
	}

}