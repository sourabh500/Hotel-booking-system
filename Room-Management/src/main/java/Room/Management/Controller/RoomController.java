package Room.Management.Controller;

import Room.Management.Entities.Room;
import Room.Management.Services.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomServiceImpl roomService;

    //Getting available rooms

    @GetMapping("/hotels/{id}/available")
    public ResponseEntity<List<Room>> getAvailableRoom(@PathVariable Long id)
    {
       List<Room> availableRooms= roomService.getAvailableRooms(id);
       return new ResponseEntity<>(availableRooms, HttpStatus.OK);
    }

    //Getting rooms by hotel id

    @GetMapping("/hotels/{id}")
    public ResponseEntity<List<Room>> getRoomsByHotel(@PathVariable Long id)
    {
      List<Room> rooms=  roomService.getRoomsByHotelId(id);
      return new ResponseEntity<>(rooms,HttpStatus.OK);
    }


    //Getting room by room id

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomByRoomId(@PathVariable Long id)
    {
       Room room= roomService.getRoomByRoomId(id);
       return new ResponseEntity<>(room,HttpStatus.OK);
    }

    //Creating room

    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room)
    {
       Room addedRoom= roomService.createRoom(room);
       return new ResponseEntity<>(addedRoom,HttpStatus.CREATED);
    }

    //Deleting room by room id

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id)
    {
      String message=  roomService.deleteRoom(id);
      return new ResponseEntity<>(message,HttpStatus.OK);
    }


}
