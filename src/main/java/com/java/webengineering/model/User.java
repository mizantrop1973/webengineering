package com.java.webengineering.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank(message = "Name is required")
    private String name;
    @Size(min = 2, max = 10, message = "min = 2, max = 10 symbols")
    private String surname;
    @Email
    private String email;

    public User(){

    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getEmail() {return email;}

    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setEmail(String email) {this.email = email;}
}