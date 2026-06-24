package org.formation.projet4.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class ClientDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    @Size(min = 8)
    @JsonIgnore
    private String password;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private List<FactureDto> factures = new ArrayList<>();
}
