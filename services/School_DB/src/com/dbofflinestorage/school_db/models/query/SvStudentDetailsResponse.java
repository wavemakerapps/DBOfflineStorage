/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wavemaker.commons.json.serializer.ByteArrayToStringSerializer;
import com.wavemaker.commons.json.views.JsonViews.BlobAsUrlView;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class SvStudentDetailsResponse implements Serializable {


    @ColumnAlias("STUDENT_ID")
    private Integer studentId;

    @ColumnAlias("STUDENT_NAME")
    private String studentName;

    @ColumnAlias("DATE_OF_BIRTH")
    private Date dateOfBirth;

    @ColumnAlias("FATHER_NAME")
    private String fatherName;

    @ColumnAlias("ADDRESS")
    private String address;

    @ColumnAlias("JOINING_DATE")
    private Date joiningDate;

        @JsonView(BlobAsUrlView.class)
    @JsonSerialize(using = ByteArrayToStringSerializer.class)
    @JsonProperty(access = Access.READ_ONLY)
    @ColumnAlias("PROFILE_PIC")
    private byte[] profilePic;

    @ColumnAlias("STATUS")
    private String status;

    @ColumnAlias("CONTACT_NUMBER")
    private String contactNumber;

    @ColumnAlias("GENDER")
    private String gender;

    @ColumnAlias("STUDENT_IDENTIFICATION_ID")
    private Integer studentIdentificationId;

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

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJoiningDate() {
        return this.joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public byte[] getProfilePic() {
        return this.profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getStudentIdentificationId() {
        return this.studentIdentificationId;
    }

    public void setStudentIdentificationId(Integer studentIdentificationId) {
        this.studentIdentificationId = studentIdentificationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SvStudentDetailsResponse)) return false;
        final SvStudentDetailsResponse svStudentDetailsResponse = (SvStudentDetailsResponse) o;
        return Objects.equals(getStudentId(), svStudentDetailsResponse.getStudentId()) &&
                Objects.equals(getStudentName(), svStudentDetailsResponse.getStudentName()) &&
                Objects.equals(getDateOfBirth(), svStudentDetailsResponse.getDateOfBirth()) &&
                Objects.equals(getFatherName(), svStudentDetailsResponse.getFatherName()) &&
                Objects.equals(getAddress(), svStudentDetailsResponse.getAddress()) &&
                Objects.equals(getJoiningDate(), svStudentDetailsResponse.getJoiningDate()) &&
                Objects.equals(getProfilePic(), svStudentDetailsResponse.getProfilePic()) &&
                Objects.equals(getStatus(), svStudentDetailsResponse.getStatus()) &&
                Objects.equals(getContactNumber(), svStudentDetailsResponse.getContactNumber()) &&
                Objects.equals(getGender(), svStudentDetailsResponse.getGender()) &&
                Objects.equals(getStudentIdentificationId(), svStudentDetailsResponse.getStudentIdentificationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(),
                getStudentName(),
                getDateOfBirth(),
                getFatherName(),
                getAddress(),
                getJoiningDate(),
                getProfilePic(),
                getStatus(),
                getContactNumber(),
                getGender(),
                getStudentIdentificationId());
    }
}