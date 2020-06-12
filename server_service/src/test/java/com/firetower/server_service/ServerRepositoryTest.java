package com.firetower.server_service;

import com.firetower.server_service.common.enums.OperatingSystemType;
import com.firetower.server_service.common.models.Server;
import com.firetower.server_service.repositories.ServerRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ServerRepositoryTest {

    @Autowired
    private ServerRepository repo;

    @After
    public void cleanUp(){

        repo.deleteAll();
    }

    @Test
    public void findserverWithId(){

        Server testing = new Server("test","127.0.0.1",99L,OperatingSystemType.LINUX,Boolean.TRUE);
        testing = repo.save(testing);

        Server validator = repo.findServerById(testing.getId());

        assertThat(validator.getName(), equalTo("test"));


    }

    @Test
    public void findServersWithUser(){

        Server testing1 = new Server("test","127.0.0.1",99L,OperatingSystemType.LINUX,Boolean.TRUE);
        repo.save(testing1);
        Server testing2 = new Server("test","127.0.0.1",99L,OperatingSystemType.LINUX,Boolean.TRUE);
        repo.save(testing2);
        Server testing3 = new Server("test","127.0.0.1",99L,OperatingSystemType.LINUX,Boolean.TRUE);
        repo.save(testing3);
        Server testing4 = new Server("test","127.0.0.1",99L,OperatingSystemType.LINUX,Boolean.TRUE);
        repo.save(testing4);

        List<Server> results = repo.findServersByUserId(99L);

        assertThat(results.size(), equalTo(4));

    }



}
