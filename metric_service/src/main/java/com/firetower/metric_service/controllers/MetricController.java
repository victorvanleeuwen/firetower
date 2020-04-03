package com.firetower.metric_service.controllers;

import com.firetower.common.Metric;
import com.firetower.metric_service.services.MetricService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MetricController {

    private final MetricService metricService;

    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }


    @RequestMapping(value = RestURIConstant.all, method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Metric> allMetrics() {
        return metricService.allmetrics();
    }

    @RequestMapping(value = RestURIConstant.findById, method = RequestMethod.GET)
    public @ResponseBody Metric getMetricById(@RequestParam("id") Long id){
        return metricService.findMetricById(id);
    }


    @RequestMapping(value = RestURIConstant.findByServer, method = RequestMethod.GET)
    public @ResponseBody Iterable<Metric> getMetricByUser(@RequestParam("id") Long id){
        return metricService.findMetricsByServer(id);
    }

    @RequestMapping(value = RestURIConstant.newMetric, method = RequestMethod.POST)
    public @ResponseBody Metric newMetric(@RequestBody Metric metric){
        return metricService.newMetric(metric);
    }
}
