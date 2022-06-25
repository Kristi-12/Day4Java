package com.example.demo.Service;

import com.example.demo.Entities.Spid;
import com.example.demo.Entities.Status;
import com.example.demo.Entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SpidS.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class SpidSTest {
    @Mock
    SpidS spidS;

    @BeforeAll
    void setUp(){
        Spid spid = new Spid();
        User user = new User();
        user.setId(1);
        user.setId(1);
        spid.setStatus(Status.PENDING);
        when(spidS.changeSpidStatus(spid)).thenReturn(spid);
        when(spidS.getSpidByUserId(user)).thenReturn(List.of(spid));

    }

    @Test
    public void testDBase(){
        Spid spid = new Spid ();
        spid.setId(1);
        spid.setStatus(Status.READY_FOR_REVIEW);
        spid.setUser(new User());
        spid.getUser().setId(1);
        spid.getUser().setName("Kent");
        spid.getUser().setEmail("Kent@gmail.com");
        assertEquals(Status.READY_FOR_REVIEW , spid.getStatus());
    }
}
