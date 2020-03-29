package com.firetower.server_service.repositories;

import com.firetower.common.Server;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerRepository extends CrudRepository<Server,Long> {

    Server findServerById (Long id);

    List<Server> findServersByUserId (Long UserId);

}
