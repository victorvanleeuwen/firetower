package com.firetower.log_service.repositories;


import com.firetower.log_service.common.models.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<Log,Long> {

    Log findLogById (Long id);

    List<Log> findLogsByServerId (Long serverId);

    List<Log> findLogsByServerIdAndAndDateAfter (Long serverId, Date date);
}
