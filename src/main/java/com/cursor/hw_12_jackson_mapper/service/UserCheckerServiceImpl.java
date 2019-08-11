package com.cursor.hw_12_jackson_mapper.service;

import com.cursor.hw_12_jackson_mapper.entity.User;
import com.cursor.hw_12_jackson_mapper.exceptions.NotFoundExceptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class UserCheckerServiceImpl implements UserCheckerService {

    private static final String FILENAME = "target/userToJson.json";

    private final List<User> userList = new ArrayList<>(Arrays.asList(
            new User("Alex", "First", LocalDate.parse("2019-07-30"), 1, "alexfirst@domain.com",
                    Map.of("Arrays", true, "Collections", false, "Exceptions", true)),
            new User("Bob", "Second", LocalDate.parse("2019-08-06"), 2, "bobsecond@domain.com",
                    Map.of("Arrays", true, "Collections", false, "Exceptions", false)),
            new User("Jessica", "Third", LocalDate.parse("2019-08-09"), 3, "jessicathird@domain.com",
                    Map.of("Arrays", true, "Collections", true, "Exceptions", true))));


    @Override
    public User getUserInfo(String email) {
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny()
                .orElseThrow(NotFoundExceptions::new);
    }

    @Override
    public HttpStatus writeUserToJson(User user) {
        final Random random = new Random();
        int accessId = (random.nextInt(10000) + 1);
        user.setAccessId(accessId);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(FILENAME), user);
            return HttpStatus.OK;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return HttpStatus.NOT_FOUND;
    }
}



