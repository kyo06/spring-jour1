package org.formation.projet4.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "facture")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FactureDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_client", insertable = false, updatable = false)
    private Integer idClient;

    @ManyToOne
    @JoinColumn(name = "id_client") // nom de la colonne en base
    private ClientDto client;
    @NotBlank
    private String libelle;
    @Size(min = 0)
    private Double montant;
}
