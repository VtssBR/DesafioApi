package com.vitor.desafioApi.controllers;

import com.vitor.desafioApi.model.client.Client;
import com.vitor.desafioApi.model.client.ClientRequestDTO;
import com.vitor.desafioApi.model.client.ClientRequestUpdateDTO;
import com.vitor.desafioApi.model.client.ClientResponseDTO;
import com.vitor.desafioApi.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody ClientRequestDTO body) {
        Client client = clientService.createClient(body);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ClientResponseDTO>> listClients() {
        List<ClientResponseDTO> clients = clientService.listClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable int id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable int id, @RequestBody ClientRequestUpdateDTO body) {
        return ResponseEntity.ok(clientService.updateClient(id, body));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<ClientResponseDTO>> queryClients(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {

        List<ClientResponseDTO> clients = clientService.queryClients(nome, cpf);
        return ResponseEntity.ok(clients);
    }
}
