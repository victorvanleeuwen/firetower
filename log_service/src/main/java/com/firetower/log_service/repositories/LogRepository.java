package com.firetower.log_service.repositories;

import com.firetower.common.Log;
import com.firetower.common.Metric;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<Log,Long> {

    Log findLogById (Long id);

    List<Log> findLogsByServer_id (Long server_id);
}
