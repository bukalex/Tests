package com.example.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository = new UserRepository();

    @InjectMocks
    private UserService userService;

    @Test
    public void getEmptyLogins(){
        assertTrue(userService.getLogins().isEmpty());
    }

    @Test
    public void addUser(){
        userService.addUser("l", "p");
        assertEquals(1, userService.getLogins().size());
    }

    @Test
    public void addUserExist(){
        userService.addUser("l", "p");
        assertThrowsExactly(UserNonUniqueException.class, () -> userService.addUser("l", "p"));
        //Mockito.when(userService.addUser("l", "p")).thenThrow(UserNonUniqueException.class);
    }

    @Test
    public void getLogins(){
        String login1 = "l1";
        String login2 = "l2";

        List<String> addLogins = new ArrayList<>();
        addLogins.add(login1);
        addLogins.add(login2);

        userService.addUser("l1", "p1");
        userService.addUser("l2", "p2");

        assertArrayEquals(addLogins.toArray(), userService.getLogins().toArray());
        Mockito.when(userService.getLogins()).thenReturn(addLogins);
    }
}
