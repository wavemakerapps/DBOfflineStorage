/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlinedatabasedefined;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * One2manyP generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ONE2MANY_P`")
public class One2manyP implements Serializable {

    private String pid;
    private Date dateCol;
    private Boolean booleanCol;
    private Float floatCol;
    private LocalDateTime datetimeCol;
    private Timestamp timestampCol;
    private List<Many2oneC> many2oneCs;

    @Id
    @Column(name = "`P_ID`", nullable = false, length = 255)
    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Column(name = "`DATE_COL`", nullable = true)
    public Date getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Column(name = "`BOOLEAN_COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`FLOAT_COL`", nullable = true, scale = 4, precision = 8)
    public Float getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Float floatCol) {
        this.floatCol = floatCol;
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

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "one2manyP")
    @Cascade({CascadeType.SAVE_UPDATE})
    @Fetch(FetchMode.SUBSELECT)
    public List<Many2oneC> getMany2oneCs() {
        return this.many2oneCs;
    }

    public void setMany2oneCs(List<Many2oneC> many2oneCs) {
        this.many2oneCs = many2oneCs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof One2manyP)) return false;
        final One2manyP one2manyP = (One2manyP) o;
        return Objects.equals(getPid(), one2manyP.getPid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPid());
    }
}