package com.cursor.hw_12_jackson_mapper.service;

import com.cursor.hw_12_jackson_mapper.entity.User;
import org.springframework.http.HttpStatus;

public interface UserCheckerService {

    User getUserInfo(String email);

    HttpStatus writeUserToJson(User user);

}
