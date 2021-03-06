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

import com.dbofflinestorage.offlinedatabasedefined.Many2oneC;
import com.dbofflinestorage.offlinedatabasedefined.One2manyP;
import com.dbofflinestorage.offlinedatabasedefined.service.One2manyPService;


/**
 * Controller object for domain model class One2manyP.
 * @see One2manyP
 */
@RestController("offlineDatabaseDefined.One2manyPController")
@Api(value = "One2manyPController", description = "Exposes APIs to work with One2manyP resource.")
@RequestMapping("/offlineDatabaseDefined/One2manyP")
public class One2manyPController {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2manyPController.class);

    @Autowired
	@Qualifier("offlineDatabaseDefined.One2manyPService")
	private One2manyPService one2manyPService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new One2manyP instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2manyP createOne2manyP(@RequestBody One2manyP one2manyP) {
		LOGGER.debug("Create One2manyP with information: {}" , one2manyP);

		one2manyP = one2manyPService.create(one2manyP);
		LOGGER.debug("Created One2manyP with information: {}" , one2manyP);

	    return one2manyP;
	}

    @ApiOperation(value = "Returns the One2manyP instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2manyP getOne2manyP(@PathVariable("id") String id) {
        LOGGER.debug("Getting One2manyP with id: {}" , id);

        One2manyP foundOne2manyP = one2manyPService.getById(id);
        LOGGER.debug("One2manyP details with id: {}" , foundOne2manyP);

        return foundOne2manyP;
    }

    @ApiOperation(value = "Updates the One2manyP instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2manyP editOne2manyP(@PathVariable("id") String id, @RequestBody One2manyP one2manyP) {
        LOGGER.debug("Editing One2manyP with id: {}" , one2manyP.getPid());

        one2manyP.setPid(id);
        one2manyP = one2manyPService.update(one2manyP);
        LOGGER.debug("One2manyP details with id: {}" , one2manyP);

        return one2manyP;
    }

    @ApiOperation(value = "Deletes the One2manyP instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOne2manyP(@PathVariable("id") String id) {
        LOGGER.debug("Deleting One2manyP with id: {}" , id);

        One2manyP deletedOne2manyP = one2manyPService.delete(id);

        return deletedOne2manyP != null;
    }

    /**
     * @deprecated Use {@link #findOne2manyPs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of One2manyP instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<One2manyP> searchOne2manyPsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering One2manyPs list by query filter:{}", (Object) queryFilters);
        return one2manyPService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2manyP instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2manyP> findOne2manyPs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2manyPs list by filter:", query);
        return one2manyPService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2manyP instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<One2manyP> filterOne2manyPs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2manyPs list by filter", query);
        return one2manyPService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportOne2manyPs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return one2manyPService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportOne2manyPsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = One2manyP.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> one2manyPService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of One2manyP instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countOne2manyPs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting One2manyPs");
		return one2manyPService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getOne2manyPAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return one2manyPService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/many2oneCs", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the many2oneCs instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Many2oneC> findAssociatedMany2oneCs(@PathVariable("id") String id, Pageable pageable) {

        LOGGER.debug("Fetching all associated many2oneCs");
        return one2manyPService.findAssociatedMany2oneCs(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service One2manyPService instance
	 */
	protected void setOne2manyPService(One2manyPService service) {
		this.one2manyPService = service;
	}

}