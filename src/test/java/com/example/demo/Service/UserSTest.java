package com.example.demo.Service;

import com.example.demo.Entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserS.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class UserSTest {


    @Mock
    UserS userS;

    @BeforeAll
    void setUp() throws Exception{
        User user = new User();
        user.setId(1);
        when(userS.getUserById(1)).thenReturn(Optional.of(user));
        when(userS.getUserById(anyInt())).thenThrow(new RuntimeException("exception"));
    }

    @Test
    public void testDatbase(){
        assertInstanceOf(User.class ,userS.getUserById(1).get());
        assertThrows(Exception.class , () -> userS.getUserById(2).get());
    }
}
