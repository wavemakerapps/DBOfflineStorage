/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class AcademicTestSubjectsId implements Serializable {

    private String academicYear;
    private Integer subjectId;
    private Integer testId;
    private Integer standardId;

    public String getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Integer getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getTestId() {
        return this.testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
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
        if (!(o instanceof AcademicTestSubjects)) return false;
        final AcademicTestSubjects academicTestSubjects = (AcademicTestSubjects) o;
        return Objects.equals(getAcademicYear(), academicTestSubjects.getAcademicYear()) &&
                Objects.equals(getSubjectId(), academicTestSubjects.getSubjectId()) &&
                Objects.equals(getTestId(), academicTestSubjects.getTestId()) &&
                Objects.equals(getStandardId(), academicTestSubjects.getStandardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcademicYear(),
                getSubjectId(),
                getTestId(),
                getStandardId());
    }
}