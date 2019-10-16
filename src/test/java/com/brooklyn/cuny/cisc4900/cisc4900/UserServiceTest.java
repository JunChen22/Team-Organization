package com.brooklyn.cuny.cisc4900.cisc4900;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc()
//@TestPropertySource(locations = "classpath:/application-test.properties")
public class UserServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads() {
        System.out.println("at test");
    }

    public String obtainAccessToken(String username,String password){
        return "token";
    }

}
