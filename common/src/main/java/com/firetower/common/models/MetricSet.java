package com.firetower.common.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MetricSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Metric cpuMetric;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Metric ramMetric;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Metric networkUpMetric;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Metric networkDownMetric;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Metric harddriveUsageMetric;

    public MetricSet(Metric cpuMetric, Metric ramMetric, Metric networkUpMetric, Metric networkDownMetric, Metric harddiskUsageMetric) {
        this.cpuMetric = cpuMetric;
        this.ramMetric = ramMetric;
        this.networkUpMetric = networkUpMetric;
        this.networkDownMetric = networkDownMetric;
        this.harddriveUsageMetric = harddiskUsageMetric;
    }
    public MetricSet(){

    }

    public Metric getCpuMetric() {
        return cpuMetric;
    }

    public Metric getRamMetric() {
        return ramMetric;
    }

    public Metric getNetworkUpMetric() {
        return networkUpMetric;
    }

    public Metric getNetworkDownMetric() {
        return networkDownMetric;
    }

    public Metric getHarddriveUsageMetric() {
        return harddriveUsageMetric;
    }
}

