package org.formation.projet4.controllers;

import jakarta.validation.Valid;
import org.formation.projet4.dao.FactureInMemoryDao;
import org.formation.projet4.models.FactureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/factures")
public class FactureController {

    // GET /factures -> récupérer tous les factures

    @GetMapping("")
    public ResponseEntity<List<FactureDto>> getAllFactures() {
        return ResponseEntity.ok(FactureInMemoryDao.factures);
    }

    // GET /factures/{id} -> récupérer le facture id
    @GetMapping("/{id}")
    public ResponseEntity<FactureDto> getFactureById(@PathVariable Integer id) {
        return FactureInMemoryDao.factures.stream()
                .filter(c -> c.getId().equals(id))
                .map(ResponseEntity::ok)
                .findFirst().orElse(ResponseEntity.notFound().build());
    }

    // POST /factures -> Créer un facture
    @PostMapping("")
    public ResponseEntity<FactureDto> createFacture(@RequestBody @Valid FactureDto factureDto) {

        factureDto.setId(FactureInMemoryDao.factures.size() + 1);
        FactureInMemoryDao.factures.add(factureDto);

        return ResponseEntity.ok(factureDto);
    }

    // PUT /factures/{id} -> Mettre à jour un facture
    @PutMapping("/{id}")
    public ResponseEntity<FactureDto> updateFacture(
            @PathVariable Integer id,
            @RequestBody @Valid FactureDto factureDto) {

        factureDto.setId(id);

        FactureDto factureDtoForUpdate = FactureInMemoryDao.factures.stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElse(null);

        if(factureDtoForUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        factureDtoForUpdate.setLibelle(factureDto.getLibelle());
        factureDtoForUpdate.setMontant(factureDto.getMontant());
        factureDtoForUpdate.setIdClient(factureDto.getIdClient());

        return ResponseEntity.ok(factureDtoForUpdate);
    }


    // DELETE /factures/{id} -> Supprimer le facture id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFactureById(@PathVariable Integer id) {

        boolean isRemoved = FactureInMemoryDao.factures.removeIf(c -> c.getId().equals(id));

        if(!isRemoved) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
