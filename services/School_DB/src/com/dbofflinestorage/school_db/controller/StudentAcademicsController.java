/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db.controller;

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

import com.dbofflinestorage.school_db.StudentAcademics;
import com.dbofflinestorage.school_db.StudentAcademicsId;
import com.dbofflinestorage.school_db.service.StudentAcademicsService;


/**
 * Controller object for domain model class StudentAcademics.
 * @see StudentAcademics
 */
@RestController("School_DB.StudentAcademicsController")
@Api(value = "StudentAcademicsController", description = "Exposes APIs to work with StudentAcademics resource.")
@RequestMapping("/School_DB/StudentAcademics")
public class StudentAcademicsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentAcademicsController.class);

    @Autowired
	@Qualifier("School_DB.StudentAcademicsService")
	private StudentAcademicsService studentAcademicsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new StudentAcademics instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StudentAcademics createStudentAcademics(@RequestBody StudentAcademics studentAcademics) {
		LOGGER.debug("Create StudentAcademics with information: {}" , studentAcademics);

		studentAcademics = studentAcademicsService.create(studentAcademics);
		LOGGER.debug("Created StudentAcademics with information: {}" , studentAcademics);

	    return studentAcademics;
	}

    @ApiOperation(value = "Returns the StudentAcademics instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StudentAcademics getStudentAcademics(@RequestParam("academicYear") String academicYear, @RequestParam("standardId") Integer standardId, @RequestParam("studentId") Integer studentId) {

        StudentAcademicsId studentacademicsId = new StudentAcademicsId();
        studentacademicsId.setAcademicYear(academicYear);
        studentacademicsId.setStandardId(standardId);
        studentacademicsId.setStudentId(studentId);

        LOGGER.debug("Getting StudentAcademics with id: {}" , studentacademicsId);
        StudentAcademics studentAcademics = studentAcademicsService.getById(studentacademicsId);
        LOGGER.debug("StudentAcademics details with id: {}" , studentAcademics);

        return studentAcademics;
    }



    @ApiOperation(value = "Updates the StudentAcademics instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StudentAcademics editStudentAcademics(@RequestParam("academicYear") String academicYear, @RequestParam("standardId") Integer standardId, @RequestParam("studentId") Integer studentId, @RequestBody StudentAcademics studentAcademics) {

        studentAcademics.setAcademicYear(academicYear);
        studentAcademics.setStandardId(standardId);
        studentAcademics.setStudentId(studentId);

        LOGGER.debug("StudentAcademics details with id is updated with: {}" , studentAcademics);

        return studentAcademicsService.update(studentAcademics);
    }


    @ApiOperation(value = "Deletes the StudentAcademics instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteStudentAcademics(@RequestParam("academicYear") String academicYear, @RequestParam("standardId") Integer standardId, @RequestParam("studentId") Integer studentId) {

        StudentAcademicsId studentacademicsId = new StudentAcademicsId();
        studentacademicsId.setAcademicYear(academicYear);
        studentacademicsId.setStandardId(standardId);
        studentacademicsId.setStudentId(studentId);

        LOGGER.debug("Deleting StudentAcademics with id: {}" , studentacademicsId);
        StudentAcademics studentAcademics = studentAcademicsService.delete(studentacademicsId);

        return studentAcademics != null;
    }


    @RequestMapping(value = "/rollNumber/{rollNumber}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching StudentAcademics with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StudentAcademics getByRollNumber(@PathVariable("rollNumber") int rollNumber) {
        LOGGER.debug("Getting StudentAcademics with uniques key RollNumber");
        return studentAcademicsService.getByRollNumber(rollNumber);
    }

    /**
     * @deprecated Use {@link #findStudentAcademics(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of StudentAcademics instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<StudentAcademics> searchStudentAcademicsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering StudentAcademics list by query filter:{}", (Object) queryFilters);
        return studentAcademicsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of StudentAcademics instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<StudentAcademics> findStudentAcademics(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering StudentAcademics list by filter:", query);
        return studentAcademicsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of StudentAcademics instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<StudentAcademics> filterStudentAcademics(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering StudentAcademics list by filter", query);
        return studentAcademicsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportStudentAcademics(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return studentAcademicsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportStudentAcademicsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = StudentAcademics.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> studentAcademicsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of StudentAcademics instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countStudentAcademics( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting StudentAcademics");
		return studentAcademicsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getStudentAcademicsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return studentAcademicsService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service StudentAcademicsService instance
	 */
	protected void setStudentAcademicsService(StudentAcademicsService service) {
		this.studentAcademicsService = service;
	}

}