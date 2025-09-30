package Hotel.Hive.Project.Microservices.Exceptions;

public class HotelNotFoundException extends RuntimeException{

    public HotelNotFoundException(String message)
    {
        super(message);
    }
}
