package com.firetower.metric_service.services;

import com.firetower.metric_service.common.enums.AlertSeverity;
import com.firetower.metric_service.common.enums.MetricType;
import com.firetower.metric_service.common.models.Alert;
import com.firetower.metric_service.common.models.Metric;
import com.firetower.metric_service.repositories.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnalysisService {

    private MetricRepository metricRepository;

    private MessageService messageService;


    @Autowired
    public AnalysisService(MetricRepository metricRepository, MessageService messageService) {
        this.metricRepository = metricRepository;
        this.messageService = messageService;
    }
    public void Analyse(Long serverId){

        AnalyseCpuMetric(serverId);
        AnalyseRamMetric(serverId);
        AnalyseNetworkDownMetric(serverId);
        AnalyseNetworkUpMetric(serverId);
        AnalyseHardDriveUsageMetric(serverId);
    }

    public void AnalyseCpuMetric(Long serverId){
        List<Metric> history = getHistory(MetricType.CPU,getDate());
        int average = calculateAverage(history);

        if (average >= 90){

            // generate alert.
            Alert Alert = new Alert("Cpu metric is high",AlertSeverity.High,new Date(),serverId);
            messageService.sendAlert(Alert);

        }
    }

    public void AnalyseRamMetric(Long serverId){

        List<Metric> history = getHistory(MetricType.RAM,getDate());
        int average = calculateAverage(history);

        if (average >= 90){

            Alert Alert = new Alert("RAM metric is high",AlertSeverity.High,new Date(),serverId);
            messageService.sendAlert(Alert);

        }
    }
    public void AnalyseHardDriveUsageMetric(Long serverId){
        List<Metric> history = getHistory(MetricType.HARDDRIVE_USAGE,getDate());
        int average = calculateAverage(history);

        if (average >= 90){

            Alert Alert = new Alert("Hardrive usage metric is high",AlertSeverity.Medium,new Date(),serverId);
            messageService.sendAlert(Alert);
        }

    }
    public void AnalyseNetworkUpMetric(Long serverId){
        List<Metric> history = getHistory(MetricType.NETWORK_UP,getDate());
        int average = calculateAverage(history);

        if (average >= 1100){

            Alert Alert = new Alert("network up metric is high",AlertSeverity.Low,new Date(),serverId);
            messageService.sendAlert(Alert);
        }

    }
    public void AnalyseNetworkDownMetric(Long serverId){
        List<Metric> history = getHistory(MetricType.NETWORK_DOWN,getDate());
        int average = calculateAverage(history);

        if (average >= 1100){
            Alert Alert = new Alert("network down metric is high",AlertSeverity.High,new Date(),serverId);
            messageService.sendAlert(Alert);
        }
    }

    private Date getDate(){

        Date output = new Date();
        output.setMinutes(output.getMinutes() - 10);
        return output;
    }

    private List<Metric> getHistory(MetricType metricType, Date date){
        return  metricRepository.findMetricsByMetricTypeAndDateAfter(metricType,date);
    }

    private Integer calculateAverage(List<Metric> history){
        int total = 0;
        int amount = history.size();
        int average;
        for (Metric metric: history) {
            total += metric.getValue();
        }
        average = total / amount;
        return average;
    }
}
