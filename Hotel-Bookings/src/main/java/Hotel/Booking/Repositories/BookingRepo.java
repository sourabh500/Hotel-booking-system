package Hotel.Booking.Repositories;

import Hotel.Booking.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Long> {

    List<Booking> findByHotelIdAndRoomIdAndCheckInDateGreaterThanEqualAndCheckOutDateLessThanEqual(
            Long hotelId, Long roomId, LocalDate checkInDate, LocalDate checkOutDate);


}
