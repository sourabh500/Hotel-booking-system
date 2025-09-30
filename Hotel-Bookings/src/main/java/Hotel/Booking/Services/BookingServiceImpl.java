package Hotel.Booking.Services;

import Hotel.Booking.Client.HotelClient;
import Hotel.Booking.Client.RoomClient;
import Hotel.Booking.Entities.Booking;
import Hotel.Booking.Entities.Hotel;
import Hotel.Booking.Entities.Room;
import Hotel.Booking.Exception.BadRequestException;
import Hotel.Booking.Exception.BookingNotFoundException;
import Hotel.Booking.Exception.HotelNotFoundException;
import Hotel.Booking.Exception.RoomNotFoundException;
import Hotel.Booking.Repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    HotelClient hotelClient;

    @Autowired
    RoomClient roomClient;


    @Override
    public Booking getBookingById(Long id) {
        return bookingRepo.findById(id).orElseThrow(()-> new BookingNotFoundException("Booking with ID " +id+ " not found"));
    }

    @Override
    public List<Booking> getBookingForRoom(Long hotelId, Long roomId, LocalDate startDate, LocalDate endDate) {
        List<Booking> bookings=bookingRepo.findByHotelIdAndRoomIdAndCheckInDateGreaterThanEqualAndCheckOutDateLessThanEqual(hotelId,roomId,startDate,endDate);

        if (bookings.isEmpty())
        {
            throw new BookingNotFoundException("No bookings found for hotel ID " + hotelId + ", room ID " + roomId+
                    " between dates " + startDate + " and " + endDate);
        }

        return bookings;
    }

    @Override
    public Booking createBooking(Booking booking) {

        if (booking.getCheckInDate().isAfter(booking.getCheckOutDate()))
        {
            throw new BadRequestException("Check-in date cannot be after check-out date");
        }

        // Validate hotel and room existence

       Hotel hotel= hotelClient.getHotelById(booking.getHotelId());

        if (hotel==null)
        {
            throw new HotelNotFoundException("Hotel with ID " + booking.getHotelId() + " does not exist. ");
        }

        Room room= roomClient.getRoomById(booking.getRoomId());

        if (!room.getHotelId().equals(booking.getHotelId()))
        {
           throw new BadRequestException("Room ID " + booking.getRoomId() + " does not belongs to Hotel ID " + booking.getHotelId());
        }

        if (room==null)
        {
            throw new RoomNotFoundException("Room with ID " + booking.getRoomId() + " does not exist");
        }

        // Check if the room is available for the specified dates

       boolean isAvailable= isRoomAvailable(booking.getHotelId(),booking.getRoomId(),booking.getCheckInDate(),booking.getCheckOutDate());
       if (!isAvailable)
       {
           throw new BadRequestException("Room is not available for the selected dates");
       }

        return bookingRepo.save(booking);

    }

    @Override
    public String deleteBooking(Long id) {

        if (!bookingRepo.existsById(id))
        {
            throw new BookingNotFoundException("Booking with ID " +id+ " not found. Cannot delete");
        }

        bookingRepo.deleteById(id);
        return "Booking has been canceled successfully";
    }

    private boolean isRoomAvailable(Long hotelId,Long roomId,LocalDate checkInDate,LocalDate checkOutDate)
    {
        // Query the repository to check if there are any existing bookings for the room between the given dates
       List<Booking> existingBookings= bookingRepo.findByHotelIdAndRoomIdAndCheckInDateGreaterThanEqualAndCheckOutDateLessThanEqual(hotelId, roomId, checkInDate, checkOutDate);

        // If the list is not empty, the room is already booked for the dates
        return existingBookings.isEmpty();
    }

}
