package com.firetower.metric_service.controllers;

import com.firetower.metric_service.common.models.Metric;
import com.firetower.metric_service.common.models.MetricSet;
import com.firetower.metric_service.services.MetricService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @RequestMapping(value = RestURIConstant.newMetrics, method = RequestMethod.POST)
    public void newMetrics(@RequestBody List<MetricSet> input){
        metricService.newMetrics(input);
    }

    @RequestMapping(value = RestURIConstant.MetricsWithServers,method = RequestMethod.POST)
    public @ResponseBody List<Metric> findMetricsByServerIds(@RequestBody List<Long> values){
        return metricService.findMetricsByServerIds(values);
    }

    @RequestMapping(value = RestURIConstant.recent,method = RequestMethod.GET)
    public @ResponseBody List<Metric> findRecentMetrics(@RequestParam Long id){
        return metricService.GetMostRecentMetricsForServer(id);
    }

    @RequestMapping(value = RestURIConstant.recents,method = RequestMethod.POST)
    public @ResponseBody List<Metric> findMultipleRecentMetrics(@RequestBody List<Long> values){
        return metricService.GetMostRecentMetricsForServers(values);
    }
}
