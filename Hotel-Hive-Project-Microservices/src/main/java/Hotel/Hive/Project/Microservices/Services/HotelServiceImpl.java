package Hotel.Hive.Project.Microservices.Services;

import Hotel.Hive.Project.Microservices.Entities.Hotel;
import Hotel.Hive.Project.Microservices.Exceptions.BadRequestException;
import Hotel.Hive.Project.Microservices.Exceptions.HotelNotFoundException;
import Hotel.Hive.Project.Microservices.Repositiories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepo hotelRepo;

    //getting single hotel by id
    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepo.findById(id).orElseThrow(()-> new HotelNotFoundException("Hotel with ID " +id+ " is not found in the record "));
    }


    //getting all the hotels
    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    //creating hotel
    @Override
    public Hotel createHotel(Hotel hotel) {
        if (hotel.getRatings() <0 || hotel.getRatings()>5)
        {
            throw new BadRequestException("Rating must be between 0 and 5");
        }
        return hotelRepo.save(hotel);
    }

    //updating hotel
    @Override
    public Hotel updateHotel(Long id, Hotel hotel) {

       Hotel data= hotelRepo.findById(id).orElseThrow(()-> new HotelNotFoundException("Hotel with ID " +id+ " is not found in the record : "));

       data.setHotelId(hotel.getHotelId());
       data.setName(hotel.getName());
       data.setLocation(hotel.getLocation());
       data.setPrice(hotel.getPrice());
       data.setRatings(hotel.getRatings());

       return hotelRepo.save(data);

    }

    @Override
    public String deleteHotelById(Long id) {
         hotelRepo.deleteById(id);
         return "Record has been deleted successfully";
    }

    @Override
    public List<Hotel> getHotelByLocation(String Location) {

        List<Hotel> hotels= hotelRepo.findByLocation(Location);
        if (hotels.isEmpty())
        {
            throw new HotelNotFoundException("\"No hotels found in the location: "+Location);
        }

        return hotels;
    }

}
