package com.vitor.desafioApi.services;


import com.vitor.desafioApi.model.client.Client;
import com.vitor.desafioApi.model.contact.Contact;
import com.vitor.desafioApi.model.contact.ContactRequestDTO;
import com.vitor.desafioApi.model.contact.ContactRequestUpdateDTO;
import com.vitor.desafioApi.model.contact.ContactResponseDTO;
import com.vitor.desafioApi.repositories.ClientRepository;
import com.vitor.desafioApi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ClientRepository clientRepository;

    //CREATE
    public Contact createContact(ContactRequestDTO body){
        Contact contact = new Contact();
            Client client = clientRepository.findById(body.clientId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));

        if (contactRepository.existsByValor(body.valor())){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Já existe este contato para este cliente "));
        }

        contact.setClient(client);
        contact.setTipo(body.tipo());
        contact.setValor(body.valor());
        contact.setObservacao(body.observacao());

        return contactRepository.save(contact);
    }

    //READ ALL
    public List<ContactResponseDTO> listContacts(Client clientId) {
        List<Contact> contacts = contactRepository.findByClient(clientId);
        List<ContactResponseDTO> responseList = new ArrayList<>();

        contacts.forEach(contact -> responseList.add(new ContactResponseDTO(
                contact.getId(),
                contact.getTipo(),
                contact.getValor(),
                contact.getObservacao()
        )));

        return responseList;
    }

    // UPDATE
    public ContactResponseDTO updateContact(Integer id, ContactRequestUpdateDTO body) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado!"));

        if (body.valor().isPresent()) {
            if (clientRepository.existsByCpf(body.valor().get())) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,("Já existe este contato para este cliente "));
            }
        }

        body.tipo().ifPresent(contact::setTipo);
        body.valor().ifPresent(contact::setValor);
        body.observacao().ifPresent(contact::setObservacao);

        contactRepository.save(contact);

        return new ContactResponseDTO(
                contact.getId(),
                contact.getTipo(),
                contact.getValor(),
                contact.getObservacao()
        );
    }

    //DELETE
    public void deleteContact(Integer id) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado!"));
        contactRepository.delete(contact);
    }

}
