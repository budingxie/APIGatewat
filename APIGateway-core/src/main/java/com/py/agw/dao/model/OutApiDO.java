package com.py.agw.dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/13
 */
public class OutApiDO implements Serializable {

    private Long id;

    private Date createdTime;

    private Date modifiedTime;

    private Integer version;

    private Long outId;

    private Long apiId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getOutId() {
        return outId;
    }

    public void setOutId(Long outId) {
        this.outId = outId;
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }
}
