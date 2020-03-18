package com.firetower.common.models;



import com.firetower.common.models.enums.MetricType;
import com.firetower.common.models.enums.OperatingSystemType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    private OperatingSystemType operatingSystemType;

    private MetricType metricType;

    private Integer value;

    private Long server_id;

    public Metric(){

    }

    public Metric(Date date, OperatingSystemType operatingSystemType, MetricType metricType, Integer value, Long server_id) {
        this.date = date;
        this.operatingSystemType = operatingSystemType;
        this.metricType = metricType;
        this.value = value;
        this.server_id = server_id;
    }
}
