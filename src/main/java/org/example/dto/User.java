package org.example.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class User {
    private String userId;
    private String name;
    private String emailId;
    private String contactNumber;

    public User(String name, String emailId, String contactNumber) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
    }
}
