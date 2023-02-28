package com.example.tests;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<String> getLogins(){
        //System.out.println(userRepository.getUsers().size());
        return userRepository.getUsers().stream().map(x -> x.getLogin()).collect(Collectors.toList());
    }

    public String addUser(String login, String password){
        if (login == null || login.isEmpty() || login.isBlank() ||
                password == null || password.isEmpty() || password.isBlank()){
            throw new IllegalArgumentException("Неверные входные данные");
        }

        if(userRepository.getUserByLogin(login).isPresent()){
            throw new UserNonUniqueException();
        }

        userRepository.addUser(new User(login, password));
        return login + password;
    }
}
