/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.offlineclassicdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Orders generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`orders`")
public class Orders implements Serializable {

    private Integer orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private int customerNumber;
    private LocalDateTime datetimeCol;
    private Timestamp timestampCol;
    private Customers customers;

    @Id
    @Column(name = "`orderNumber`", nullable = false, scale = 0, precision = 10)
    public Integer getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Column(name = "`orderDate`", nullable = false)
    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "`requiredDate`", nullable = false)
    public Date getRequiredDate() {
        return this.requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    @Column(name = "`shippedDate`", nullable = true)
    public Date getShippedDate() {
        return this.shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Column(name = "`status`", nullable = false, length = 15)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "`comments`", nullable = true, length = 65535)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "`customerNumber`", nullable = false, scale = 0, precision = 10)
    public int getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Column(name = "`DatetimeCol`", nullable = true)
    public LocalDateTime getDatetimeCol() {
        return this.datetimeCol;
    }

    public void setDatetimeCol(LocalDateTime datetimeCol) {
        this.datetimeCol = datetimeCol;
    }

    @Column(name = "`TimestampCol`", nullable = true)
    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`customerNumber`", referencedColumnName = "`customerNumber`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`orders_ibfk_1`"))
    @Fetch(FetchMode.JOIN)
    public Customers getCustomers() {
        return this.customers;
    }

    public void setCustomers(Customers customers) {
        if(customers != null) {
            this.customerNumber = customers.getCustomerNumber();
        }

        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        final Orders orders = (Orders) o;
        return Objects.equals(getOrderNumber(), orders.getOrderNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderNumber());
    }
}