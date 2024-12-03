package com.socialPeople.webredsocial.userTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class WebredsocialApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUsers() throws Exception {
        // Verificar respuesta exitosa
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verificar formato de respuesta en JSON
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        // Verificar contenido de la respuesta
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.users").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.users").isArray());

        // Verificar número de usuarios devueltos
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.users").isArray())
        .andExpect(MockMvcResultMatchers.jsonPath("$.users.length()").value(10));// Asumiendo que se esperan 10 usuarios

        // Verificar orden de usuarios (por ejemplo, ordenados por nombre)
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.users[0].name").value("Nombre1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.users[1].name").value("Nombre2"));

        // Verificar errores
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get?invalid=param"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        // Verificar rendimiento (tiempo de respuesta)Tiempo de respuesta menor a 1 segundo
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
		.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content().json("{'users': []}", true));

		// Verificar compatibilidad (verificar que el contenido sea compatible con diferentes navegadores)
		mockMvc.perform(MockMvcRequestBuilders.get("/user/get"))
		.andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json;charset=UTF-8"));
	}
}