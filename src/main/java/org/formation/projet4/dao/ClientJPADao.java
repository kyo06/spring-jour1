package org.formation.projet4.dao;

import org.formation.projet4.models.ClientDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public interface ClientJPADao extends CrudRepository<ClientDto, Integer> {

}
