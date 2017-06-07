package cc.youdw.controller;

import cc.youdw.entity.User;
import cc.youdw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * Created by east on 16/9/20.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUsers",method = RequestMethod.GET)
    public Object getUser(){
        return userService.getUsers();
    }

    @RequestMapping("/{userId}")
    public User findOneUser(@PathVariable Integer userId){
        return userService.findOne(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User save(User user){
        return userService.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Object deleteOne(@RequestParam Integer userId){
        return userService.deleteOne(userId);
    }
}
