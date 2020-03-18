package com.firetower.datagenerator.repositories;


import com.firetower.common.models.Metric;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends CrudRepository<Metric, Long > {
}
