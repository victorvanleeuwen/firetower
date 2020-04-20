package com.firetower.metric_service.common.security;



import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;


public class CustomGrantedAuthority implements GrantedAuthority,Serializable {


    private Long id;

    private String authority;

    public CustomGrantedAuthority() { }

    public CustomGrantedAuthority(String name) {
        this.authority = name;
    }

    public String getName() {
        return authority;
    }

    public void setName(String name) {
        this.authority = name;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
