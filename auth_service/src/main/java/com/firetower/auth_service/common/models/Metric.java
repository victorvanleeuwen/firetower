package com.firetower.auth_service.common.models;


import com.firetower.auth_service.common.enums.MetricType;
import com.firetower.auth_service.common.enums.OperatingSystemType;

import java.util.Date;

public class Metric {

    private Long id;

    private Date date;

    private OperatingSystemType operatingSystemType;

    private MetricType metricType;

    private Integer value;

    private Long server_id;

    public Metric(Date date, OperatingSystemType operatingSystemType, MetricType metricType, Integer value, Long server_id) {
        this.date = date;
        this.operatingSystemType = operatingSystemType;
        this.metricType = metricType;
        this.value = value;
        this.server_id = server_id;
    }
    public Metric(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OperatingSystemType getOperatingSystemType() {
        return operatingSystemType;
    }

    public void setOperatingSystemType(OperatingSystemType operatingSystemType) {
        this.operatingSystemType = operatingSystemType;
    }

    public MetricType getMetricType() {
        return metricType;
    }

    public void setMetricType(MetricType metricType) {
        this.metricType = metricType;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getServer_id() {
        return server_id;
    }

    public void setServer_id(Long server_id) {
        this.server_id = server_id;
    }
}
