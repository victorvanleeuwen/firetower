package com.firetower.user_service.services;



import com.firetower.user_service.common.DTO.RegisterDTO;
import com.firetower.user_service.common.DTO.UserDTO;
import com.firetower.user_service.common.exceptions.BadRequestException;
import com.firetower.user_service.common.models.User;
import com.firetower.user_service.common.utils.AuthenticationUtils;
import com.firetower.user_service.common.utils.RandomUtil;
import com.firetower.user_service.rabbitmq.RabbitMessenger;
import com.firetower.user_service.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.firetower.user_service.common.security.UserRole.USER;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Autowired
    private LogService log;

    @Autowired
    private RabbitMessenger rabbitMessenger;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    public UserDTO getUserDTO(String email){
        User user = userRepository.findUserByEmail(email);
        UserDTO result = new UserDTO(user.getId(),user.getName(),user.getEmail(),"redacted");
        return result;
    }

    public Iterable<User> alluser(){
        return userRepository.findAll();
    }

    public User UserById(Long id){
        return userRepository.findUserById(id);
    }

    public User UserByEmail(String email){return userRepository.findUserByEmail(email);}
    
    public Long idByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        return user.getId();
    }

    public String deleteUser(Long id){
        try{
            System.out.println("In delete function");
            rabbitMessenger.deleteUser(id);
            User user = userRepository.findUserById(id);
            userRepository.delete(user);
            return "succes";
        }
        catch (Exception e){
            return "failed";
        }

    }
    public String register(RegisterDTO user){
        try {
            final Pattern Email = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


            if (user == null) throw new IllegalArgumentException("The user object is not allowed to be null.");

            if (user.getEmail().isEmpty() || user.getEmail() == null) {
                throw new IllegalArgumentException("Email can`t be empty or null");
            }

            if (user.getPassword().isEmpty() || user.getPassword() == null) {
                throw new IllegalArgumentException("Password can`t be empty or null");
            }
            if (user.getPassword().length() < 8) {
                throw new BadRequestException("Password must be at least 8 characters");
            }
            if (!Email.matcher(user.getEmail()).find()) {
                throw new IllegalArgumentException("The email should be a valid email address.");
            }

            User Newuser = modelMapper.map(user,User.class);
            Newuser.setAuthorities(USER.getGrantedAuthorities());
            Newuser.setEnabled(true);
            Newuser.setAccountNonExpired(true);
            Newuser.setAccountNonLocked(true);
            Newuser.setCredentialsNonExpired(true);


            Newuser.setPassword( new AuthenticationUtils().encode(user.getPassword()));
            userRepository.save(Newuser);
            return "succes";
        }
        catch (Exception e){
            return "failed";
        }


    }

    public String newUsers(List<User> users){
        try {
            userRepository.saveAll(users);
            return "succes";
        }
        catch (Exception e){
            return "failed";
        }

    }

    public Iterable<User> generateUsers(int amount) throws IOException {

        try {
            Stream<String> userlines = Files.lines(Paths.get("./user_service/src/main/java/com/firetower/user_service/companynames.txt"));
            List<String> usernames = userlines.collect(Collectors.toList());

            Stream<String> passwordlines = Files.lines(Paths.get("./user_service/src/main/java/com/firetower/user_service/passwords.txt"));
            List<String> passwords = passwordlines.collect(Collectors.toList());

            Stream<String> emaillines = Files.lines(Paths.get("./user_service/src/main/java/com/firetower/user_service/emails.txt"));
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
            log.log(LogLevel.ERROR,"Failed to generate users");
            throw new IOException(e.getMessage());

        }

    }
}
