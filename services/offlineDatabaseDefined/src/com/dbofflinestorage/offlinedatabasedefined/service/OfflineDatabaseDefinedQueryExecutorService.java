/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlinedatabasedefined.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportOptions;

import com.dbofflinestorage.offlinedatabasedefined.models.query.*;

public interface OfflineDatabaseDefinedQueryExecutorService {

    Page<SvHiddenFieldsResponse> executeSV_HiddenFields(Pageable pageable);

    void exportSV_HiddenFields(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream);

}