/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlineclassicdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.sql.Date;
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

import com.dbofflinestorage.offlineclassicdb.UniqueConstraint;
import com.dbofflinestorage.offlineclassicdb.service.UniqueConstraintService;


/**
 * Controller object for domain model class UniqueConstraint.
 * @see UniqueConstraint
 */
@RestController("OfflineClassicDB.UniqueConstraintController")
@Api(value = "UniqueConstraintController", description = "Exposes APIs to work with UniqueConstraint resource.")
@RequestMapping("/OfflineClassicDB/UniqueConstraint")
public class UniqueConstraintController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniqueConstraintController.class);

    @Autowired
	@Qualifier("OfflineClassicDB.UniqueConstraintService")
	private UniqueConstraintService uniqueConstraintService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new UniqueConstraint instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UniqueConstraint createUniqueConstraint(@RequestBody UniqueConstraint uniqueConstraint) {
		LOGGER.debug("Create UniqueConstraint with information: {}" , uniqueConstraint);

		uniqueConstraint = uniqueConstraintService.create(uniqueConstraint);
		LOGGER.debug("Created UniqueConstraint with information: {}" , uniqueConstraint);

	    return uniqueConstraint;
	}

    @ApiOperation(value = "Returns the UniqueConstraint instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UniqueConstraint getUniqueConstraint(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting UniqueConstraint with id: {}" , id);

        UniqueConstraint foundUniqueConstraint = uniqueConstraintService.getById(id);
        LOGGER.debug("UniqueConstraint details with id: {}" , foundUniqueConstraint);

        return foundUniqueConstraint;
    }

    @ApiOperation(value = "Updates the UniqueConstraint instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UniqueConstraint editUniqueConstraint(@PathVariable("id") Integer id, @RequestBody UniqueConstraint uniqueConstraint) {
        LOGGER.debug("Editing UniqueConstraint with id: {}" , uniqueConstraint.getId());

        uniqueConstraint.setId(id);
        uniqueConstraint = uniqueConstraintService.update(uniqueConstraint);
        LOGGER.debug("UniqueConstraint details with id: {}" , uniqueConstraint);

        return uniqueConstraint;
    }

    @ApiOperation(value = "Deletes the UniqueConstraint instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUniqueConstraint(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting UniqueConstraint with id: {}" , id);

        UniqueConstraint deletedUniqueConstraint = uniqueConstraintService.delete(id);

        return deletedUniqueConstraint != null;
    }

    @RequestMapping(value = "/dateCol-charCol", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching UniqueConstraint with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UniqueConstraint getByDateColAndCharCol(@RequestParam("dateCol") Date dateCol, @RequestParam("charCol") String charCol) {
        LOGGER.debug("Getting UniqueConstraint with uniques key DateColAndCharCol");
        return uniqueConstraintService.getByDateColAndCharCol(dateCol, charCol);
    }

    @RequestMapping(value = "/stringCol/{stringCol}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching UniqueConstraint with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UniqueConstraint getByStringCol(@PathVariable("stringCol") String stringCol) {
        LOGGER.debug("Getting UniqueConstraint with uniques key StringCol");
        return uniqueConstraintService.getByStringCol(stringCol);
    }

    /**
     * @deprecated Use {@link #findUniqueConstraints(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of UniqueConstraint instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<UniqueConstraint> searchUniqueConstraintsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering UniqueConstraints list by query filter:{}", (Object) queryFilters);
        return uniqueConstraintService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UniqueConstraint instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UniqueConstraint> findUniqueConstraints(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UniqueConstraints list by filter:", query);
        return uniqueConstraintService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UniqueConstraint instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<UniqueConstraint> filterUniqueConstraints(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UniqueConstraints list by filter", query);
        return uniqueConstraintService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportUniqueConstraints(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return uniqueConstraintService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportUniqueConstraintsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = UniqueConstraint.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> uniqueConstraintService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of UniqueConstraint instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countUniqueConstraints( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting UniqueConstraints");
		return uniqueConstraintService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getUniqueConstraintAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return uniqueConstraintService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UniqueConstraintService instance
	 */
	protected void setUniqueConstraintService(UniqueConstraintService service) {
		this.uniqueConstraintService = service;
	}

}