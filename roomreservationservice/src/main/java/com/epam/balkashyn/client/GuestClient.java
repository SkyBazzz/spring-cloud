package com.epam.balkashyn.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.epam.balkashyn.dto.Guest;

@FeignClient("guestservices")
public interface GuestClient {

    @GetMapping("/guests")
    List<Guest> getAllGuests();

    @GetMapping("/guests/{id}")
    Guest getGuest(@PathVariable("id") long id);
}