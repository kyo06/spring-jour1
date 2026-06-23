package org.formation.projet4.models;

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
public class FactureDto {
    private Integer id;
    private Integer idClient;
    @NotBlank
    private String libelle;
    @Size(min = 0)
    private Double montant;
}
