package com.firetower.user_service.common.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String Name;


    @JsonProperty
    private String email;

    @JsonProperty
    private String password;

    public UserDTO(){

    }


    public UserDTO(Long id,String name, String email, String password) {
        this.id = id;
        Name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
