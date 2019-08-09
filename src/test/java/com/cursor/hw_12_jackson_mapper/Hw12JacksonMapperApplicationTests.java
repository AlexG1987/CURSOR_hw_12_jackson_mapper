package com.cursor.hw_12_jackson_mapper;

import com.cursor.hw_12_jackson_mapper.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.springframework.boot.web.servlet.server.Session.SessionTrackingMode.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Hw12JacksonMapperApplicationTests {
    private RestTemplate restTemplate;
    private static final String GETUSERINFO_URL = "http://localhost:8080/getUserInfo";
    private static final String WRITEUSER_URL = "http://localhost:8080/writeUserToJson";
    private List<User> userList;
    final Map<String, Boolean> homeworkToIsDone = new HashMap();
    private Random random = new Random();

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Test
    public void getUserInfo() {
        User testUser = new User("Alex", "First", LocalDate.parse("2019-07-30"), 00001, "alexfirst@domain.com", homeworkToIsDone.put("Java Collections", Boolean.FALSE));
        String url = URL + "/?email=alexfirst@domain.com";
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(testUser.getName(), Objects.requireNonNull(responseEntity.getBody()).getName());
        assertEquals(testUser.getSurName(), responseEntity.getBody().getSurName());
        assertEquals(testUser.getLastLoginDate(), responseEntity.getBody().getLastLoginDate());
        assertEquals(testUser.getHomeworkToIsDone(), responseEntity.getBody().getHomeworkToIsDone());
    }

    @Test
    public void testPostRequest() {
        User user = new User("Bob", "Second", LocalDate.parse("2019-08-06"), 00002, "bobsecond@domain.com";
        String url = URL + "/writeUserToJson";
        HttpEntity<User> httpEntity = new HttpEntity<>(user);
        ResponseEntity<HttpStatus> responseEntity = restTemplate.postForEntity(url, httpEntity, HttpStatus.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(HttpStatus.CREATED, responseEntity.getBody());
    }

}
