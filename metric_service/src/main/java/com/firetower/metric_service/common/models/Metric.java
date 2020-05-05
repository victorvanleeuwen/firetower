package com.firetower.metric_service.common.models;



import com.firetower.metric_service.common.enums.MetricType;
import com.firetower.metric_service.common.enums.OperatingSystemType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date date;

    private OperatingSystemType operatingSystemType;

    private MetricType metricType;

    private Integer value;

    @Column(nullable = false)
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
