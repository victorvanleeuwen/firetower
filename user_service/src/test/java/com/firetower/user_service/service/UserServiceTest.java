package com.firetower.user_service.service;

import com.firetower.user_service.common.DTO.RegisterDTO;
import com.firetower.user_service.common.DTO.UserDTO;
import com.firetower.user_service.common.models.User;
import com.firetower.user_service.common.utils.AuthenticationUtils;
import com.firetower.user_service.repositories.UserRepository;
import com.firetower.user_service.services.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.firetower.user_service.common.security.UserRole.USER;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {


    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repo;

    @After
    public void cleanUp(){

        repo.deleteAll();
    }

    @Test
    public void registerTest(){

        RegisterDTO testing = new RegisterDTO("Pieter1","piet@home.nl","sterkPassword");
        service.register(testing);

         User validator =repo.findUserByEmail("piet@home.nl");
        assertThat(testing.getEmail(), equalTo(validator.getEmail()));

    }

    @Test
    public void idByEmailTest(){

        User target = new User("Piet","Piet@gmail.com",new AuthenticationUtils().encode("testing"),false,false,false,false,USER.getGrantedAuthorities());
        target = repo.save(target);

        Long value = service.idByEmail("Piet@gmail.com");
        assertThat(target.getId(), equalTo(value));


    }
    @Test
    public void getUserDTOTest(){

        User target = new User("Piet","Piet@gmail.com",new AuthenticationUtils().encode("testing"),false,false,false,false,USER.getGrantedAuthorities());
        target = repo.save(target);

        UserDTO value = service.getUserDTO("Piet@gmail.com");

        assertThat(value.getId(), equalTo(target.getId()));
        assertThat(value.getPassword(), equalTo("redacted"));

    }

}
