package com.cursor.hw_12_jackson_mapper.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    String name;
    String surName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate lastLoginDate;
    @JsonIgnore
    int accessId;
    String email;
    Map<String, Boolean> homeworkToIsDone;

    public User(String alex, String first, LocalDate parse, int accessId, String email, Boolean java_collections) {
    }

    @Override
    public String toString(){
        return "User{" +
                "name= " + name +
                ", surname" + surName +
                ", lastLoginDate" + lastLoginDate +
                ", email" + email +
                ", homeworkToIsDone" + homeworkToIsDone +
                "}";
    }

}
