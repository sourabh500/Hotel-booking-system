package Hotel.Hive.Project.Microservices.Entities;

import jakarta.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    private int ratings;    //rating out of 5

    @Column(nullable = false)
    private double price;   //price per night


    public Hotel()
    {

    }

    public Hotel(Long hotelId, String name, String location, int ratings, double price) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.ratings = ratings;
        this.price = price;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
