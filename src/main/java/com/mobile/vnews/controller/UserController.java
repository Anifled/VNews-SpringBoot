package com.mobile.vnews.controller;

import com.mobile.vnews.module.BasicResponse;
import com.mobile.vnews.module.bean.User;
import com.mobile.vnews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */

@RestController
@RequestMapping({"/vnews"})
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BasicResponse<String> register(@RequestParam String username,
                                          @RequestParam String password,
                                          @RequestParam String telephone){
        User user = new User(username, password, telephone);
        return userService.register(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BasicResponse<User> login(@RequestParam String username,
                                       @RequestParam String password){
        return userService.login(username, password);
    }

    @RequestMapping(value = "/user/tel/{telephone}", method = RequestMethod.GET)
    public BasicResponse<String> checkPhone(@PathVariable("telephone") String telephone){
        return userService.checkPhone(telephone);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public BasicResponse<String>updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user/{ID}/image", method = RequestMethod.POST)
    public BasicResponse<String>updatePhoto(@PathVariable("ID")String ID,
                                            @RequestParam("photo") MultipartFile file){
        return userService.updatePhoto(ID, file);
    }

    @RequestMapping(value = "/user/{ID}", method = RequestMethod.GET)
    public BasicResponse<User>getUser(@PathVariable("ID") String ID){
        return userService.getUser(ID);
    }
}
