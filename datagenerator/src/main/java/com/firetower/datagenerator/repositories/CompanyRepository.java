package com.firetower.datagenerator.repositories;


import com.firetower.common.models.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long > {
}
