package com.bachelors.dni.db.repositories;

import com.bachelors.dni.db.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    List<Client> findByName(String name);
}
