package com.socialPeople.webredsocial;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

@WithMockUser(username = "user", password = "123", roles = "USER")
@SpringBootTest
@AutoConfigureMockMvc
public class WebredsocialApplicationTests {
    @Test
    void contextLoads() {
    }
}