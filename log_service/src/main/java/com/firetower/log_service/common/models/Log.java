package com.firetower.log_service.common.models;



import com.firetower.log_service.common.enums.OperatingSystemType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date date;

    private OperatingSystemType operatingSystemType;

    @Column(nullable = false)
    private Long server_id;

    @Column(nullable = false)
    private String LogMessage;

    public Log(Date date, OperatingSystemType operatingSystemType, Long server_id, String logMessage){
        this.date = date;
        this.operatingSystemType = operatingSystemType;
        this.server_id = server_id;

        LogMessage = logMessage;
    }
    public Log(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OperatingSystemType getOperatingSystemType() {
        return operatingSystemType;
    }

    public void setOperatingSystemType(OperatingSystemType operatingSystemType) {
        this.operatingSystemType = operatingSystemType;
    }

    public Long getServer_id() {
        return server_id;
    }

    public void setServer_id(Long server_id) {
        this.server_id = server_id;
    }

    public String getLogMessage() {
        return LogMessage;
    }

    public void setLogMessage(String logMessage) {
        LogMessage = logMessage;
    }
}
