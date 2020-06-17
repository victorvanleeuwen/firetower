package com.firetower.user_service.controlers;

import com.firetower.user_service.common.DTO.RegisterDTO;
import com.firetower.user_service.common.DTO.UserDTO;
import com.firetower.user_service.common.models.User;
import com.firetower.user_service.services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = RestURIConstant.allUsers, method = RequestMethod.GET)
    public @ResponseBody Iterable<User> allUsers() {
        return service.alluser();
    }

    @RequestMapping(value = RestURIConstant.UserById, method = RequestMethod.GET)
    public @ResponseBody
    User getUserById(@RequestParam("id") Long id) {
        return service.UserById(id);
    }

    @RequestMapping(value = RestURIConstant.protectedtest, method = RequestMethod.GET)
    public @ResponseBody
    String test() {
        return "Hello ";
    }


    @RequestMapping(value = RestURIConstant.getId, method = RequestMethod.GET)
    public @ResponseBody
    Long getId(@RequestParam("email") String email) {
        return service.idByEmail(email);
    }

    @RequestMapping(value = RestURIConstant.currentUser, method = RequestMethod.GET)
    public @ResponseBody
    UserDTO current(Authentication authentication) {
        final org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String email = (String) auth.getPrincipal();
        return service.getUserDTO(email);
     }

    @RequestMapping(value = RestURIConstant.userByEmail, method = RequestMethod.GET)
    public @ResponseBody User getUserByCode(@RequestParam("email") String email){
        return service.UserByEmail(email);
    }

    @RequestMapping(value =RestURIConstant.newUsers ,method = RequestMethod.POST)
    public String newUsers(@RequestBody List<User> users){
         return service.newUsers(users);
    }

    @RequestMapping(value = RestURIConstant.generate,method = RequestMethod.GET)
    public @ResponseBody Iterable<User> generateUsers(@RequestParam("amount") int amount)  throws IOException {
             return service.generateUsers(amount);
    }
    @RequestMapping(value = RestURIConstant.delete, method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam("id") Long id){
        service.deleteUser(id);
    }

    @RequestMapping(value= RestURIConstant.register, method = RequestMethod.POST)
    public void register(@RequestBody RegisterDTO user){
       service.register(user);
    }
}
