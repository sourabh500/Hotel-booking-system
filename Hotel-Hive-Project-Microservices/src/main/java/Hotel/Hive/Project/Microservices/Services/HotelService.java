package Hotel.Hive.Project.Microservices.Services;

import Hotel.Hive.Project.Microservices.Entities.Hotel;

import java.util.List;

public interface HotelService {


    //get hotel by id

    Hotel getHotelById(Long id);

    //get all the hotels

    List<Hotel> getAllHotels();

    //create hotel

    Hotel createHotel(Hotel hotel);

    //update hotel

    Hotel updateHotel(Long id, Hotel hotel);

    //delete hotel by Id

    String deleteHotelById(Long id);


    //get hotel by location

    List<Hotel> getHotelByLocation(String Location);

}
