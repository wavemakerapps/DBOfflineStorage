/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlineclassicdb.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class SvWhereClauseResponse implements Serializable {


    @ColumnAlias("customerNumber")
    private Integer customerNumber;

    @ColumnAlias("customerName")
    private String customerName;

    @ColumnAlias("contactLastName")
    private String contactLastName;

    @ColumnAlias("contactFirstName")
    private String contactFirstName;

    @ColumnAlias("phone")
    private String phone;

    @ColumnAlias("addressLine1")
    private String addressLine1;

    @ColumnAlias("addressLine2")
    private String addressLine2;

    @ColumnAlias("city")
    private String city;

    @ColumnAlias("state")
    private String state;

    @ColumnAlias("postalCode")
    private String postalCode;

    @ColumnAlias("country")
    private String country;

    @ColumnAlias("salesRepEmployeeNumber")
    private Integer salesRepEmployeeNumber;

    @ColumnAlias("creditLimit")
    private BigDecimal creditLimit;

    @ColumnAlias("DatetimeCol")
    private LocalDateTime datetimeCol;

    @ColumnAlias("TimestampCol")
    private Timestamp timestampCol;

    public Integer getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return this.contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return this.contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSalesRepEmployeeNumber() {
        return this.salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(Integer salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public BigDecimal getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
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
        if (!(o instanceof SvWhereClauseResponse)) return false;
        final SvWhereClauseResponse svWhereClauseResponse = (SvWhereClauseResponse) o;
        return Objects.equals(getCustomerNumber(), svWhereClauseResponse.getCustomerNumber()) &&
                Objects.equals(getCustomerName(), svWhereClauseResponse.getCustomerName()) &&
                Objects.equals(getContactLastName(), svWhereClauseResponse.getContactLastName()) &&
                Objects.equals(getContactFirstName(), svWhereClauseResponse.getContactFirstName()) &&
                Objects.equals(getPhone(), svWhereClauseResponse.getPhone()) &&
                Objects.equals(getAddressLine1(), svWhereClauseResponse.getAddressLine1()) &&
                Objects.equals(getAddressLine2(), svWhereClauseResponse.getAddressLine2()) &&
                Objects.equals(getCity(), svWhereClauseResponse.getCity()) &&
                Objects.equals(getState(), svWhereClauseResponse.getState()) &&
                Objects.equals(getPostalCode(), svWhereClauseResponse.getPostalCode()) &&
                Objects.equals(getCountry(), svWhereClauseResponse.getCountry()) &&
                Objects.equals(getSalesRepEmployeeNumber(), svWhereClauseResponse.getSalesRepEmployeeNumber()) &&
                Objects.equals(getCreditLimit(), svWhereClauseResponse.getCreditLimit()) &&
                Objects.equals(getDatetimeCol(), svWhereClauseResponse.getDatetimeCol()) &&
                Objects.equals(getTimestampCol(), svWhereClauseResponse.getTimestampCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerNumber(),
                getCustomerName(),
                getContactLastName(),
                getContactFirstName(),
                getPhone(),
                getAddressLine1(),
                getAddressLine2(),
                getCity(),
                getState(),
                getPostalCode(),
                getCountry(),
                getSalesRepEmployeeNumber(),
                getCreditLimit(),
                getDatetimeCol(),
                getTimestampCol());
    }
}