package com.firetower.alert_service;

import com.firetower.alert_service.common.models.Alert;
import com.firetower.alert_service.common.models.AlertSeverity;
import com.firetower.alert_service.repository.AlertRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    private AlertRepository repo;

    @After
    public void cleanUp(){

        repo.deleteAll();
    }

    @Test
    public void findAlertByIdTest(){

        Alert alert = new Alert("Test alert, ignore me",AlertSeverity.Low,new Date(),999L);
        alert = repo.save(alert);

        Alert validator = repo.findAlertById(alert.getId());
        assertThat(validator.getId(), equalTo(alert.getId()));


    }
    @Test
    public void findAlertsByServerIdTest(){

        Alert alert1 = new Alert("Test alert, ignore me",AlertSeverity.Low,new Date(),999L);
        alert1 = repo.save(alert1);
        Alert alert2 = new Alert("Test alert, ignore me",AlertSeverity.Low,new Date(),999L);
        alert2 = repo.save(alert2);
        Alert alert3 = new Alert("Test alert, ignore me",AlertSeverity.Low,new Date(),999L);
        alert3 = repo.save(alert3);

        List<Alert> result = repo.findAlertsByServerId(999L);
        assertThat(result.size(), equalTo(3));
    }
}
