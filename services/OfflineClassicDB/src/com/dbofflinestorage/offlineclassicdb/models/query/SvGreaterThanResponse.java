/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlineclassicdb.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class SvGreaterThanResponse implements Serializable {


    @ColumnAlias("employeeNumber")
    private Integer employeeNumber;

    @ColumnAlias("lastName")
    private String lastName;

    @ColumnAlias("firstName")
    private String firstName;

    @ColumnAlias("extension")
    private String extension;

    @ColumnAlias("email")
    private String email;

    @ColumnAlias("officeCode")
    private String officeCode;

    @ColumnAlias("reportsTo")
    private Integer reportsTo;

    @ColumnAlias("jobTitle")
    private String jobTitle;

    @ColumnAlias("DatetimeCol")
    private LocalDateTime datetimeCol;

    @ColumnAlias("TimestampCol")
    private Timestamp timestampCol;

    public Integer getEmployeeNumber() {
        return this.employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return this.officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Integer getReportsTo() {
        return this.reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDateTime getDatetimeCol() {
        return this.datetimeCol;
    }

    public void setDatetimeCol(LocalDateTime datetimeCol) {
        this.datetimeCol = datetimeCol;
    }

    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SvGreaterThanResponse)) return false;
        final SvGreaterThanResponse svGreaterThanResponse = (SvGreaterThanResponse) o;
        return Objects.equals(getEmployeeNumber(), svGreaterThanResponse.getEmployeeNumber()) &&
                Objects.equals(getLastName(), svGreaterThanResponse.getLastName()) &&
                Objects.equals(getFirstName(), svGreaterThanResponse.getFirstName()) &&
                Objects.equals(getExtension(), svGreaterThanResponse.getExtension()) &&
                Objects.equals(getEmail(), svGreaterThanResponse.getEmail()) &&
                Objects.equals(getOfficeCode(), svGreaterThanResponse.getOfficeCode()) &&
                Objects.equals(getReportsTo(), svGreaterThanResponse.getReportsTo()) &&
                Objects.equals(getJobTitle(), svGreaterThanResponse.getJobTitle()) &&
                Objects.equals(getDatetimeCol(), svGreaterThanResponse.getDatetimeCol()) &&
                Objects.equals(getTimestampCol(), svGreaterThanResponse.getTimestampCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeNumber(),
                getLastName(),
                getFirstName(),
                getExtension(),
                getEmail(),
                getOfficeCode(),
                getReportsTo(),
                getJobTitle(),
                getDatetimeCol(),
                getTimestampCol());
    }
}