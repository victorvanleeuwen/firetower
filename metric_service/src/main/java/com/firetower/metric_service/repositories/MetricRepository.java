package com.firetower.metric_service.repositories;

import com.firetower.metric_service.common.enums.MetricType;
import com.firetower.metric_service.common.models.Metric;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MetricRepository extends CrudRepository<Metric, Long> {

    Metric findMetricById (Long id);

    List<Metric> findMetricsByServerId (Long server_id);

    List<Metric> findMetricsByMetricTypeAndDateAfterAndUsed(MetricType metricType, Date date, Boolean used);
    //Metric findTopByOrdAndServerIdAndAndMetricType(Long server_id, MetricType metricType);

    Metric findTopByMetricTypeAndServerIdOrderByDateDesc(MetricType metricType, Long server_id);


}
