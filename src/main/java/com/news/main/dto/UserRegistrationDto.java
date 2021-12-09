package com.news.main.dto;

import javax.persistence.Column;


public class UserRegistrationDto {

    @Column
    private String username;
    @Column
    private String surname;
    @Column
    private String password;
    @Column
    private String email;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String username, String surname, String password, String email) {
        this.username = username;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
