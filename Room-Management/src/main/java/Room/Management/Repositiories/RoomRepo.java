package Room.Management.Repositiories;

import Room.Management.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room,Long> {

    List<Room> findByHotelId(Long hotelId);
    List<Room> findByHotelIdAndAvailable(Long hotelId,boolean available);

}
