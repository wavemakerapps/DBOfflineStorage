/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class SvMaxfunctionResponse implements Serializable {


    @ColumnAlias("MAX(MARKS_SECURED)")
    private Short max_marksSecured_;

    public Short getMax_marksSecured_() {
        return this.max_marksSecured_;
    }

    public void setMax_marksSecured_(Short max_marksSecured_) {
        this.max_marksSecured_ = max_marksSecured_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SvMaxfunctionResponse)) return false;
        final SvMaxfunctionResponse svMaxfunctionResponse = (SvMaxfunctionResponse) o;
        return Objects.equals(getMax_marksSecured_(), svMaxfunctionResponse.getMax_marksSecured_());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMax_marksSecured_());
    }
}