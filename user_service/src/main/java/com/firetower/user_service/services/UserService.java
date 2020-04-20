package com.firetower.user_service.services;



import com.firetower.user_service.common.models.User;
import com.firetower.user_service.common.security.UserRole;
import com.firetower.user_service.common.utils.RandomUtil;
import com.firetower.user_service.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.firetower.user_service.common.security.UserRole.USER;

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

    public User UserByEmail(String email){return userRepository.findUserByEmail(email);}

    public void newUsers(List<User> users){
        userRepository.saveAll(users);
    }

    public Iterable<User> generateUsers(int amount) throws IOException {

        try {
            Stream<String> userlines = Files.lines(Paths.get("./user_service/src/main/java/com/firetower/data_generator/companynames.txt"));
            List<String> usernames = userlines.collect(Collectors.toList());

            Stream<String> passwordlines = Files.lines(Paths.get("./user_service/src/main/java/com/firetower/data_generator/passwords.txt"));
            List<String> passwords = passwordlines.collect(Collectors.toList());

            Stream<String> emaillines = Files.lines(Paths.get("./user_service/src/main/java/com/firetower/data_generator/emails.txt"));
            List<String> emails = emaillines.collect(Collectors.toList());

            List<User> users = new ArrayList<User>();
            Integer i = 0;
            while (i < amount){
                String name = (String) RandomUtil.getRandomElement(usernames);
                String email = (String) RandomUtil.getRandomElement(emails);
                String password = (String) RandomUtil.getRandomElement(passwords);


                User user = new User(name,email,password,true,true,true,true,USER.getGrantedAuthorities());
                userRepository.save(user);
                i++;
            }
            return userRepository.findAll();
        }
        catch (Exception e){
            throw new IOException(e.getMessage());
        }

    }
}
