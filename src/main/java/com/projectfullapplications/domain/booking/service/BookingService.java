package com.projectfullapplications.domain.booking.service;

import com.projectfullapplications.domain.booking.Booking;
import com.projectfullapplications.domain.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepository  bookingRepository;

    public Booking create (Booking booking) {
        bookingRepository.save(booking);
        return booking;
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void deleteById(UUID uuid) {
        bookingRepository.deleteById(uuid);
    }
}
