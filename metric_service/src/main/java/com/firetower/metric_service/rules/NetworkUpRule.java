package com.firetower.metric_service.rules;

import com.firetower.metric_service.common.models.Metric;

import java.util.List;

public class NetworkUpRule implements MetricRule {
    private Boolean active;

    public NetworkUpRule(Boolean active) {
        this.active = active;
    }

    @Override
    public Boolean isActive() {
        return null;
    }

    @Override
    public Boolean check(List<Metric> history) {
        // the history has to be filled with metrics of the same kind
        int total = 0;
        int amount = history.size();
        int average;
        for (Metric metric: history) {
            total += metric.getValue();
        }
        average = total / amount;
        if( average >= 1000){
            return false;
        }
        else return true;
    }

    @Override
    public String getMessage() {
        return "High amount of uploud network traffic";
    }
}
