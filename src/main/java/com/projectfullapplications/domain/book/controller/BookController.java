package com.projectfullapplications.domain.book.controller;

import com.projectfullapplications.domain.book.dto.BookDTO;
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
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO) {
        BookDTO bookCreated = bookService.create(bookDTO);
        return new ResponseEntity<>(bookCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() {
        List<BookDTO> allBooks = bookService.findAll();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID uuid) {
        bookService.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable("id") UUID uuid, @RequestBody Client client) {
        BookDTO updateBook = bookService.update(uuid, client);
        return new ResponseEntity<>(updateBook, HttpStatus.NO_CONTENT);
    }
}
