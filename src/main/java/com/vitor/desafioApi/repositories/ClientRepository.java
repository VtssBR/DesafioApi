package com.vitor.desafioApi.repositories;

import com.vitor.desafioApi.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Integer>{
    List<Client> findByNomeOrCpf(String nome, String cpf);
    boolean existsByCpf(String cpf);
}
