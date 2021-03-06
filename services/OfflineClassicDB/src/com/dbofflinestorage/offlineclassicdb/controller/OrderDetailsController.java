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

import com.dbofflinestorage.offlineclassicdb.OrderDetails;
import com.dbofflinestorage.offlineclassicdb.OrderDetailsId;
import com.dbofflinestorage.offlineclassicdb.service.OrderDetailsService;


/**
 * Controller object for domain model class OrderDetails.
 * @see OrderDetails
 */
@RestController("OfflineClassicDB.OrderDetailsController")
@Api(value = "OrderDetailsController", description = "Exposes APIs to work with OrderDetails resource.")
@RequestMapping("/OfflineClassicDB/OrderDetails")
public class OrderDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailsController.class);

    @Autowired
	@Qualifier("OfflineClassicDB.OrderDetailsService")
	private OrderDetailsService orderDetailsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new OrderDetails instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OrderDetails createOrderDetails(@RequestBody OrderDetails orderDetails) {
		LOGGER.debug("Create OrderDetails with information: {}" , orderDetails);

		orderDetails = orderDetailsService.create(orderDetails);
		LOGGER.debug("Created OrderDetails with information: {}" , orderDetails);

	    return orderDetails;
	}

    @ApiOperation(value = "Returns the OrderDetails instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OrderDetails getOrderDetails(@RequestParam("orderNumber") Integer orderNumber, @RequestParam("productCode") String productCode) {

        OrderDetailsId orderdetailsId = new OrderDetailsId();
        orderdetailsId.setOrderNumber(orderNumber);
        orderdetailsId.setProductCode(productCode);

        LOGGER.debug("Getting OrderDetails with id: {}" , orderdetailsId);
        OrderDetails orderDetails = orderDetailsService.getById(orderdetailsId);
        LOGGER.debug("OrderDetails details with id: {}" , orderDetails);

        return orderDetails;
    }



    @ApiOperation(value = "Updates the OrderDetails instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public OrderDetails editOrderDetails(@RequestParam("orderNumber") Integer orderNumber, @RequestParam("productCode") String productCode, @RequestBody OrderDetails orderDetails) {

        orderDetails.setOrderNumber(orderNumber);
        orderDetails.setProductCode(productCode);

        LOGGER.debug("OrderDetails details with id is updated with: {}" , orderDetails);

        return orderDetailsService.update(orderDetails);
    }


    @ApiOperation(value = "Deletes the OrderDetails instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOrderDetails(@RequestParam("orderNumber") Integer orderNumber, @RequestParam("productCode") String productCode) {

        OrderDetailsId orderdetailsId = new OrderDetailsId();
        orderdetailsId.setOrderNumber(orderNumber);
        orderdetailsId.setProductCode(productCode);

        LOGGER.debug("Deleting OrderDetails with id: {}" , orderdetailsId);
        OrderDetails orderDetails = orderDetailsService.delete(orderdetailsId);

        return orderDetails != null;
    }


    /**
     * @deprecated Use {@link #findOrderDetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of OrderDetails instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<OrderDetails> searchOrderDetailsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering OrderDetails list by query filter:{}", (Object) queryFilters);
        return orderDetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of OrderDetails instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<OrderDetails> findOrderDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering OrderDetails list by filter:", query);
        return orderDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of OrderDetails instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<OrderDetails> filterOrderDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering OrderDetails list by filter", query);
        return orderDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportOrderDetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return orderDetailsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportOrderDetailsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = OrderDetails.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> orderDetailsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of OrderDetails instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countOrderDetails( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting OrderDetails");
		return orderDetailsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getOrderDetailsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return orderDetailsService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OrderDetailsService instance
	 */
	protected void setOrderDetailsService(OrderDetailsService service) {
		this.orderDetailsService = service;
	}

}