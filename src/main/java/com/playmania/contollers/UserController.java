package com.playmania.contollers;


import com.playmania.entity.User;
import com.playmania.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){

        this.userService=userService;
    }
    @PostMapping("/addUser")
    public void AddUser(@RequestBody User theUser){
    userService.save(theUser);

    }
    @GetMapping()
    public List<User> getUser(){
    List<User> theusers=new ArrayList<>();
    theusers=userService.getALlUsers();
    return theusers;
    }
}
