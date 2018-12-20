/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * StudentDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`STUDENT_DETAILS`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_STUDENT_DETAILS_STUDENQs2b`", columnNames = {"`STUDENT_IDENTIFICATION_ID`"})})
public class StudentDetails implements Serializable {

    private Integer studentId;
    private String studentName;
    private Date dateOfBirth;
    private String fatherName;
    private String address;
    private Date joiningDate;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] profilePic;
    private String status;
    private String contactNumber;
    private String gender;
    private Integer studentIdentificationId;
    private StudentIdentification studentIdentification;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`STUDENT_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Column(name = "`STUDENT_NAME`", nullable = false, length = 255)
    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Column(name = "`DATE_OF_BIRTH`", nullable = false)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "`FATHER_NAME`", nullable = false, length = 255)
    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Column(name = "`ADDRESS`", nullable = false, length = 255)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "`JOINING_DATE`", nullable = false)
    public Date getJoiningDate() {
        return this.joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Column(name = "`PROFILE_PIC`", nullable = true)
    public byte[] getProfilePic() {
        return this.profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    @Column(name = "`STATUS`", nullable = false, length = 255)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "`CONTACT_NUMBER`", nullable = false, length = 10)
    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Column(name = "`GENDER`", nullable = true, length = 6)
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "`STUDENT_IDENTIFICATION_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getStudentIdentificationId() {
        return this.studentIdentificationId;
    }

    public void setStudentIdentificationId(Integer studentIdentificationId) {
        this.studentIdentificationId = studentIdentificationId;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`STUDENT_IDENTIFICATION_ID`", referencedColumnName = "`IDENTIFICATION_ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_STUDENT_DETAILS_TO_STMYTtN`"))
    @Fetch(FetchMode.JOIN)
    public StudentIdentification getStudentIdentification() {
        return this.studentIdentification;
    }

    public void setStudentIdentification(StudentIdentification studentIdentification) {
        if(studentIdentification != null) {
            this.studentIdentificationId = studentIdentification.getIdentificationId();
        }

        this.studentIdentification = studentIdentification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDetails)) return false;
        final StudentDetails studentDetails = (StudentDetails) o;
        return Objects.equals(getStudentId(), studentDetails.getStudentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId());
    }
}