package com.firetower.user_service.repository;

import com.firetower.user_service.common.models.User;
import com.firetower.user_service.common.security.UserRole;
import com.firetower.user_service.common.utils.AuthenticationUtils;
import com.firetower.user_service.repositories.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import static com.firetower.user_service.common.security.UserRole.USER;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @After
    public void cleanUp(){

        repo.deleteAll();
    }

    @Test
    public void retrieveWithEmail(){

        User target = new User("Piet","Piet@gmail.com",new AuthenticationUtils().encode("testing"),false,false,false,false,USER.getGrantedAuthorities());
        repo.save(target);

        User validator = repo.findUserByEmail("Piet@gmail.com");
        assertThat(validator.getEmail(), equalTo("Piet@gmail.com"));

    }
    @Test
    public void retrieveWithId(){

        User target = new User("Piet","Piet12@gmail.com",new AuthenticationUtils().encode("testing"),false,false,false,false,USER.getGrantedAuthorities());
        target =repo.save(target);

        User validator = repo.findUserById(target.getId());
        assertThat(validator.getId(), equalTo(target.getId()));

    }

    @Test
    public void allUsersTest(){

        User target0 = new User("Piet","Piet0@gmail.com",new AuthenticationUtils().encode("testing0"),false,false,false,false,USER.getGrantedAuthorities());
        repo.save(target0);
        User target1 = new User("Piet","Piet1@gmail.com",new AuthenticationUtils().encode("testing1"),false,false,false,false,USER.getGrantedAuthorities());
        repo.save(target1);

        Iterable<User> result = repo.findAll();

        assertNotNull(result);

    }
}
