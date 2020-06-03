package com.firetower.metric_service.services;

import com.firetower.metric_service.common.enums.MetricType;
import com.firetower.metric_service.common.models.Metric;
import com.firetower.metric_service.common.models.MetricSet;
import com.firetower.metric_service.repositories.MetricRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetricService {

    private final MetricRepository metricRepository;
    private final AnalysisService analysisService;

    public MetricService(MetricRepository metricRepository, AnalysisService analysisService) {
        this.metricRepository = metricRepository;
        this.analysisService = analysisService;
    }


    public Iterable<Metric> allmetrics(){
        return metricRepository.findAll();
    }

    public Iterable<Metric> findMetricsByServer(Long id){
        return metricRepository.findMetricsByServerId(id);
    }

    public List<Metric> findMetricsByServerIds (List<Long> integers){
        List<Metric> result = new ArrayList<Metric>();
        for (Long id: integers) {
            result.addAll(metricRepository.findMetricsByServerId(id));
        }
        return result;
    }

    public Metric findMetricById(Long id){
        return metricRepository.findMetricById(id);
    }

    public Metric newMetric(Metric metric){
          return metricRepository.save(metric);
    }

    public void newMetricSet(MetricSet metricSet){
        metricRepository.save(metricSet.getCpuMetric());
        metricRepository.save(metricSet.getHarddriveUsageMetric());
        metricRepository.save(metricSet.getNetworkDownMetric());
        metricRepository.save(metricSet.getNetworkUpMetric());
        metricRepository.save(metricSet.getRamMetric());
        analysisService.Analyse(metricSet.getCpuMetric().getId());

    }

    public void newMetrics(List<MetricSet> input){

        for (MetricSet set:input) {
            newMetricSet(set);

        }

    }
    public List<Metric> GetMostRecentMetricsForServer(Long serverId){
        List<Metric> result = new ArrayList<Metric>();

        result.add(metricRepository.findTopByMetricTypeAndServerIdOrderByDateDesc(MetricType.CPU,serverId));
        result.add(metricRepository.findTopByMetricTypeAndServerIdOrderByDateDesc(MetricType.RAM,serverId));
        result.add(metricRepository.findTopByMetricTypeAndServerIdOrderByDateDesc(MetricType.NETWORK_DOWN,serverId));
        result.add(metricRepository.findTopByMetricTypeAndServerIdOrderByDateDesc(MetricType.NETWORK_UP,serverId));
        result.add(metricRepository.findTopByMetricTypeAndServerIdOrderByDateDesc(MetricType.HARDDRIVE_USAGE,serverId));
        return result;

    }
    public List<Metric> GetMostRecentMetricsForServers(List<Long> input){
        List<Metric> result = new ArrayList<Metric>();

        for (Long id:input) {
            result.addAll(GetMostRecentMetricsForServer(id));
        }
        return result;

    }

}
