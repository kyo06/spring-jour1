package org.formation.projet4.dao;

import org.formation.projet4.models.ClientDto;

import java.util.*;

public class ClientInMemoryDao {

    public final List<ClientDto> clients = Collections.synchronizedList(new ArrayList<>(
            Arrays.asList(
                    ClientDto.builder()
                            .id(1)
                            .name("toto")
                            .email("toto@toto.com")
                            .password("toto")
                            .phone("123456789")
                            .address("rue églantines")
                            .build(),
                    ClientDto.builder()
                            .id(2)
                            .name("tutu")
                            .email("tutu@tutu.com")
                            .password("tutu")
                            .phone("987654321")
                            .address("rue paquerêtes")
                            .build(),
                    ClientDto.builder()
                            .id(3)
                            .name("tata")
                            .email("tata@tata.com")
                            .password("tata")
                            .phone("55555555555")
                            .address("rue pissenlit")
                            .build()
                    )
    ));
}
