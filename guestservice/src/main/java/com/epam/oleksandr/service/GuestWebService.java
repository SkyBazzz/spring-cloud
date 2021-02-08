package com.epam.oleksandr.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.oleksandr.model.Guest;
import com.epam.oleksandr.repository.GuestRepository;

@RestController
@RequestMapping("/guests")
public class GuestWebService {

    private final GuestRepository guestRepository;

    public GuestWebService(GuestRepository guestRepository) {
        super();
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public Iterable<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id") long id) {
        return guestRepository.findById(id).get();
    }
}
