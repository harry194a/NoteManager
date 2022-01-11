package com.hb.platform.notemanager.controller;

import com.hb.platform.notemanager.service.user.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/status")
@Api("StatusController")
public class StatusController {

    private final UserService userService;

    @Autowired
    public StatusController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{id}")
    public String check(@PathVariable Long id) {
        try {
            userService.findById(id);
        } catch (IllegalStateException edsx) {
            return "we dont have it";
        }
        return "registered";
    }
}