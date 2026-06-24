package org.formation.projet4.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.formation.projet4.dao.FactureInMemoryDao;
import org.formation.projet4.exceptions.ClientNotFoundException;
import org.formation.projet4.models.ClientDto;
import org.formation.projet4.models.FactureDto;
import org.formation.projet4.services.ClientService;
import org.formation.projet4.services.FactureService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/clients")
@AllArgsConstructor
public class ClientControllerV2 {

    private final ClientService clientService;
    private final FactureService factureService;

    // GET /clients -> récupérer tous les clients
    // GET /clients?name=dupont -> récupérer tous les clients

    @GetMapping("")
    public ResponseEntity<Page<ClientDto>> getAllClients(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        return ResponseEntity.ok(clientService.getAllClients(name, email));
    }



    // GET /clients/{id} -> récupérer le client id
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Integer id) {
        ClientDto clientDto = clientService.findClientById(id);
        if(clientDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientDto);
    }

    // POST /clients -> Créer un client
    @PostMapping("")
    public ResponseEntity<ClientDto> createClient(@RequestBody @Valid ClientDto clientDto) {
        return ResponseEntity.ok(clientService.saveClient(clientDto));
    }

    // PUT /clients/{id} -> Mettre à jour un client
    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(
            @PathVariable Integer id,
            @RequestBody @Valid ClientDto clientDto) throws ClientNotFoundException {

        ClientDto clientDtoForUpdate = clientService.updateClient(id, clientDto);

        if(clientDtoForUpdate == null) {
            throw new ClientNotFoundException("idClient : " + id);
            //return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clientDtoForUpdate);
    }


    // DELETE /clients/{id} -> Supprimer le client id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeClientById(@PathVariable Integer id) {
        clientService.deleteClientById(id);

        return ResponseEntity.noContent().build();
    }

    // GET /clients/{id}/factures -> récupérer les factures du client id
    @GetMapping("/{id}/factures")
    public ResponseEntity<List<FactureDto>> getAllFacturesByIdClient(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.findClientById(id).getFactures());
    }

    // GET /clients/{id}/factures/{idFacture} -> récupérer la factures de l'idFacture du client id
    @GetMapping("/{id}/factures/{idFacture}")
    public ResponseEntity<FactureDto> geFactureByIdClientAndByIdFacture(
            @PathVariable Integer id,
            @PathVariable Integer idFacture
    ) {
        return ResponseEntity.ok(factureService.findFactureByIdAndIdClient(idFacture, id));
    }
}
