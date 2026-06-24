package org.formation.projet4.services;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.formation.projet4.dao.FactureJPADao;
import org.formation.projet4.models.FactureDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class FactureService {

    private final FactureJPADao clientJPADao;

    public List<FactureDto> getAllFactures() {
        return (List<FactureDto>) clientJPADao.findAll();
    }

    public FactureDto findFactureById(Integer id) {
        return clientJPADao.findById(id).orElse(null);
    }

    public FactureDto saveFacture(FactureDto clientDto) {
        clientDto.setId(null);
        return clientJPADao.save(clientDto);
    }

    public FactureDto updateFacture(Integer id, FactureDto clientDto) {
        clientDto.setId(id);
        return clientJPADao.save(clientDto);
    }

    public void deleteFactureById(Integer id) {
        clientJPADao.deleteById(id);
    }

    public FactureDto findFactureByIdAndIdClient(Integer id, Integer idClient) {
        return clientJPADao.findFactureByIdAndIdClient(id, idClient);
    }
}
