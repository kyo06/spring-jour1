package org.formation.projet4.dao;

import org.formation.projet4.models.ClientDto;
import org.formation.projet4.models.FactureDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureJPADao extends CrudRepository<FactureDto, Integer> {
    FactureDto findFactureByIdAndIdClient(Integer id, Integer idClient);
}
