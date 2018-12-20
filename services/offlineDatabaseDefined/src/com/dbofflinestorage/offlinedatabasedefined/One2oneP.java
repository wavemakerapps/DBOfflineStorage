/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlinedatabasedefined;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * One2oneP generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ONE2ONE_P`")
public class One2oneP implements Serializable {

    private Integer pid;
    private Byte byteCol;
    private String stringCol;
    private Boolean booleanCol;
    private LocalDateTime datetimeCol;
    private Timestamp timestampCol;
    private One2oneC one2oneC;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`P_ID`", nullable = false, scale = 0, precision = 10)
    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Column(name = "`BYTE_COL`", nullable = true, scale = 0, precision = 3)
    public Byte getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(Byte byteCol) {
        this.byteCol = byteCol;
    }

    @Column(name = "`STRING_COL`", nullable = true, length = 50)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Column(name = "`BOOLEAN_COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`Datetime Col`", nullable = true)
    public LocalDateTime getDatetimeCol() {
        return this.datetimeCol;
    }

    public void setDatetimeCol(LocalDateTime datetimeCol) {
        this.datetimeCol = datetimeCol;
    }

    @Column(name = "`Timestamp Col`", nullable = true)
    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "one2oneP")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.JOIN)
    public One2oneC getOne2oneC() {
        return this.one2oneC;
    }

    public void setOne2oneC(One2oneC one2oneC) {
        this.one2oneC = one2oneC;
    }

    @PostPersist
    public void onPostPersist() {
        if(one2oneC != null) {
            one2oneC.setOne2oneP(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof One2oneP)) return false;
        final One2oneP one2oneP = (One2oneP) o;
        return Objects.equals(getPid(), one2oneP.getPid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPid());
    }
}