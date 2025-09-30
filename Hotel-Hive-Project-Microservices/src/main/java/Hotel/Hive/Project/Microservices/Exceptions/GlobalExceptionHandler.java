package Hotel.Hive.Project.Microservices.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    //Handle HotelNotFoundException

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleHotelNotFoundException(HotelNotFoundException exception)
    {
        Map<String,Object> response= new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message",exception.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }

    //Handle BadRequestException

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String,Object>> handBadRequestException(BadRequestException exception)
    {
        Map<String,Object> response= new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message",exception.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }


    // Handle IllegalArgumentException

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(IllegalArgumentException exception)
    {
        Map<String,Object> response= new HashMap<>();
        response.put("timestamp",LocalDateTime.now());
        response.put("message",exception.getMessage());
        response.put("status",HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }


    // Handle Generic Exceptions

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleGlobalException(Exception e)
    {

        Map<String,Object> response= new HashMap<>();
        response.put("timestamp",LocalDateTime.now());
        response.put("message",e.getMessage());
        response.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
