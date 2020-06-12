package com.firetower.gateway_server.common;

import org.springframework.boot.logging.LogLevel;

import java.util.Date;


public class LogObject {


    private Long id;

    private LogLevel level;

    private Date date;

    private String Message;

    public LogObject(){

    }
    public LogObject(LogLevel level, Date date, String message){

        this.level = level;
        this.date = date;
        this.Message = message;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
