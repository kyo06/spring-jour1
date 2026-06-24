package org.formation.projet4.dao;

import org.formation.projet4.models.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJPADao extends CrudRepository<ClientDto, Integer> {


    @Query("SELECT c FROM ClientDto c")
    Page<ClientDto> findAllClients(Pageable pageable);

    @Query("SELECT c FROM ClientDto c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<ClientDto> findByNameLike(String name, Pageable pageable);

    @Query(
            value = """
            SELECT *
            FROM client c
            WHERE c.email LIKE CONCAT('%', :email, '%')
            """,
            countQuery = """
            SELECT COUNT(*)
            FROM client c
            WHERE c.email LIKE CONCAT('%', :email, '%')
            """,
            nativeQuery = true
    )
    Page<ClientDto> findByEmailNative(String email, Pageable pageable);
}
