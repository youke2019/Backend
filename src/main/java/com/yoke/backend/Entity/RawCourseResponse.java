package com.yoke.backend.Entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class RawCourseResponse {
    @JSONField(name = "currentPage")
    private int page;
    @JSONField(name= "currentResult")
    private int result;
    @JSONField(name = "entityOrField")
    private boolean entityOrField;
    @JSONField(name="items")
    private List<RawCourseInfo> rawCourseInfo;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public boolean isEntityOrField() {
        return entityOrField;
    }

    public void setEntityOrField(boolean entityOrField) {
        this.entityOrField = entityOrField;
    }

    public List<RawCourseInfo> getRawCourseInfo() {
        return rawCourseInfo;
    }

    public void setRawCourseInfo(List<RawCourseInfo> rawCourseInfo) {
        this.rawCourseInfo = rawCourseInfo;
    }
}
