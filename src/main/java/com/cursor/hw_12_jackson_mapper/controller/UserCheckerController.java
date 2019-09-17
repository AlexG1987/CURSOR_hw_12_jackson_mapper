package com.cursor.hw_12_jackson_mapper.controller;

import com.cursor.hw_12_jackson_mapper.entity.User;
import com.cursor.hw_12_jackson_mapper.service.UserCheckerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserCheckerController {

    private final UserCheckerService UserCheckerService;

    @GetMapping
    public User getUserInfo(@RequestParam String email) {
        return UserCheckerService.getUserInfo(email);
    }

    @PostMapping
    public HttpStatus writeUserToJson(@RequestBody User user) {
        return UserCheckerService.writeUserToJson(user);
    }

}
