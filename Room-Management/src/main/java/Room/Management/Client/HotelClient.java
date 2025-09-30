package Room.Management.Client;

import Room.Management.Entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE",path = "/hotels")
public interface HotelClient {

    @GetMapping("/{id}")
    Hotel getHotelById(@PathVariable("id") Long id);
}
