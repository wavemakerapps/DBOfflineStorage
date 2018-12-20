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

public class SvLessThanResponse implements Serializable {


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
        if (!(o instanceof SvLessThanResponse)) return false;
        final SvLessThanResponse svLessThanResponse = (SvLessThanResponse) o;
        return Objects.equals(getEmployeeNumber(), svLessThanResponse.getEmployeeNumber()) &&
                Objects.equals(getLastName(), svLessThanResponse.getLastName()) &&
                Objects.equals(getFirstName(), svLessThanResponse.getFirstName()) &&
                Objects.equals(getExtension(), svLessThanResponse.getExtension()) &&
                Objects.equals(getEmail(), svLessThanResponse.getEmail()) &&
                Objects.equals(getOfficeCode(), svLessThanResponse.getOfficeCode()) &&
                Objects.equals(getReportsTo(), svLessThanResponse.getReportsTo()) &&
                Objects.equals(getJobTitle(), svLessThanResponse.getJobTitle()) &&
                Objects.equals(getDatetimeCol(), svLessThanResponse.getDatetimeCol()) &&
                Objects.equals(getTimestampCol(), svLessThanResponse.getTimestampCol());
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