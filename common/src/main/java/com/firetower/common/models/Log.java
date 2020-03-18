package com.firetower.common.models;



import com.firetower.common.models.enums.OperatingSystemType;

import javax.persistence.*;
import java.sql.Date;

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

    public Log(){

    }

    public Log(Date date, OperatingSystemType operatingSystemType, Long server_id, String logMessage) {
        this.date = date;
        this.operatingSystemType = operatingSystemType;
        this.server_id = server_id;
        LogMessage = logMessage;
    }
}

