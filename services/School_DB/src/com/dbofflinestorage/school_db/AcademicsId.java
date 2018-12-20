/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class AcademicsId implements Serializable {

    private String academicYear;
    private Integer standardId;

    public String getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Integer getStandardId() {
        return this.standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Academics)) return false;
        final Academics academics = (Academics) o;
        return Objects.equals(getAcademicYear(), academics.getAcademicYear()) &&
                Objects.equals(getStandardId(), academics.getStandardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcademicYear(),
                getStandardId());
    }
}