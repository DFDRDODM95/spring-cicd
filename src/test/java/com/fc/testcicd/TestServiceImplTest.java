package com.fc.testcicd;


import static org.junit.jupiter.api.Assertions.*;

import com.fc.testcicd.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@ActiveProfiles("dev")
public class TestServiceImplTest  {


    @Autowired private TestService testService;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    @Test
    void checkPortSuccess(){
        assertEquals(port, "3444");
    }


    @Test
    void checkPortFail(){
        assertNotEquals(port, "8080");
    }

    @Test
    void getTestStringSuccess(){
        assertEquals(testService.getTestString(),"okay develop server 3444");
    }

    @Test
    void getTestStringFail(){
        assertNotEquals(testService.getTestString(),"okay develop server 8080");
    }
}