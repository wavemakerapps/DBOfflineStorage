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

public class SvOroperatorResponse implements Serializable {


    @ColumnAlias("officeCode")
    private String officeCode;

    @ColumnAlias("city")
    private String city;

    @ColumnAlias("phone")
    private String phone;

    @ColumnAlias("addressLine1")
    private String addressLine1;

    @ColumnAlias("addressLine2")
    private String addressLine2;

    @ColumnAlias("state")
    private String state;

    @ColumnAlias("country")
    private String country;

    @ColumnAlias("postalCode")
    private String postalCode;

    @ColumnAlias("territory")
    private String territory;

    @ColumnAlias("DatetimeCol")
    private LocalDateTime datetimeCol;

    @ColumnAlias("TimestampCol")
    private Timestamp timestampCol;

    public String getOfficeCode() {
        return this.officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTerritory() {
        return this.territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
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
        if (!(o instanceof SvOroperatorResponse)) return false;
        final SvOroperatorResponse svOroperatorResponse = (SvOroperatorResponse) o;
        return Objects.equals(getOfficeCode(), svOroperatorResponse.getOfficeCode()) &&
                Objects.equals(getCity(), svOroperatorResponse.getCity()) &&
                Objects.equals(getPhone(), svOroperatorResponse.getPhone()) &&
                Objects.equals(getAddressLine1(), svOroperatorResponse.getAddressLine1()) &&
                Objects.equals(getAddressLine2(), svOroperatorResponse.getAddressLine2()) &&
                Objects.equals(getState(), svOroperatorResponse.getState()) &&
                Objects.equals(getCountry(), svOroperatorResponse.getCountry()) &&
                Objects.equals(getPostalCode(), svOroperatorResponse.getPostalCode()) &&
                Objects.equals(getTerritory(), svOroperatorResponse.getTerritory()) &&
                Objects.equals(getDatetimeCol(), svOroperatorResponse.getDatetimeCol()) &&
                Objects.equals(getTimestampCol(), svOroperatorResponse.getTimestampCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOfficeCode(),
                getCity(),
                getPhone(),
                getAddressLine1(),
                getAddressLine2(),
                getState(),
                getCountry(),
                getPostalCode(),
                getTerritory(),
                getDatetimeCol(),
                getTimestampCol());
    }
}