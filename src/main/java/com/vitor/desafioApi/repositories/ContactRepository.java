package com.vitor.desafioApi.repositories;

import com.vitor.desafioApi.model.client.Client;
import com.vitor.desafioApi.model.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
    List<Contact> findByClient(Client client);
    boolean existsByValor(String valor);
}
