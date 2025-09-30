package Hotel.Hive.Project.Microservices.Exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message)
    {
        super(message);
    }
}
