package com.firetower.datagenerator.repositories;

import com.firetower.common.models.Server;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerRepository extends CrudRepository<Server, Long > {

    List<Server> findAllByCompanyId(Long CompanyId);
}

