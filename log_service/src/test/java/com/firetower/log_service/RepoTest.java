package com.firetower.log_service;

import com.firetower.log_service.common.enums.LogType;
import com.firetower.log_service.common.enums.OperatingSystemType;
import com.firetower.log_service.common.models.Log;
import com.firetower.log_service.repositories.LogRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RepoTest {

    @Autowired
    private LogRepository repo;


    @After
    public void cleanUp(){

        repo.deleteAll();
    }

    @Test
    public void findLogByIdTest(){

        Log log = new Log(new Date(),OperatingSystemType.LINUX,100L,"test log, ignore me",LogType.SYSTEM);
        log = repo.save(log);

        Log validator = repo.findLogById(log.getId());

        assertThat(validator.getId(), equalTo(log.getId()));
    }

    @Test
    public void findLogsByServerIdTest(){

        Log log = new Log(new Date(),OperatingSystemType.LINUX,100L,"test log, ignore me",LogType.SYSTEM);
        log = repo.save(log);
        Log log1 = new Log(new Date(),OperatingSystemType.LINUX,100L,"test log, ignore me",LogType.SYSTEM);
        log1 = repo.save(log1);
        Log log2 = new Log(new Date(),OperatingSystemType.LINUX,100L,"test log, ignore me",LogType.SYSTEM);
        log2 = repo.save(log2);

        List<Log> result = repo.findLogsByServerId(100L);

        assertThat(result.size(), equalTo(3));


    }
}
