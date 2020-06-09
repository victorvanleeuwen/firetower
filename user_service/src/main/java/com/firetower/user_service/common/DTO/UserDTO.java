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
}
