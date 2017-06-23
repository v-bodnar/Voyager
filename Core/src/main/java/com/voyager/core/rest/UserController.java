package com.voyager.core.rest;

import com.voyager.core.services.UserService;
import com.voyager.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Vova on 6/22/2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<User> registerNewUser(@RequestBody User user){
        user = userService.registerNewUser(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

}
