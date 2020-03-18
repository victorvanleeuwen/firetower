package com.firetower.datagenerator.repositories;


import com.firetower.common.models.MetricSet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricSetRepository extends CrudRepository<MetricSet, Long > {
}