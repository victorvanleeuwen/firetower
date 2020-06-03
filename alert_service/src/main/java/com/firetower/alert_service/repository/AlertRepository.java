package com.firetower.alert_service.repository;

import com.firetower.alert_service.common.models.Alert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends CrudRepository<Alert, Long> {

    Alert findAlertById (Long id);

    List<Alert> findAlertsByServerId (Long serverid);
}
