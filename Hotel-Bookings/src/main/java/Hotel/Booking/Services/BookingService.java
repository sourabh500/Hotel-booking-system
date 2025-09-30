package Hotel.Booking.Services;

import Hotel.Booking.Entities.Booking;

import java.time.LocalDate;
import java.util.List;


public interface BookingService {


    //get booking by id

    Booking getBookingById(Long id);

    //get booking for room

    List<Booking> getBookingForRoom(Long hotelId, Long roomId, LocalDate startDate,LocalDate endDate);

    //create booking

    Booking createBooking(Booking booking);

    //delete booking

    String deleteBooking(Long id);


}
