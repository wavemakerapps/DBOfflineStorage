/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TestDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TEST_DETAILS`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_TEST_DETAILS_TEST_NAME`", columnNames = {"`TEST_NAME`"})})
public class TestDetails implements Serializable {

    private Integer testId;
    private String testName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`TEST_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getTestId() {
        return this.testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    @Column(name = "`TEST_NAME`", nullable = false, length = 255)
    public String getTestName() {
        return this.testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestDetails)) return false;
        final TestDetails testDetails = (TestDetails) o;
        return Objects.equals(getTestId(), testDetails.getTestId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestId());
    }
}