package com.vitor.desafioApi.controllers;

import com.vitor.desafioApi.model.client.Client;
import com.vitor.desafioApi.model.contact.ContactRequestUpdateDTO;
import com.vitor.desafioApi.model.contact.ContactResponseDTO;
import com.vitor.desafioApi.model.contact.ContactRequestDTO;
import com.vitor.desafioApi.model.contact.Contact;
import com.vitor.desafioApi.services.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {

    private final ContactService contactService;


    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/create")
    public ResponseEntity<Contact> createContact(@Valid @RequestBody ContactRequestDTO body) {
        Contact contact = contactService.createContact(body);
        return ResponseEntity.ok(contact);
    }

    @GetMapping("/list/{clienteId}")
    public ResponseEntity<List<ContactResponseDTO>> listContacts(@PathVariable Client clienteId) {
        List<ContactResponseDTO> contacts = contactService.listContacts(clienteId);
        return ResponseEntity.ok(contacts);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContactResponseDTO> updateContact(@PathVariable int id, @Valid @RequestBody ContactRequestUpdateDTO body) {
        return ResponseEntity.ok(contactService.updateContact(id, body));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable int id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

}
