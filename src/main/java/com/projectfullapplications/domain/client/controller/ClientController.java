package com.projectfullapplications.domain.client.controller;

import com.projectfullapplications.domain.client.Client;
import com.projectfullapplications.domain.client.repository.ClientRepository;
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

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        Client createdClient = clientService.create(client);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> allClients = clientService.findAll();
        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteById(@PathVariable("id") UUID uuid) {
        clientService.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable("id") UUID uuid, @RequestBody Client client) {
        Client updateClient = clientService.update(uuid, client);
        return new ResponseEntity<>(updateClient, HttpStatus.NO_CONTENT);
    }
}
