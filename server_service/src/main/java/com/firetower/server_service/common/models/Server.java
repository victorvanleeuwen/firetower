package com.firetower.server_service.common.models;

import com.firetower.server_service.common.enums.OperatingSystemType;

import javax.persistence.*;

@Entity
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String ip;

    @Column(nullable = false)
    private Long userId;

    @Column
    private OperatingSystemType operatingSystemType;


    @Column
    private Boolean on;

    public Server(String name, String ip, Long userId, OperatingSystemType operatingSystemType, Boolean on) {
        this.name = name;
        this.ip = ip;
        this.userId = userId;
        this.operatingSystemType = operatingSystemType;
        this.on = on;
    }
    public Server(){

    }


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
