package com.vitor.desafioApi.services;

import com.vitor.desafioApi.model.client.*;
import com.vitor.desafioApi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //CREATE
    public Client createClient(ClientRequestDTO body){
        if (clientRepository.existsByCpf(body.cpf())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cliente cadastrado com o CPF: ");
        }

        Client client = new Client();
        client.setNome(body.nome());
        client.setCpf(body.cpf());
        client.setDataNascimento(body.dataNascimento());
        client.setEndereco(body.endereco());

        return clientRepository.save(client); // Salva no banco
    }

    //READ ALL
    public List<ClientResponseDTO> listClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponseDTO> responseList = new ArrayList<>();

        clients.forEach(client -> responseList.add(new ClientResponseDTO(
                client.getId(),
                client.getNome(),
                client.getCpf(),
                client.getDataNascimento(),
                client.getEndereco()
        )));

        return responseList;
    }

    //READ ID
    public ClientResponseDTO getClientById(Integer id){
        Client client = clientRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado!"));
        return new ClientResponseDTO(
                client.getId(),
                client.getNome(),
                client.getCpf(),
                client.getDataNascimento(),
                client.getEndereco()
        );
    }


    // UPDATE
    public ClientResponseDTO updateClient(Integer id, ClientRequestUpdateDTO body) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));

        body.cpf().ifPresent(cpf -> {
            if (clientRepository.existsByCpf(cpf)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Já existe um cliente cadastrado com o CPF: ");
            }
        });

        body.nome().ifPresent(client::setNome);
        body.cpf().ifPresent(client::setCpf);
        body.dataNascimento().ifPresent(data -> client.setDataNascimento(LocalDate.parse(data)));
        body.endereco().ifPresent(client::setEndereco);

        clientRepository.save(client);

        return new ClientResponseDTO(
                client.getId(),
                client.getNome(),
                client.getCpf(),
                client.getDataNascimento(),
                client.getEndereco()
        );
    }

    //DELETE
    public void deleteClient(Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
        clientRepository.delete(client);
    }


}
