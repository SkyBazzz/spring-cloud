package oleksandr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import oleksandr.model.Room;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}