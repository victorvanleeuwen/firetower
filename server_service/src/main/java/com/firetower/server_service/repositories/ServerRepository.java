package com.firetower.server_service.repositories;

import com.firetower.common.Server;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends CrudRepository<Server,Long> {

}
