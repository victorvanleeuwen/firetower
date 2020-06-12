package com.firetower.monitoringservice.repositories;


import com.firetower.monitoringservice.common.models.LogObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LogObjectRepository extends CrudRepository<LogObject,Long> {


}
