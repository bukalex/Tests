package com.example.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void createUser(){
        User user = new User("me", "email@gmail.com");

        assertEquals(user.getLogin(), "me");
        assertEquals(user.getPassword(), "email@gmail.com");
    }

    @Test
    public void checkEmail(){
        User user = new User("me", "email@gmail.com");

        assertTrue(user.getPassword().contains("@") && user.getPassword().contains(".") &&
                user.getPassword().indexOf("@") == user.getPassword().lastIndexOf("@") &&
                user.getPassword().indexOf(".") == user.getPassword().lastIndexOf("."));
    }
    @Test
    public void compareLoginAndEmail(){
        User user = new User("me", "email@gmail.com");

        assertNotEquals(user.getPassword(), user.getLogin());
    }
}
