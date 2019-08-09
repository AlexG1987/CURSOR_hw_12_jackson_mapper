package com.cursor.hw_12_jackson_mapper.controller;

import com.cursor.hw_12_jackson_mapper.entity.User;
import com.cursor.hw_12_jackson_mapper.service.UserCheckerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserCheckerController {

    @Autowired
    final UserCheckerService UserCheckerService;

    @GetMapping("/getUserInfo")
    public User getUserInfo(String userEmail) {
        return UserCheckerService.getUserInfo(userEmail);
    }

    @GetMapping("/writeUserToJson")
    public HttpStatus writeUserToJson(User user) throws Exception {
        return UserCheckerService.writeUserToJson(user);
    }

}
