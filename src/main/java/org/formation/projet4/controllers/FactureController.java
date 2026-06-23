package org.formation.projet4.controllers;

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
    }

    // GET /factures/{id} -> récupérer le facture id
    @GetMapping("/{id}")
    public ResponseEntity<FactureDto> getFactureById(@PathVariable Integer id) {
    }

    // POST /factures -> Créer un facture
    @PostMapping("")
    public ResponseEntity<FactureDto> createFacture(@RequestBody FactureDto factureDto) {
    }

    // PUT /factures/{id} -> Mettre à jour un facture
    @PostMapping("/{id}")
    public ResponseEntity<FactureDto> updateFacture(
            @PathVariable Integer id,
            @RequestBody FactureDto factureDto) {
    }


    // DELETE /factures/{id} -> Supprimer le facture id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFactureById(@PathVariable Integer id) {
    }

    // GET /factures/{id}/factures -> récupérer les factures du facture id

    // GET /factures/{id}/factures/{idFacture} -> récupérer la factures de l'idFacture du facture id

}
