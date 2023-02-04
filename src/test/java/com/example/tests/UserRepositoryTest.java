package com.example.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    UserRepository userRepository = new UserRepository();

    @Test
    public void getEmptyList(){
        assertTrue(userRepository.getUsers().isEmpty());
    }

    @Nested
    public class BeforeBlock{
        @BeforeEach
        public void settings(){
            User user = new User("l", "p");
            userRepository.addUser(user);
        }

        @Test
        public void getNotEmptyList(){
            User user = new User("l", "p");
            User user1 = new User("l1", "p1");
            User user2 = new User("l2", "p2");

            ArrayList<User> addUsers = new ArrayList<>();
            addUsers.add(user);
            addUsers.add(user1);
            addUsers.add(user2);

            userRepository.addUser(user1);
            userRepository.addUser(user2);

            assertArrayEquals(addUsers.toArray(), userRepository.getUsers().toArray());
        }

        @Test
        public void getUserByLogin(){
            assertTrue(userRepository.getUserByLogin("l").isPresent());
        }

        @Test
        public void notGetUserByLogin(){
            assertTrue(userRepository.getUserByLogin("p").isEmpty());
        }

        @Test
        public void getUserByLoginPassword(){
            assertTrue(userRepository.getUserByLoginPassword("l", "p").isPresent());
        }

        @Test
        public void getUserByLoginNotPassword(){
            assertTrue(userRepository.getUserByLoginPassword("l", "l").isEmpty());
        }

        @Test
        public void getUserByNotLoginPassword(){
            assertTrue(userRepository.getUserByLoginPassword("p", "p").isEmpty());
        }
    }
}
