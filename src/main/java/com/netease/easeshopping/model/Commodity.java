package com.netease.easeshopping.model;

import java.io.Serializable;

public class Commodity implements Serializable {
    private Integer id;

    private String cid;

    private String title;

    private String remark;

    private String picture;

    private String content;

    private Float price;

    private Integer quantity;

    private Integer isSelled;

    private Integer selledQuantity;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIsSelled() {
        return isSelled;
    }

    public void setIsSelled(Integer isSelled) {
        this.isSelled = isSelled;
    }

    public Integer getSelledQuantity() {
        return selledQuantity;
    }

    public void setSelledQuantity(Integer selledQuantity) {
        this.selledQuantity = selledQuantity;
    }
}