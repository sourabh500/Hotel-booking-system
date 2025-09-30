package Hotel.Booking.Client;

import Hotel.Booking.Entities.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ROOM-SERVICE",path = "/rooms")
public interface RoomClient {

    @GetMapping("/{id}")
    Room getRoomById(@PathVariable("id") Long id);
}
