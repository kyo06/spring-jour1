package org.formation.projet4.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FactureDto {
    private Integer id;
    private Integer idClient;
    private String libelle;
    private Double montant;
}
