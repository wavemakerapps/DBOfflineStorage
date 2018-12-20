/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class ViewResultsId implements Serializable {

    private BigInteger totalMarks;
    private String academicYear;
    private Integer standardId;
    private Integer studentId;
    private String studentName;
    private Integer testId;

    public BigInteger getTotalMarks() {
        return this.totalMarks;
    }

    public void setTotalMarks(BigInteger totalMarks) {
        this.totalMarks = totalMarks;
    }

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

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getTestId() {
        return this.testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ViewResults)) return false;
        final ViewResults viewResults = (ViewResults) o;
        return Objects.equals(getTotalMarks(), viewResults.getTotalMarks()) &&
                Objects.equals(getAcademicYear(), viewResults.getAcademicYear()) &&
                Objects.equals(getStandardId(), viewResults.getStandardId()) &&
                Objects.equals(getStudentId(), viewResults.getStudentId()) &&
                Objects.equals(getStudentName(), viewResults.getStudentName()) &&
                Objects.equals(getTestId(), viewResults.getTestId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotalMarks(),
                getAcademicYear(),
                getStandardId(),
                getStudentId(),
                getStudentName(),
                getTestId());
    }
}