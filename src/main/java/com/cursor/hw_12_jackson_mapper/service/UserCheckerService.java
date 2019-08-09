package com.cursor.hw_12_jackson_mapper.service;

import com.cursor.hw_12_jackson_mapper.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserCheckerService {

    public List<User> getUserInfo (String userInfo);

    public HttpStatus writeUserToJson (User user);

}
