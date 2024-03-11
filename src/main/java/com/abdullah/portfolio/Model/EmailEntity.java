package com.abdullah.portfolio.Model;

import jakarta.persistence.*;

@Entity
public class EmailEntity {

    @Id
    private int id;

    private String username;

    private String email;

    private String message;

    public EmailEntity() {
    }

    public EmailEntity(String username, String email, String message) {
        this.username = username;
        this.email = email;
        this.message = message;
    }

    public EmailEntity(int id, String username, String email, String message) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmailEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
