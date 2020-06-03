package com.firetower.alert_service.Service;

import com.firetower.alert_service.common.models.Alert;
import com.firetower.alert_service.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {

    private AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public Alert findAlertById(Long id){
         return alertRepository.findAlertById(id);
    }

    public List<Alert> findAlertsByServerId (Long serverId){
        return alertRepository.findAlertsByServerId(serverId);

    }

    public List<Alert> findAlertsByServerIds (List<Long> integers){
        List<Alert> result = new ArrayList<Alert>();
        for (Long id: integers) {
            result.addAll(alertRepository.findAlertsByServerId(id));
        }
        return result;
    }

    public Alert newAlert(Alert newalert){
        System.out.println("New Alert!");
          return alertRepository.save(newalert);
    }

    public void deleteAlert(Long id){
        alertRepository.delete(alertRepository.findAlertById(id));
    }
    public Iterable<Alert> all(){
        return alertRepository.findAll();
    }



}
