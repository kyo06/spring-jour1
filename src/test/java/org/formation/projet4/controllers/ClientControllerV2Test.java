package org.formation.projet4.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.formation.projet4.dao.ClientJPADao;
import org.formation.projet4.models.ClientDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
// @WebMvcTest(ClientControllerV2.class)
class ClientControllerV2Test {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientJPADao clientJPADao;

    private ObjectMapper objectMapper = new ObjectMapper();

    private ClientDto clientDto;

    @BeforeEach
    public void setUp() {
        clientDto = ClientDto.builder()
                .name("toto")
                .email("toto@toto.com")
                .password("toto654165144654654165465")
                .phone("123456789")
                .address("rue églantines")
                .build();
        clientDto = clientJPADao.save(clientDto);
    }

    @AfterEach
    public void teardown() {
        clientJPADao.delete(clientDto);
    }


    @Test
    void testGetAllClients() throws Exception {

        mockMvc.perform(get("/api/v2/clients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").value("toto"))
                .andExpect(jsonPath("$.content[0].email").value("toto@toto.com"));
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
                        post("/api/v2/clients")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(client))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("Martin"));
    }

    @Test
    void shouldDeleteClient() throws Exception {

        mockMvc.perform(delete("/api/v2/clients/1"))
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
                        put("/api/v2/clients/1")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(updated))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Nouveau Nom"))
                .andExpect(jsonPath("$.email").value("new@test.fr"));
    }

}
