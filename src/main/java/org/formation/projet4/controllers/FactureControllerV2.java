package org.formation.projet4.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.formation.projet4.models.FactureDto;
import org.formation.projet4.services.FactureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/factures")
@AllArgsConstructor
public class FactureControllerV2 {

    private final FactureService factureService;

    // GET /factures -> récupérer tous les factures

    @GetMapping("")
    public ResponseEntity<List<FactureDto>> getAllFactures(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        return ResponseEntity.ok(factureService.getAllFactures());
    }



    // GET /factures/{id} -> récupérer le facture id
    @GetMapping("/{id}")
    public ResponseEntity<FactureDto> getFactureById(@PathVariable Integer id) {
        FactureDto factureDto = factureService.findFactureById(id);
        if(factureDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(factureDto);
    }

    // POST /factures -> Créer un facture
    @PostMapping("")
    public ResponseEntity<FactureDto> createFacture(@RequestBody @Valid FactureDto factureDto) {
        return ResponseEntity.ok(factureService.saveFacture(factureDto));
    }

    // PUT /factures/{id} -> Mettre à jour un facture
    @PutMapping("/{id}")
    public ResponseEntity<FactureDto> updateFacture(
            @PathVariable Integer id,
            @RequestBody @Valid FactureDto factureDto) {

        FactureDto factureDtoForUpdate = factureService.updateFacture(id, factureDto);

        if(factureDtoForUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(factureDtoForUpdate);
    }


    // DELETE /factures/{id} -> Supprimer le facture id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFactureById(@PathVariable Integer id) {
        factureService.deleteFactureById(id);

        return ResponseEntity.noContent().build();
    }

}
