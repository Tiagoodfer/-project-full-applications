package com.projectfullapplications.domain.book.service;

import com.projectfullapplications.domain.book.Book;
import com.projectfullapplications.domain.book.repository.BookRepository;
import com.projectfullapplications.domain.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book create(Book book) {
        bookRepository.save(book);
        return book;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void deleteById(UUID uuid) {
        bookRepository.deleteById(uuid);
    }

    public Book update(UUID uuid, Client updateClient) {
        Book book = bookRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Client not found"));
        book.setName(updateClient.getName());
        book.setDescription(updateClient.getEmail());
        return bookRepository.save(book);
    }

}
