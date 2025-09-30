package Room.Management.Services;

import Room.Management.Entities.Room;

import java.util.List;

public interface RoomService {


    //get all the rooms

    List<Room> getAvailableRooms(Long HotelId);

    //get room by hotel id

    List<Room> getRoomsByHotelId(Long hotelId);

    //get room by room id

    Room getRoomByRoomId(Long roomId);

    //create room

    Room createRoom(Room room);


    //delete room

    String deleteRoom(Long roomId);


}
