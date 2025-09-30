package Hotel.Hive.Project.Microservices.Repositiories;

import Hotel.Hive.Project.Microservices.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepo extends JpaRepository<Hotel,Long> {

    List<Hotel> findByLocation(String Location);
}
