package com.projectfullapplications.domain.booking.controller;

import com.projectfullapplications.domain.booking.Booking;
import com.projectfullapplications.domain.booking.service.BookingService;
import com.projectfullapplications.domain.client.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody Booking booking) {
        Booking createBooking = bookingService.create(booking);
        return new ResponseEntity<>(createBooking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> findAll() {
        List<Booking> allClients = bookingService.findAll();
        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteById(@PathVariable("id") UUID uuid) {
        bookingService.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
