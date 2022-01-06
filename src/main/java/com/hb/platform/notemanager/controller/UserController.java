package com.hb.platform.notemanager.controller;

import com.hb.platform.notemanager.model.CreateUserModel;
import com.hb.platform.notemanager.model.UpdateUserModel;
import com.hb.platform.notemanager.services.UserService;
import com.hb.platform.notemanager.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User createUser(@RequestBody CreateUserModel createUserModel) {
        User user = userService.addNewUser(createUserModel);
        return user;
    }

    @GetMapping
    List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping(path = "{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") Long id, @RequestBody UpdateUserModel updateUserModel) {
        userService.update(id, updateUserModel);
    }

    @DeleteMapping(path = {"{id}"})
    public void deleteModel(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
