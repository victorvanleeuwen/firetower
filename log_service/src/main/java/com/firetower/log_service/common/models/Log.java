package com.firetower.log_service.common.models;



import com.firetower.log_service.common.enums.LogType;
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
    private Long serverId;

    @Column(nullable = false)
    private String LogMessage;

    private Boolean used;

    @Column
    private LogType logType;

    public Log(Date date, OperatingSystemType operatingSystemType, Long server_id, String logMessage, LogType logType){
        this.date = date;
        this.operatingSystemType = operatingSystemType;
        this.serverId = server_id;
        this.used = false;

        LogMessage = logMessage;
        this.logType = logType;
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

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public String getLogMessage() {
        return LogMessage;
    }

    public void setLogMessage(String logMessage) {
        LogMessage = logMessage;
    }

    public LogType getLogType() {
        return logType;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Long getId() {
        return id;
    }
}
