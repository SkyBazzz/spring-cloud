package com.epam.balkashyn.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.balkashyn.client.GuestClient;
import com.epam.balkashyn.client.ReservationClient;
import com.epam.balkashyn.client.RoomClient;
import com.epam.balkashyn.dto.Guest;
import com.epam.balkashyn.dto.Reservation;
import com.epam.balkashyn.dto.Room;
import com.epam.balkashyn.dto.RoomReservation;
import com.epam.balkashyn.util.DateConverter;

@RestController
@RequestMapping("/room-reservations")
public class RoomReservationWebService {
    private final RoomClient roomClient;
    private final GuestClient guestClient;
    private final ReservationClient reservationClient;

    public RoomReservationWebService(RoomClient roomClient, GuestClient guestClient, ReservationClient reservationClient) {
        this.roomClient = roomClient;
        this.guestClient = guestClient;
        this.reservationClient = reservationClient;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(name = "date", required = false) String dateString) {
        Date date = DateConverter.createDateFromString(dateString);
        List<Room> rooms = this.roomClient.getAllRooms();
        Map<Long, RoomReservation> roomReservations = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation(){{
                setRoomName(room.getName());
                setRoomId(room.getRoomId());
                setRoomNumber(room.getRoomNumber());
            }};
            roomReservations.put(room.getRoomId(), roomReservation);
        });
        List<Reservation> reservations = this.reservationClient.getAllReservations(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservations.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestClient.getGuest(reservation.getGuestId());
            roomReservation.setGuestId(guest.getId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });

        return new ArrayList<>(roomReservations.values());
    }


}
