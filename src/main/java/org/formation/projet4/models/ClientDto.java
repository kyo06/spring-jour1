package org.formation.projet4.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
}
