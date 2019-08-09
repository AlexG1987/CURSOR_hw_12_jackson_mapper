package com.cursor.hw_12_jackson_mapper.service;

import com.cursor.hw_12_jackson_mapper.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserCheckerServiceImpl implements UserCheckerService {

    private static final String FILENAME = "\\src\\main\\java\\com\\cursor\\hw_12_jackson_mapper\\userToJson.json";
    final Map<String, Boolean> homeworkToIsDone = new HashMap();

    private final List<User> userList = new ArrayList<>(Arrays.asList(
            new User("Bob", "Second", LocalDate.parse("2019-08-06"), 00002, "bobsecond@domain.com", homeworkToIsDone.put("Java Stream API", Boolean.TRUE)),
            new User("Alex", "First", LocalDate.parse("2019-07-30"), 00001, "alexfirst@domain.com", homeworkToIsDone.put("Java Collections", Boolean.FALSE)),
            new User("Jessica", "Third", LocalDate.parse("2019-08-09"), 00003, "jessicathird@domain.com", homeworkToIsDone.put("Java Spring, REST Service", Boolean.FALSE))));


    @Override
    public List<User> getUserInfo(String userEmail) {
        List<User> userNewList = userList.stream()
                .filter(user -> user.getEmail().equals(userEmail))
                .collect(Collectors.toList());
        return userNewList;
    }

    @Override
    public HttpStatus writeUserToJson(@RequestBody User user) {
        try {
            final Random random = new Random();
            int accessId = random.nextInt(10000);
            User writeToJsonUser = new User();
            writeToJsonUser.setName(user.getName());
            writeToJsonUser.setSurName(user.getSurName());
            writeToJsonUser.setLastLoginDate(user.getLastLoginDate());
            writeToJsonUser.setAccessId(accessId);
            writeToJsonUser.setEmail(user.getEmail());
            writeToJsonUser.setHomeworkToIsDone(user.getHomeworkToIsDone());
            return HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpStatus.NOT_FOUND;
    }
}



