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

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Hw12JacksonMapperApplicationTests {
    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getUserInfoTest() {
        User testUser = new User("Alex", "First", LocalDate.parse("2019-07-30"), 1, "alexfirst@domain.com", Map.of("Arrays", true, "Collections", false, "Exceptions", true));
        String url = "http://localhost:8080/?email=alexfirst@domain.com";
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(testUser, responseEntity.getBody());
    }

    @Test
    public void writeUserToJsonTest() {
        User userToJson = new User("Alex", "First", LocalDate.parse("2019-07-30"), 1, "alexfirst@domain.com",
                Map.of("Arrays", true, "Collections", false, "Exceptions", true));
        String url = "http://localhost:8080/add";
        HttpEntity<User> httpEntity = new HttpEntity<>(userToJson);
        ResponseEntity<HttpStatus> responseEntity = restTemplate.postForEntity(url, httpEntity, HttpStatus.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(HttpStatus.OK, responseEntity.getBody());
    }

}
