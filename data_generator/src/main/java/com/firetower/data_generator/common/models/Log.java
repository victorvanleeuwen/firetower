package com.firetower.data_generator.common.models;




import com.firetower.data_generator.common.enums.OperatingSystemType;

import javax.persistence.*;
import java.util.Date;


public class Log {


    private Long id;


    private Date date;

    private OperatingSystemType operatingSystemType;

    private Long serverId;

    private String LogMessage;

    public Log(Date date, OperatingSystemType operatingSystemType, Long server_id, String logMessage){
        this.date = date;
        this.operatingSystemType = operatingSystemType;
        this.serverId = server_id;

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
}
