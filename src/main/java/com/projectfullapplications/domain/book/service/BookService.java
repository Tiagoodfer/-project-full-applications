package com.projectfullapplications.domain.book.service;

import com.projectfullapplications.domain.book.Book;
import com.projectfullapplications.domain.book.dto.BookDTO;
import com.projectfullapplications.domain.book.repository.BookRepository;
import com.projectfullapplications.domain.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO create(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        bookRepository.save(book);
        return convertToDTO(book);
    }

    public List<BookDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void deleteById(UUID uuid) {
        bookRepository.deleteById(uuid);
    }

    public BookDTO update(UUID uuid, Client updateClient) {
        Book book = bookRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setName(updateClient.getName());
        book.setDescription(updateClient.getEmail());
        Book updatedBook = bookRepository.save(book);
        return convertToDTO(updatedBook);
    }

    public Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setUuid(bookDTO.getUuid());
        book.setName(bookDTO.getName());
        book.setDescription(bookDTO.getDescription());
        return book;
    }

    public BookDTO convertToDTO(Book book) {
        return new BookDTO(book.getUuid(), book.getName(), book.getDescription());
    }
}
