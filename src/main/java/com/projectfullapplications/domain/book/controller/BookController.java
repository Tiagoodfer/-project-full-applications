package com.projectfullapplications.domain.book.controller;

import com.projectfullapplications.domain.book.Book;
import com.projectfullapplications.domain.book.service.BookService;
import com.projectfullapplications.domain.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book bookCreated = bookService.create(book);
        return new ResponseEntity<>(bookCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> allClients = bookService.findAll();
        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable("id") UUID uuid) {
        bookService.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") UUID uuid, @RequestBody Client client) {
        Book updateBook = bookService.update(uuid, client);
        return new ResponseEntity<>(updateBook, HttpStatus.NO_CONTENT);
    }

}
