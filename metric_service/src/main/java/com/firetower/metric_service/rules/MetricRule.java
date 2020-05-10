package com.firetower.metric_service.rules;

import com.firetower.metric_service.common.models.Metric;

import java.util.List;

public interface MetricRule {

    public Boolean isActive();

    public Boolean check(List<Metric> history);

    public String getMessage();
}
