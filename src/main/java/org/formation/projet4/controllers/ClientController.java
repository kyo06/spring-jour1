package org.formation.projet4.controllers;

import jakarta.validation.Valid;
import org.formation.projet4.dao.ClientInMemoryDao;
import org.formation.projet4.dao.FactureInMemoryDao;
import org.formation.projet4.exceptions.ClientNotFoundException;
import org.formation.projet4.models.ClientDto;
import org.formation.projet4.models.FactureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    // GET /clients -> récupérer tous les clients

    @GetMapping("")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return ResponseEntity.ok(ClientInMemoryDao.clients);
    }

    // GET /clients/{id} -> récupérer le client id
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Integer id) {
        return ClientInMemoryDao.clients.stream()
                .filter(c -> c.getId().equals(id))
                .map(ResponseEntity::ok)
                .findFirst().orElse(ResponseEntity.notFound().build());
    }

    // POST /clients -> Créer un client
    @PostMapping("")
    public ResponseEntity<ClientDto> createClient(@RequestBody @Valid ClientDto clientDto) {

        clientDto.setId(ClientInMemoryDao.clients.size() + 1);
        ClientInMemoryDao.clients.add(clientDto);

        return ResponseEntity.ok(clientDto);
    }

    // PUT /clients/{id} -> Mettre à jour un client
    @PostMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(
            @PathVariable Integer id,
            @RequestBody @Valid ClientDto clientDto) throws ClientNotFoundException {

        clientDto.setId(id);

        ClientDto clientDtoForUpdate = ClientInMemoryDao.clients.stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElse(null);

        if(clientDtoForUpdate == null) {
            throw new ClientNotFoundException("idClient : " + id);
            //return ResponseEntity.notFound().build();
        }

        clientDtoForUpdate.setAddress(clientDto.getAddress());
        clientDtoForUpdate.setEmail(clientDto.getEmail());
        clientDtoForUpdate.setName(clientDto.getName());
        clientDtoForUpdate.setPhone(clientDto.getPhone());
        clientDtoForUpdate.setPassword(clientDto.getPassword());

        return ResponseEntity.ok(clientDtoForUpdate);
    }


    // DELETE /clients/{id} -> Supprimer le client id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeClientById(@PathVariable Integer id) {

        boolean isRemoved = ClientInMemoryDao.clients.removeIf(c -> c.getId().equals(id));

        if(!isRemoved) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    // GET /clients/{id}/factures -> récupérer les factures du client id
    @GetMapping("/{id}/factures")
    public ResponseEntity<List<FactureDto>> getAllFacturesByIDclient(@PathVariable Integer id) {
        return ResponseEntity.ok(FactureInMemoryDao.factures.stream()
                .filter(f -> f.getIdClient().equals(id))
                .collect(Collectors.toList()));
    }

    // GET /clients/{id}/factures/{idFacture} -> récupérer la factures de l'idFacture du client id
    @GetMapping("/{id}/factures/{idFacture}")
    public ResponseEntity<FactureDto> geFactureByIDclientAndByIdFacture(
            @PathVariable Integer id,
            @PathVariable Integer idFacture
    ) {
        return FactureInMemoryDao.factures.stream()
                .filter(c -> c.getIdClient().equals(id) && c.getId().equals(idFacture))
                .map(ResponseEntity::ok)
                .findFirst().orElse(ResponseEntity.notFound().build());
    }
}
