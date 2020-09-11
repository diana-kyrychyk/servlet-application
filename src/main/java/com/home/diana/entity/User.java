package com.home.diana.entity;

public class User {

    private Integer id;
    private String firstName;
    private String secondName;
    private String login;

    public User(String firstName, String secondName, String login) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
    }

    public User(Integer id, String firstName, String secondName, String login) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
