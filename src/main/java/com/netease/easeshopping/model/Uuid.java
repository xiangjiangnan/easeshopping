package com.netease.easeshopping.model;

import java.io.Serializable;

public class Uuid implements Serializable {
    private Integer id;

    private String uuid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
}