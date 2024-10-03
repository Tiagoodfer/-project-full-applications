package com.projectfullapplications.domain.client.controller;

import com.projectfullapplications.domain.client.dto.ClientDTO;
import com.projectfullapplications.domain.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Endpoint para criar um novo cliente
    @PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO) {
        ClientDTO createdClient = clientService.create(clientDTO);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    // Endpoint para buscar todos os clientes
    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<ClientDTO> allClients = clientService.findAll();
        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }

    // Endpoint para deletar cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID uuid) {
        clientService.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint para atualizar um cliente
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable("id") UUID uuid, @RequestBody ClientDTO clientDTO) {
        ClientDTO updatedClient = clientService.update(uuid, clientDTO);
        return new ResponseEntity<>(updatedClient, HttpStatus.NO_CONTENT);
    }
}
