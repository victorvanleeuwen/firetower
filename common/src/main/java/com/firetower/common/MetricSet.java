package com.firetower.common;


import java.util.Date;


public class MetricSet {

    private Long id;

    private Date date;


    private Metric cpuMetric;


    private Metric ramMetric;

    private Metric networkUpMetric;


    private Metric networkDownMetric;

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