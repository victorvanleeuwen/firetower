package com.firetower.log_service.repositories;


import com.firetower.log_service.common.models.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<Log,Long> {

    Log findLogById (Long id);

    List<Log> findLogsByServerId (Long server_id);
}
