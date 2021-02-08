package com.epam.oleksandr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.oleksandr.model.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}