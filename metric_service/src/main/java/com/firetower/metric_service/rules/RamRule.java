package com.firetower.metric_service.rules;

import com.firetower.metric_service.common.models.Metric;

import java.util.List;

public class RamRule implements MetricRule {

    private Boolean active;

    public RamRule(Boolean active) {
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
        if( average >= 85){
            return false;
        }
        else return true;
    }

    @Override
    public String getMessage() {
        return "RAM usage is high";
    }
}
