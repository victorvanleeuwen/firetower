package com.firetower.user_service.common.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterDTO {


    @JsonProperty
    private String Name;


    @JsonProperty
    private String email;

    @JsonProperty
    private String password;

    public RegisterDTO(){

    }


    public RegisterDTO(String name, String email, String password) {
        Name = name;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
