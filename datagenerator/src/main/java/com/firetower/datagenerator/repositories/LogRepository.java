package com.firetower.datagenerator.repositories;


import com.firetower.common.models.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long > {
}
