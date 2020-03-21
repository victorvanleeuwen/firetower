package com.firetower.user_service.services;


import com.firetower.user_service.models.User;
import com.firetower.user_service.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> alluser(){
        return userRepository.findAll();
    }

    public User UserById(Long id){
        return userRepository.findUserById(id);
    }
}
