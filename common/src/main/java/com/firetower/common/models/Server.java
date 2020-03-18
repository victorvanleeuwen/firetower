package com.firetower.common.models;

import com.firetower.common.models.enums.OperatingSystemType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ip;

    private OperatingSystemType operatingSystemType;

    @OneToOne(fetch = FetchType.LAZY)
    private MetricSet latestMetrics;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "server_logs", joinColumns = @JoinColumn(name = "server_id"), inverseJoinColumns = @JoinColumn(name = "log_id"))
    private List<Log> logs;

    private Long companyId;

    private Boolean on;

    public Server(){}



    public Server(String name, String ip, OperatingSystemType operatingSystemType, Long companyId) {
        this.name = name;
        this.ip = ip;
        this.operatingSystemType = operatingSystemType;
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public OperatingSystemType getOperatingSystemType() {
        return operatingSystemType;
    }

    public MetricSet getLatestMetrics() {
        return latestMetrics;
    }

    public void setLatestMetrics(MetricSet latestMetrics) {
        this.latestMetrics = latestMetrics;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }
}
