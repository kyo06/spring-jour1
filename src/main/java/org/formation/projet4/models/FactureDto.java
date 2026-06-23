package org.formation.projet4.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FactureDto {
    private Integer id;
    private Integer idClient;
    @NotBlank
    private String libelle;
    @Size(min = 0)
    private Double montant;
}
