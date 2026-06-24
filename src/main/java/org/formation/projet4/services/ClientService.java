package org.formation.projet4.services;

import lombok.AllArgsConstructor;
import org.formation.projet4.dao.ClientJPADao;
import org.formation.projet4.models.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientJPADao clientJPADao;

    public List<ClientDto> getAllClients() {
        return (List<ClientDto>) clientJPADao.findAll();
    }

    public ClientDto findClientById(Integer id) {
        return clientJPADao.findById(id).orElse(null);
    }

    public ClientDto saveClient(ClientDto clientDto) {
        clientDto.setId(null);
        return clientJPADao.save(clientDto);
    }

    public ClientDto updateClient(Integer id, ClientDto clientDto) {
        clientDto.setId(id);
        return clientJPADao.save(clientDto);
    }

    public void deleteClientById(Integer id) {
        clientJPADao.deleteById(id);
    }

}
