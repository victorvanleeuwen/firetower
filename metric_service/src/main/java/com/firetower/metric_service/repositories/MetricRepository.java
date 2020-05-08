package com.firetower.metric_service.repositories;

import com.firetower.metric_service.common.models.Metric;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetricRepository extends CrudRepository<Metric, Long> {

    Metric findMetricById (Long id);

    List<Metric> findMetricsByServerId (Long server_id);

}
