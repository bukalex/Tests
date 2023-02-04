package com.example.tests;

import java.util.ArrayList;
import java.util.Optional;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public Optional<User> getUserByLogin(String login){
        return users.stream().findAny().filter(x -> x.getLogin().equals(login));
    }

    public Optional<User> getUserByLoginPassword(String login, String password){
        return users.stream().findAny().filter(x -> x.getLogin().equals(login) && x.getPassword().equals(password));
    }

    public void addUser(User user){
        users.add(user);
    }
}
