package oleksandr.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oleksandr.model.Room;
import oleksandr.repository.RoomRepository;

@RestController
@RequestMapping("/rooms")
public class RoomWebService {

    private final RoomRepository roomRepository;

    public RoomWebService(RoomRepository roomRepository) {
        super();
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") long id) {
        return roomRepository.findById(id).get();
    }
}
