package com.firetower.user_service.repositories;


import com.firetower.user_service.common.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findUserById (Long Id);
    User findUserByEmail (String Email);
}
