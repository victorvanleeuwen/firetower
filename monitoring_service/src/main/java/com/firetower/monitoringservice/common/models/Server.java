package com.firetower.monitoringservice.common.models;


import com.firetower.monitoringservice.common.enums.OperatingSystemType;

public class Server {

    private Long id;

    private String name;


    private String ip;

    private Long userId;

    public Server(String name, String ip, Long userId, OperatingSystemType operatingSystemType, Boolean on) {
        this.name = name;
        this.ip = ip;
        this.userId = userId;
        this.operatingSystemType = operatingSystemType;
        this.on = on;
    }
    public Server(){

    }

    private OperatingSystemType operatingSystemType;


    private Boolean on;


    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperatingSystemType getOperatingSystemType() {
        return operatingSystemType;
    }

    public void setOperatingSystemType(OperatingSystemType operatingSystemType) {
        this.operatingSystemType = operatingSystemType;
    }
}
