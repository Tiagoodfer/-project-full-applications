package com.projectfullapplications.domain.client.service;

import com.projectfullapplications.domain.client.Client;
import com.projectfullapplications.domain.client.dto.ClientDTO;
import com.projectfullapplications.domain.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Método para criar um novo cliente
    public ClientDTO create(ClientDTO clientDTO) {
        Client client = convertToEntity(clientDTO);
        clientRepository.save(client);
        return convertToDTO(client);
    }

    // Método para buscar todos os clientes
    public List<ClientDTO> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Método para deletar cliente por ID
    public void deleteById(UUID uuid) {
        clientRepository.deleteById(uuid);
    }

    // Método para atualizar cliente
    public ClientDTO update(UUID uuid, ClientDTO clientDTO) {
        Client client = clientRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        Client updatedClient = clientRepository.save(client);
        return convertToDTO(updatedClient);
    }

    // Conversão de ClientDTO para Client (Entidade)
    public Client convertToEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setUuid(clientDTO.getUuid());
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        return client;
    }

    // Conversão de Client (Entidade) para ClientDTO
    public ClientDTO convertToDTO(Client client) {
        return new ClientDTO(client.getUuid(), client.getName(), client.getEmail());
    }
}
