package Hotel.Booking.Exception;


public class BookingNotFoundException extends RuntimeException{

    public BookingNotFoundException(String message)
    {
        super(message);
    }

}
