package Hotel.Booking.Exception;

public class RoomNotFoundException extends RuntimeException{

    public RoomNotFoundException(String message)
    {
        super(message);
    }
}
