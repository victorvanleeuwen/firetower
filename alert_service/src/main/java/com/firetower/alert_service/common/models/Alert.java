package com.firetower.alert_service.common.models;

import org.checkerframework.checker.signature.qual.Identifier;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String message;

    @Column
    private Date date;

    @Column
    private AlertSeverity alertSeverity;

    @Column
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
