package Room.Management.Services;

import Room.Management.Client.HotelClient;
import Room.Management.Entities.Hotel;
import Room.Management.Entities.Room;
import Room.Management.Exception.BadRequestException;
import Room.Management.Exception.RoomNotFoundException;
import Room.Management.Repositiories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    HotelClient hotelClient;

    @Override
    public List<Room> getAvailableRooms(Long hotelId) {

        Hotel hotel= hotelClient.getHotelById(hotelId);

        if (hotel==null)
        {
            throw new BadRequestException("Hotel with ID " + hotelId + "does not exist");
        }

        List<Room> availableRooms= roomRepo.findByHotelIdAndAvailable(hotelId,true);
        if (availableRooms.isEmpty())
        {
            throw new RoomNotFoundException("No available rooms found for hotel ID: " + hotelId);
        }

        return availableRooms;
    }

    @Override
    public List<Room> getRoomsByHotelId(Long hotelId) {
        List<Room> rooms= roomRepo.findByHotelId(hotelId);
        if (rooms.isEmpty())
        {
            throw new RoomNotFoundException("Room with hotel ID " +hotelId+ " not found");
        }
        return rooms;
    }

    @Override
    public Room getRoomByRoomId(Long roomId) {
        return roomRepo.findById(roomId).orElseThrow(()-> new RoomNotFoundException("Room with ID " +roomId+ " not found"));
    }

    @Override
    public Room createRoom(Room room) {
        if (room.getPrice()<0)
        {
            throw new BadRequestException("Room price cannot be negative");
        }

        //validating hotel is existing

        Hotel hotel= hotelClient.getHotelById(room.getHotelId());

        if (hotel==null)
        {
            throw new BadRequestException("Hotel with ID " +room.getHotelId()+ " does not exist");
        }

        return roomRepo.save(room);
    }

    @Override
    public String deleteRoom(Long roomId) {
         roomRepo.deleteById(roomId);
         return "Record has been deleted successfully";
    }

}
