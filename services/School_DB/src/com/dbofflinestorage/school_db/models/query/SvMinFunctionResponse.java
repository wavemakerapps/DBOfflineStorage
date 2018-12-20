/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.dbofflinestorage.school_db.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class SvMinFunctionResponse implements Serializable {


    @ColumnAlias("MIN(MARKS_SECURED)")
    private Short min_marksSecured_;

    public Short getMin_marksSecured_() {
        return this.min_marksSecured_;
    }

    public void setMin_marksSecured_(Short min_marksSecured_) {
        this.min_marksSecured_ = min_marksSecured_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SvMinFunctionResponse)) return false;
        final SvMinFunctionResponse svMinFunctionResponse = (SvMinFunctionResponse) o;
        return Objects.equals(getMin_marksSecured_(), svMinFunctionResponse.getMin_marksSecured_());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMin_marksSecured_());
    }
}