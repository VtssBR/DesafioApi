package com.vitor.desafioApi.repositories;

import com.vitor.desafioApi.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClientRepository extends JpaRepository<Client, Integer>{
}
