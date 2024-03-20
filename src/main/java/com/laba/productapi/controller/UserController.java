package com.laba.productapi.controller;

import com.laba.productapi.Dto.UserSaveRequestDto;
import com.laba.productapi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/save")
    public void save(@RequestBody UserSaveRequestDto userSaveRequestDto){
        userService.save(userSaveRequestDto);
    }
}
