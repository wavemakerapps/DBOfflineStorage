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
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.dbofflinestorage.offlineclassicdb.HiddenField;
import com.dbofflinestorage.offlineclassicdb.service.HiddenFieldService;


/**
 * Controller object for domain model class HiddenField.
 * @see HiddenField
 */
@RestController("OfflineClassicDB.HiddenFieldController")
@Api(value = "HiddenFieldController", description = "Exposes APIs to work with HiddenField resource.")
@RequestMapping("/OfflineClassicDB/HiddenField")
public class HiddenFieldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HiddenFieldController.class);

    @Autowired
	@Qualifier("OfflineClassicDB.HiddenFieldService")
	private HiddenFieldService hiddenFieldService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new HiddenField instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public HiddenField createHiddenField(@RequestBody HiddenField hiddenField) {
		LOGGER.debug("Create HiddenField with information: {}" , hiddenField);

		hiddenField = hiddenFieldService.create(hiddenField);
		LOGGER.debug("Created HiddenField with information: {}" , hiddenField);

	    return hiddenField;
	}

    @ApiOperation(value = "Returns the HiddenField instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public HiddenField getHiddenField(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting HiddenField with id: {}" , id);

        HiddenField foundHiddenField = hiddenFieldService.getById(id);
        LOGGER.debug("HiddenField details with id: {}" , foundHiddenField);

        return foundHiddenField;
    }

    @ApiOperation(value = "Updates the HiddenField instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public HiddenField editHiddenField(@PathVariable("id") Integer id, @RequestBody HiddenField hiddenField) {
        LOGGER.debug("Editing HiddenField with id: {}" , hiddenField.getId());

        hiddenField.setId(id);
        hiddenField = hiddenFieldService.update(hiddenField);
        LOGGER.debug("HiddenField details with id: {}" , hiddenField);

        return hiddenField;
    }

    @ApiOperation(value = "Deletes the HiddenField instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteHiddenField(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting HiddenField with id: {}" , id);

        HiddenField deletedHiddenField = hiddenFieldService.delete(id);

        return deletedHiddenField != null;
    }

    /**
     * @deprecated Use {@link #findHiddenFields(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of HiddenField instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<HiddenField> searchHiddenFieldsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering HiddenFields list by query filter:{}", (Object) queryFilters);
        return hiddenFieldService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of HiddenField instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<HiddenField> findHiddenFields(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering HiddenFields list by filter:", query);
        return hiddenFieldService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of HiddenField instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<HiddenField> filterHiddenFields(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering HiddenFields list by filter", query);
        return hiddenFieldService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportHiddenFields(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return hiddenFieldService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportHiddenFieldsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = HiddenField.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> hiddenFieldService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of HiddenField instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countHiddenFields( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting HiddenFields");
		return hiddenFieldService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getHiddenFieldAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return hiddenFieldService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service HiddenFieldService instance
	 */
	protected void setHiddenFieldService(HiddenFieldService service) {
		this.hiddenFieldService = service;
	}

}