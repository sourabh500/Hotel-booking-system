package Hotel.Booking.Controller;

import Hotel.Booking.Entities.Booking;
import Hotel.Booking.Services.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingServiceImpl bookingService;

    //get booking by id

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id)
    {
       Booking booking= bookingService.getBookingById(id);
       return new ResponseEntity<>(booking, HttpStatus.OK);

    }

    //get booking for room

    @GetMapping("/search")
    public ResponseEntity<List<Booking>> searchBookings(@RequestParam Long hotelId,@RequestParam Long roomId,@RequestParam LocalDate startDate,@RequestParam LocalDate endDate)
    {
       List<Booking> result= bookingService.getBookingForRoom(hotelId,roomId,startDate,endDate);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

        //create booking

        @PostMapping
        public ResponseEntity<Booking> createBooking(@RequestBody Booking booking)
        {
              Booking addedBooking=  bookingService.createBooking(booking);
                return new ResponseEntity<>(addedBooking,HttpStatus.CREATED);
        }

    //cancel booking

        @DeleteMapping("/{id}")
        public ResponseEntity<String> cancelBooking(@PathVariable Long id)
        {
              String message=  bookingService.deleteBooking(id);
                return new ResponseEntity<>(message,HttpStatus.OK);
        }
        
}
