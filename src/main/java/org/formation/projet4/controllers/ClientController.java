package org.formation.projet4.controllers;

import org.formation.projet4.dao.ClientInMemoryDao;
import org.formation.projet4.models.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {

        clientDto.setId(ClientInMemoryDao.clients.size() + 1);
        ClientInMemoryDao.clients.add(clientDto);

        return ResponseEntity.ok(clientDto);
    }

    // PUT /clients/{id} -> Mettre à jour un client
    @PostMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(
            @PathVariable Integer id,
            @RequestBody ClientDto clientDto) {

        clientDto.setId(id);

        ClientDto clientDtoForUpdate = ClientInMemoryDao.clients.stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElse(null);

        if(clientDtoForUpdate == null) {
            ResponseEntity.notFound().build();
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

    // GET /clients/{id}/factures/{idFacture} -> récupérer la factures de l'idFacture du client id

}
