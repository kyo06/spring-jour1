package org.formation.projet4.dao;

import org.formation.projet4.models.ClientDto;
import org.formation.projet4.models.FactureDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FactureInMemoryDao {

    public static final List<FactureDto> factures = Collections.synchronizedList(new ArrayList<>(
            Arrays.asList(
                    FactureDto.builder()
                            .id(1)
                            .idClient(1)
                            .libelle("Prestation 1")
                            .montant(2000.0)
                            .build(),
                    FactureDto.builder()
                            .id(2)
                            .idClient(2)
                            .libelle("Prestation 1")
                            .montant(1000.0)
                            .build(),
                    FactureDto.builder()
                            .id(3)
                            .idClient(1)
                            .libelle("Frais de déplacement")
                            .montant(800.0)
                            .build(),
                    FactureDto.builder()
                            .id(4)
                            .idClient(3)
                            .libelle("Prestation 2")
                            .montant(1500.0)
                            .build(),
                    FactureDto.builder()
                            .id(5)
                            .idClient(2)
                            .libelle("Prestation 2")
                            .montant(1200.0)
                            .build(),
                    FactureDto.builder()
                            .id(6)
                            .idClient(1)
                            .libelle("Prestation 3")
                            .montant(1800.0)
                            .build(),
                    FactureDto.builder()
                            .id(7)
                            .idClient(2)
                            .libelle("Frais de déplacement")
                            .montant(500.0)
                            .build()
                    )
    ));
}
