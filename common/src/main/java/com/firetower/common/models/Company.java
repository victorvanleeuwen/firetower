package com.firetower.common.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String Name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Server> servers;

    public Company(String name) {
        Name = name;
    }

    public Company(){}


    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void addServer(Server server){
        servers.add(server);
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }
}
