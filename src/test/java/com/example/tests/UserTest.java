package com.example.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void createUser(){
        User user = new User("me", "email@gmail.com");

        assertEquals(user.getLogin(), "me");
        assertEquals(user.getEmail(), "email@gmail.com");
    }

    @Test
    public void createEmptyUser(){
        User user = new User();

        assertNotNull(user);
    }

    @Test
    public void checkEmail(){
        User user = new User("me", "email@gmail.com");

        assertTrue(user.getEmail().contains("@") && user.getEmail().contains(".") &&
                user.getEmail().indexOf("@") == user.getEmail().lastIndexOf("@") &&
                user.getEmail().indexOf(".") == user.getEmail().lastIndexOf("."));
    }

    @Test
    public void compareLoginAndEmail(){
        User user = new User("me", "email@gmail.com");

        assertNotEquals(user.getEmail(), user.getLogin());
    }
}
