package Hotel.Booking.Entities;

public class Hotel {

    private Long hotelId;
    private String name;
    private String location;
    private int ratings;
    private double price;

    public Hotel(Long hotelId, String name, String location, int ratings, double price) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.ratings = ratings;
        this.price = price;
    }

    public Hotel() {
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
