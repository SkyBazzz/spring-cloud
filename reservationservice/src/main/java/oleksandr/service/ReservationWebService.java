package oleksandr.service;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oleksandr.model.Reservation;
import oleksandr.repository.ReservationRepository;

@RestController
@RequestMapping("/reservations")
public class ReservationWebService {

    private final ReservationRepository reservationRepository;

    public ReservationWebService(ReservationRepository reservationRepository) {
        super();
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public Iterable<Reservation> getReservations(@RequestParam(name = "date", required = false) Date date) {
        if (date != null) {
            return this.reservationRepository.findAllByDate(date);
        }
        return this.reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getGuest(@PathVariable("id") long id) {
        return reservationRepository.findById(id)
                                    .get();
    }
}
