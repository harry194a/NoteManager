package com.hb.platform.notemanager.controller;

import com.hb.platform.notemanager.domain.common.PageModel;
import com.hb.platform.notemanager.domain.user.CreateUserModel;
import com.hb.platform.notemanager.domain.user.UserModel;
import com.hb.platform.notemanager.domain.user.UpdateUserModel;
import com.hb.platform.notemanager.service.user.UserService;
import com.hb.platform.notemanager.domain.user.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/users")
@Api("UserController")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public CreateUserModel createUser(@RequestBody CreateUserModel createUserModel) {
        UserModel user = userService.addNewUser(createUserModel);
        return createUserModel;
    }

    @GetMapping
    PageModel getUser(
            @RequestParam("page")Integer page,
            @RequestParam("size")Integer size
    ) {
        return userService.getUser(PageRequest.of(page,size));
    }

    @GetMapping(path = "{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PutMapping(path = "{id}")
    public UserModel update(@PathVariable("id") Long id, @RequestBody UpdateUserModel updateUserModel) {
        return userService.update(id, updateUserModel);
    }

    @DeleteMapping(path = {"{id}"})
    public void deleteModel(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
