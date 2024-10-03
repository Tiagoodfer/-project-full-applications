package com.projectfullapplications.domain.booking.service;

import com.projectfullapplications.domain.booking.Booking;
import com.projectfullapplications.domain.booking.dto.BookingDTO;
import com.projectfullapplications.domain.booking.repository.BookingRepository;
import com.projectfullapplications.domain.book.Book;
import com.projectfullapplications.domain.client.Client;
import com.projectfullapplications.domain.client.repository.ClientRepository;
import com.projectfullapplications.domain.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BookRepository bookRepository;

    // Método para criar uma nova reserva (Booking)
    public BookingDTO create(BookingDTO bookingDTO) {
        Booking booking = convertToEntity(bookingDTO);
        bookingRepository.save(booking);
        return convertToDTO(booking);
    }

    // Método para buscar todas as reservas
    public List<BookingDTO> findAll() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Método para deletar uma reserva por ID
    public void deleteById(UUID uuid) {
        bookingRepository.deleteById(uuid);
    }

    // Conversão de BookingDTO para Booking (Entidade)
    public Booking convertToEntity(BookingDTO bookingDTO) {
        Client client = clientRepository.findById(bookingDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Book book = bookRepository.findById(bookingDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Booking booking = new Booking();
        booking.setUuid(bookingDTO.getUuid());
        booking.setClient(client);
        booking.setBook(book);
        return booking;
    }

    // Conversão de Booking (Entidade) para BookingDTO
    public BookingDTO convertToDTO(Booking booking) {
        return new BookingDTO(booking.getUuid(), booking.getClient().getUuid(), booking.getBook().getUuid());
    }
}
