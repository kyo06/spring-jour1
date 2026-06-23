package org.formation.projet4.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {
    private Integer id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;
}
