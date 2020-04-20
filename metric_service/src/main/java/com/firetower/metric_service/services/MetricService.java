package com.firetower.metric_service.services;

import com.firetower.metric_service.common.models.Metric;
import com.firetower.metric_service.repositories.MetricRepository;
import org.springframework.stereotype.Service;

@Service
public class MetricService {

    private final MetricRepository metricRepository;

    public MetricService(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }


    public Iterable<Metric> allmetrics(){
        return metricRepository.findAll();
    }

    public Iterable<Metric> findMetricsByServer(Long id){
        return metricRepository.findMetricsByServer_id(id);
    }
    public Metric findMetricById(Long id){
        return metricRepository.findMetricById(id);
    }

    public Metric newMetric(Metric metric){
          return metricRepository.save(metric);
    }

}
