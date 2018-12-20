/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class SvFullJoinResponse implements Serializable {


    @ColumnAlias("STUDENT_ID")
    private Integer studentId;

    @ColumnAlias("MARKS_SECURED")
    private Short marksSecured;

    @ColumnAlias("GRADE_ID")
    private Integer gradeId;

    @ColumnAlias("TEST_CONDUCTED_ID")
    private Integer testConductedId;

    @ColumnAlias("MAX_MARKS")
    private String maxMarks;

    @ColumnAlias("SUBJECT_ID")
    private Integer subjectId;

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Short getMarksSecured() {
        return this.marksSecured;
    }

    public void setMarksSecured(Short marksSecured) {
        this.marksSecured = marksSecured;
    }

    public Integer getGradeId() {
        return this.gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getTestConductedId() {
        return this.testConductedId;
    }

    public void setTestConductedId(Integer testConductedId) {
        this.testConductedId = testConductedId;
    }

    public String getMaxMarks() {
        return this.maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public Integer getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SvFullJoinResponse)) return false;
        final SvFullJoinResponse svFullJoinResponse = (SvFullJoinResponse) o;
        return Objects.equals(getStudentId(), svFullJoinResponse.getStudentId()) &&
                Objects.equals(getMarksSecured(), svFullJoinResponse.getMarksSecured()) &&
                Objects.equals(getGradeId(), svFullJoinResponse.getGradeId()) &&
                Objects.equals(getTestConductedId(), svFullJoinResponse.getTestConductedId()) &&
                Objects.equals(getMaxMarks(), svFullJoinResponse.getMaxMarks()) &&
                Objects.equals(getSubjectId(), svFullJoinResponse.getSubjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(),
                getMarksSecured(),
                getGradeId(),
                getTestConductedId(),
                getMaxMarks(),
                getSubjectId());
    }
}