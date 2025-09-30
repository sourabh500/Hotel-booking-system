package Hotel.Hive.Project.Microservices.Controllers;

import Hotel.Hive.Project.Microservices.Entities.Hotel;
import Hotel.Hive.Project.Microservices.Services.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelServiceImpl hotelService;

    //fetching single hotel by id

    //url: http://localhost:8080/hotels/hotel_id
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id)
    {
       Hotel singleHotel= hotelService.getHotelById(id);
       return new ResponseEntity<>(singleHotel, HttpStatus.OK);
    }

    //fetching all the hotels

    //url: http://localhost:8080/hotels
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
       List<Hotel> allHotels= hotelService.getAllHotels();
       return new ResponseEntity<>(allHotels,HttpStatus.OK);
    }

    //search hotel by location

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotelsByLocation(@RequestParam String location)
    {
       List<Hotel> hotels= hotelService.getHotelByLocation(location);
       return new ResponseEntity<>(hotels,HttpStatus.OK);
    }

    //creating hotel record

    //url: http://localhost:8080/hotels
    @PostMapping
    public ResponseEntity<Hotel> creatingHotel(@RequestBody Hotel hotel)
    {
        Hotel createdHotel= hotelService.createHotel(hotel);
        return new ResponseEntity<>(createdHotel,HttpStatus.CREATED);
    }

    //updating hotel by id

    //url: http://localhost:8080/hotels/hotel_id
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotelById(@PathVariable Long id,@RequestBody Hotel hotel)
    {
       Hotel updatedHotel= hotelService.updateHotel(id,hotel);
       return new ResponseEntity<>(updatedHotel,HttpStatus.OK);
    }

    //Delete hotel by id

    //url: http://localhost:8080/hotels/hotel_id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id)
    {
       String message= hotelService.deleteHotelById(id);
       return new ResponseEntity<>(message,HttpStatus.NO_CONTENT);
    }
}
