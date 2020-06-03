package com.firetower.metric_service.rules;

import com.firetower.metric_service.common.models.Metric;

import java.util.List;

public class DriveUsageRule implements MetricRule {

    private Boolean active;

    public DriveUsageRule(Boolean active) {
        this.active = active;
    }

    @Override
    public Boolean isActive() {
        return active;
    }

    @Override
    public Boolean check(List<Metric> history) {

        int total = 0;
        int amount = history.size();
        int average;
        for (Metric metric: history) {
            total += metric.getValue();
        }
        average = total / amount;
        if( average >= 90){
            return false;
        }
        else return true;
    }

    @Override
    public String getMessage() {
        return "Drive usage is high.";
    }
}
