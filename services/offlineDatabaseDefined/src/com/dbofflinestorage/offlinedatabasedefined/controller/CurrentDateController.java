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
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.dbofflinestorage.offlinedatabasedefined.CurrentDate;
import com.dbofflinestorage.offlinedatabasedefined.service.CurrentDateService;


/**
 * Controller object for domain model class CurrentDate.
 * @see CurrentDate
 */
@RestController("offlineDatabaseDefined.CurrentDateController")
@Api(value = "CurrentDateController", description = "Exposes APIs to work with CurrentDate resource.")
@RequestMapping("/offlineDatabaseDefined/CurrentDate")
public class CurrentDateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentDateController.class);

    @Autowired
	@Qualifier("offlineDatabaseDefined.CurrentDateService")
	private CurrentDateService currentDateService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new CurrentDate instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CurrentDate createCurrentDate(@RequestBody CurrentDate currentDate) {
		LOGGER.debug("Create CurrentDate with information: {}" , currentDate);

		currentDate = currentDateService.create(currentDate);
		LOGGER.debug("Created CurrentDate with information: {}" , currentDate);

	    return currentDate;
	}

    @ApiOperation(value = "Returns the CurrentDate instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CurrentDate getCurrentDate(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting CurrentDate with id: {}" , id);

        CurrentDate foundCurrentDate = currentDateService.getById(id);
        LOGGER.debug("CurrentDate details with id: {}" , foundCurrentDate);

        return foundCurrentDate;
    }

    @ApiOperation(value = "Updates the CurrentDate instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CurrentDate editCurrentDate(@PathVariable("id") Integer id, @RequestBody CurrentDate currentDate) {
        LOGGER.debug("Editing CurrentDate with id: {}" , currentDate.getPk());

        currentDate.setPk(id);
        currentDate = currentDateService.update(currentDate);
        LOGGER.debug("CurrentDate details with id: {}" , currentDate);

        return currentDate;
    }

    @ApiOperation(value = "Deletes the CurrentDate instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCurrentDate(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting CurrentDate with id: {}" , id);

        CurrentDate deletedCurrentDate = currentDateService.delete(id);

        return deletedCurrentDate != null;
    }

    /**
     * @deprecated Use {@link #findCurrentDates(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of CurrentDate instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<CurrentDate> searchCurrentDatesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CurrentDates list by query filter:{}", (Object) queryFilters);
        return currentDateService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CurrentDate instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CurrentDate> findCurrentDates(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CurrentDates list by filter:", query);
        return currentDateService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CurrentDate instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<CurrentDate> filterCurrentDates(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CurrentDates list by filter", query);
        return currentDateService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportCurrentDates(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return currentDateService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportCurrentDatesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = CurrentDate.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> currentDateService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of CurrentDate instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countCurrentDates( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting CurrentDates");
		return currentDateService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getCurrentDateAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return currentDateService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CurrentDateService instance
	 */
	protected void setCurrentDateService(CurrentDateService service) {
		this.currentDateService = service;
	}

}