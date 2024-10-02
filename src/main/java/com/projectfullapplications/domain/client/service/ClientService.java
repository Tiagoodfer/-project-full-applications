package com.projectfullapplications.domain.client.service;

import com.projectfullapplications.domain.client.Client;
import com.projectfullapplications.domain.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client client) {
        clientRepository.save(client);
        return client;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void deleteById(UUID uuid) {
        clientRepository.deleteById(uuid);
    }

    public Client update(UUID uuid, Client updateClient) {
        Client client = clientRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setName(updateClient.getName());
        client.setEmail(updateClient.getEmail());
        return clientRepository.save(client);
    }
}
