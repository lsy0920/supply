package com.demo.supply.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@TableName("supply")
public class Supply {
    private String id;
    private String supplyNumber;
    private String supplyName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;
    private Date searchSupplyTimeFrom;
    private Date searchSupplyTimeTo;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setSupplyNumber(String supplyNumber) {
        this.supplyNumber = supplyNumber;
    }

    public String getSupplyNumber() {
        return supplyNumber;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public Date getSearchSupplyTimeFrom() {
        return searchSupplyTimeFrom;
    }

    public void setSearchSupplyTimeFrom(Date searchSupplyTimeFrom) {
        this.searchSupplyTimeFrom = searchSupplyTimeFrom;
    }

    public Date getSearchSupplyTimeTo() {
        return searchSupplyTimeTo;
    }

    public void setSearchSupplyTimeTo(Date searchSupplyTimeTo) {
        this.searchSupplyTimeTo = searchSupplyTimeTo;
    }
}
