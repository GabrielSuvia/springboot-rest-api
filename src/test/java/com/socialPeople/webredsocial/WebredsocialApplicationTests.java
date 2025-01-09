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

    @Autowired
    private MockMvc mockMvc;

 
    @Test
    public void testAllGetUser() throws Exception {
        // Verificar respuesta exitosa
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void responseJsonPath() throws Exception {
        // Verificar formato de respuesta en JSON
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
      
    }
    
    @Test
    public void responseContentExist() throws Exception {
        // Verificar contenido de la respuesta
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.users").exists())
               .andExpect(MockMvcResultMatchers.jsonPath("$.users").isArray());
    }

    @Test
    public void lengthOfUsers() throws Exception {
        // Verificar número de usuarios devueltos
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.users").isArray())
        .andExpect(MockMvcResultMatchers.jsonPath("$.users.length()").value(1));// Asumiendo que se esperan 10 usuarios
    }

    @Test
    public void verifyPropertisType() throws Exception {
        // Verificar orden de usuarios (por ejemplo, ordenados por nombre)
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.users[0].name").value("jose"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.users[0].email").isString())
				.andExpect(MockMvcResultMatchers.jsonPath("$.users[0].phone").isString())
				.andExpect(MockMvcResultMatchers.jsonPath("$.users[0].password").isString())
				.andExpect(MockMvcResultMatchers.jsonPath("$.users[0].country").isString())
				.andExpect(MockMvcResultMatchers.jsonPath("$.users[0].birthday").value(Matchers.matchesRegex("\\d{4}-\\d{2}-\\d{2}")));
      }

    @Test
     public void verifyException() throws Exception {
        // Verificar errores
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get?Continue"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

     @Test
      public void verifyPerformanceTime() throws Exception {
       long startTime = System.currentTimeMillis();
    mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    long endTime = System.currentTimeMillis();
    long responseTime = endTime - startTime;
    assertTrue(responseTime < 1000); // Tiempo de respuesta menor a 1 segundo
}
     @Test
      public void verifyCompatibility() throws Exception {
		// Verificar compatibilidad (verificar que el contenido sea compatible con diferentes navegadores)
		mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
		.andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json;charset=UTF-8"));
    }
}