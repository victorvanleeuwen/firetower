package com.firetower.data_generator.services;


import com.firetower.data_generator.common.models.Server;
import com.firetower.data_generator.common.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;


import java.util.ArrayList;
import java.util.List;


@Service
public class GeneratorService {

    @Autowired
    private RestTemplate restTemplate;



    public  List<Server> generateServers(Long userId, int amount) throws IOException {

        try {

            ResponseEntity<Server[]> response = restTemplate.getForEntity("http://serve-service/genernate?id="+userId+"&amount="+amount,Server[].class);
            Server[] servers = response.getBody();
            ArrayList<Server> result = new ArrayList<Server>(Arrays.asList(servers));
            return result;

        }
        catch (Exception e){

            throw e;
        }
    }

    public  List<User> generateUser(int amount) throws IOException {


        try {

            ResponseEntity<User[]> response = restTemplate.getForEntity("http://user-service/generate?amount="+amount,User[].class);
            User[] users = response.getBody();
            ArrayList<User> result = new ArrayList<User>(Arrays.asList(users));
            return result;
        }
        catch (Exception e){

            throw e;
        }
    }


}
