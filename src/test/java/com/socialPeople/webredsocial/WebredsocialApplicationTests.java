package com.socialPeople.webredsocial;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WithMockUser(username = "user", password = "123", roles = "USER")
@SpringBootTest
@AutoConfigureMockMvc
public class WebredsocialApplicationTests {
    @Test
    void contextLoads() {
    }
}