package com.firetower.log_service.common.models;

import java.util.Date;


public class Alert {


    private Long id;


    private String message;


    private Date date;


    private AlertSeverity alertSeverity;


    private Long serverId;


    public Alert(String message, AlertSeverity alertSeverity, Date date, Long serverId) {
        this.message = message;
        this.alertSeverity = alertSeverity;
        this.date = date;
        this.serverId = serverId;
    }
    public Alert(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AlertSeverity getAlertSeverity() {
        return alertSeverity;
    }

    public void setAlertSeverity(AlertSeverity alertSeverity) {
        this.alertSeverity = alertSeverity;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }
}
