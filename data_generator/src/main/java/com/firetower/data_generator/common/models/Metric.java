package com.firetower.data_generator.common.models;




import com.firetower.data_generator.common.enums.MetricType;
import com.firetower.data_generator.common.enums.OperatingSystemType;

import javax.persistence.*;
import java.util.Date;


public class Metric {


    private Long id;

    private Date date;

    private OperatingSystemType operatingSystemType;

    private MetricType metricType;

    private Integer value;

    private Long serverId;

    public Metric(Date date, OperatingSystemType operatingSystemType, MetricType metricType, Integer value, Long serverId) {
        this.date = date;
        this.operatingSystemType = operatingSystemType;
        this.metricType = metricType;
        this.value = value;
        this.serverId = serverId;
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

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public Long getId() {
        return id;
    }
}
