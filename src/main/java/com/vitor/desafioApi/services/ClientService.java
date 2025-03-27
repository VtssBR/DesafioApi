package com.vitor.desafioApi.services;

import com.vitor.desafioApi.model.client.Client;
import com.vitor.desafioApi.model.client.ClientResponseDTO;
import com.vitor.desafioApi.model.client.ClientRequestDTO;
import com.vitor.desafioApi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client createClient(ClientRequestDTO body){
        Client client = new Client();
        client.setNome(body.nome());
        client.setCpf(body.cpf());
        client.setDataNascimento(body.dataNascimento());
        client.setEndereco(body.endereco());

        return clientRepository.save(client); // Salva no banco
    }

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
}
