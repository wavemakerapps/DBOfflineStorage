/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlineclassicdb.controller;

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

import com.dbofflinestorage.offlineclassicdb.AppEnvTable;
import com.dbofflinestorage.offlineclassicdb.service.AppEnvTableService;


/**
 * Controller object for domain model class AppEnvTable.
 * @see AppEnvTable
 */
@RestController("OfflineClassicDB.AppEnvTableController")
@Api(value = "AppEnvTableController", description = "Exposes APIs to work with AppEnvTable resource.")
@RequestMapping("/OfflineClassicDB/AppEnvTable")
public class AppEnvTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppEnvTableController.class);

    @Autowired
	@Qualifier("OfflineClassicDB.AppEnvTableService")
	private AppEnvTableService appEnvTableService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new AppEnvTable instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AppEnvTable createAppEnvTable(@RequestBody AppEnvTable appEnvTable) {
		LOGGER.debug("Create AppEnvTable with information: {}" , appEnvTable);

		appEnvTable = appEnvTableService.create(appEnvTable);
		LOGGER.debug("Created AppEnvTable with information: {}" , appEnvTable);

	    return appEnvTable;
	}

    @ApiOperation(value = "Returns the AppEnvTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AppEnvTable getAppEnvTable(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting AppEnvTable with id: {}" , id);

        AppEnvTable foundAppEnvTable = appEnvTableService.getById(id);
        LOGGER.debug("AppEnvTable details with id: {}" , foundAppEnvTable);

        return foundAppEnvTable;
    }

    @ApiOperation(value = "Updates the AppEnvTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AppEnvTable editAppEnvTable(@PathVariable("id") Integer id, @RequestBody AppEnvTable appEnvTable) {
        LOGGER.debug("Editing AppEnvTable with id: {}" , appEnvTable.getPkId());

        appEnvTable.setPkId(id);
        appEnvTable = appEnvTableService.update(appEnvTable);
        LOGGER.debug("AppEnvTable details with id: {}" , appEnvTable);

        return appEnvTable;
    }

    @ApiOperation(value = "Deletes the AppEnvTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAppEnvTable(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting AppEnvTable with id: {}" , id);

        AppEnvTable deletedAppEnvTable = appEnvTableService.delete(id);

        return deletedAppEnvTable != null;
    }

    /**
     * @deprecated Use {@link #findAppEnvTables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of AppEnvTable instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AppEnvTable> searchAppEnvTablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering AppEnvTables list by query filter:{}", (Object) queryFilters);
        return appEnvTableService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AppEnvTable instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AppEnvTable> findAppEnvTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AppEnvTables list by filter:", query);
        return appEnvTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AppEnvTable instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AppEnvTable> filterAppEnvTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AppEnvTables list by filter", query);
        return appEnvTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAppEnvTables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return appEnvTableService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportAppEnvTablesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = AppEnvTable.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> appEnvTableService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of AppEnvTable instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAppEnvTables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting AppEnvTables");
		return appEnvTableService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAppEnvTableAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return appEnvTableService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AppEnvTableService instance
	 */
	protected void setAppEnvTableService(AppEnvTableService service) {
		this.appEnvTableService = service;
	}

}