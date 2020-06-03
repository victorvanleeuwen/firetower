package com.firetower.log_service.services;

import com.firetower.log_service.common.models.Alert;
import com.firetower.log_service.common.models.AlertSeverity;
import com.firetower.log_service.common.models.Log;
import com.firetower.log_service.repositories.LogRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnalysisService {
    private LogRepository logRepository;
    private MessageService messageService;

    public AnalysisService(LogRepository logRepository, MessageService messageService) {
        this.logRepository = logRepository;
        this.messageService = messageService;
    }


    public void analyseLog(Log log){

        List<Log> history = logRepository.findLogsByServerIdAndAndDateAfter(log.getServerId(),getDate());

        switch (log.getLogType()){

            case SYSTEM:

                if(counter("The system shutdown",history) > 90){
                    String message = "The system is shutting down unexpectedly";
                    AlertSeverity severity = AlertSeverity.High;

                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);
                }

                if(counter("The system turned on",history) > 15){

                    String message = "The system is behaving unexpectedly";
                    AlertSeverity severity = AlertSeverity.High;

                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);
                }

                if(counter("Changes have been made to the network interface",history) > 18){

                    String message = "Increased amount of changes are made to the network interface.";
                    AlertSeverity severity = AlertSeverity.Medium;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);
                }

                if(counter("Failed to make changes to the network interface",history) > 18){

                    String message = "High amount of failed attempts to update the network interface.";
                    AlertSeverity severity = AlertSeverity.Medium;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);
                }

                if(counter("New device connected to system",history) > 18){

                    String message = "High amount of new devices are connected to the system.";
                    AlertSeverity severity = AlertSeverity.Medium;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);
                }

                if(counter("Device connected to system",history) > 18){

                    String message = "High amount of devices are connected to the system.";
                    AlertSeverity severity = AlertSeverity.Medium;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);
                }

                if(counter("Failed to communicate with device",history) > 18){

                    String message = "The system has problems communicating with a device.";
                    AlertSeverity severity = AlertSeverity.Low;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);
                }
                break;

            case SECURITY:

                if(counter("Failed login attempt on system",history) > 12){

                    String message = "To many failed login attempts.";
                    AlertSeverity severity = AlertSeverity.High;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);

                }
                if(counter("Successful login attempt on system",history) > 12){
                    String message = "High amount of successful logins.";
                    AlertSeverity severity = AlertSeverity.Low;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);

                }
                if(counter("Failed to create administrator user",history) > 12){

                    String message = "Many failed attempts to create an admin account.";
                    AlertSeverity severity = AlertSeverity.High;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);

                }
                if(counter("Successfully created administrator user",history) > 12){

                    String message = "High amount of admin accounts are created.";
                    AlertSeverity severity = AlertSeverity.High;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);

                }
                if(counter("Failed to create normal user",history) > 12){

                    String message = "High amount of failed attempts to create a user.";
                    AlertSeverity severity = AlertSeverity.High;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);

                }
                if(counter("Successfully created normal user",history) > 12){

                    String message = "High amount of users are created.";
                    AlertSeverity severity = AlertSeverity.High;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);

                }
                if(counter("Failed to  update user permissions",history) > 12){

                    String  message = "High amount of failed attempts to update user.";
                    AlertSeverity severity = AlertSeverity.High;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);

                }
                if(counter("Successfully updated user permissions",history) > 12){

                    String message = "High amount of user updates.";
                    AlertSeverity severity = AlertSeverity.High;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);

                }
                if(counter("Successfully updated security settings",history) > 12){

                    String message = "High amount of security changes.";
                    AlertSeverity severity = AlertSeverity.High;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);

                }
                if(counter("Failed to update security settings",history) > 12){

                    String message = "High amount of failed security configuration changes.";
                    AlertSeverity severity = AlertSeverity.High;
                    Alert alert = new Alert(message,severity,new Date(),log.getServerId());
                    messageService.sendAlert(alert);

                }
                break;

            case APPLICATION:

                if(counter("Application startup",history) > 18){
                    String message = "High amount of application starting.";
                    AlertSeverity  severity = AlertSeverity.Low;

                }
                if(counter("Application shutdown",history) > 18){
                    String message = "High amount of applications shutting down.";
                    AlertSeverity severity = AlertSeverity.Low;

                }
                if(counter("Application encountered critical error",history) > 18){
                    String message = "High amount of critical errors.";
                    AlertSeverity severity = AlertSeverity.High;

                }
                if(counter("Failed to update application configuration",history) > 18){
                    String message = "High amount of failed application configuration changed.";
                    AlertSeverity severity = AlertSeverity.Low;

                }
                if(counter("Successfully updated application configuration",history) > 18){
                    String message = "High amount of application configuration changes.";
                    AlertSeverity severity = AlertSeverity.Low;

                }
                if(counter("Application warning",history) > 18){
                    String message = "High amount of application warnings.";
                    AlertSeverity severity = AlertSeverity.Medium;

                }
                if(counter("Service shutdown",history) > 18){
                    String message = "High amount of services shutting down.";
                    AlertSeverity  severity = AlertSeverity.Medium;

                }
                if(counter("Service startup",history) > 18){
                    String message = "High amount of services.";
                    AlertSeverity severity = AlertSeverity.Medium;
                }
                break;
        }

    }

    private Integer counter(String logmessage, List<Log> history){
        Integer counter = 0;

        for (Log pointer: history) {
            if (pointer.getLogMessage().equals(logmessage)){
                counter ++;
            }
        }
        return counter;
    }
    private Date getDate(){

        Date output = new Date();
        output.setMinutes(output.getMinutes() - 10);
        return output;
    }

}
