package org.formation.projet4.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.formation.projet4.models.ClientDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGetAllClients() throws Exception {

        mockMvc.perform(get("/api/v1/clients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("toto"))
                .andExpect(jsonPath("$[0].email").value("toto@toto.com"));
    }

    @Test
    void shouldCreateClient() throws Exception {

        ClientDto client = new ClientDto();
        client.setName("Martin");
        client.setEmail("martin@test.fr");
        client.setPassword("1234146165165161");
        client.setPhone("0102030405");
        client.setAddress("Paris");

        mockMvc.perform(
                        post("/api/v1/clients")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(client))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.name").value("Martin"));
    }

    @Test
    void shouldDeleteClient() throws Exception {

        mockMvc.perform(delete("/api/v1/clients/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldUpdateClient() throws Exception {

        ClientDto updated = new ClientDto();
        updated.setName("Nouveau Nom");
        updated.setEmail("new@test.fr");
        updated.setAddress("Lyon");
        updated.setPhone("0600000000");
        updated.setPassword("secretsdqsdqsdq");

        mockMvc.perform(
                        put("/api/v1/clients/1")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(updated))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Nouveau Nom"))
                .andExpect(jsonPath("$.email").value("new@test.fr"));
    }

}
