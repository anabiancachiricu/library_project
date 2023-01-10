package com.project.library.repository;

import com.project.library.dto.ClientDto;
import com.project.library.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByClientId(int id);
}
