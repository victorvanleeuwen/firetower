package com.firetower.user_service.controlers;

import com.firetower.user_service.models.User;
import com.firetower.user_service.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
        return "Hello there";
    }
}
