package Hotel.Booking.Entities;

public class Room {

    private Long roomId;
    private String type;
    private double price;
    private boolean available;
    private Long hotelId;

    public Room(Long roomId, String type, double price, boolean available, Long hotelId) {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
        this.available = available;
        this.hotelId = hotelId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Room() {
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }




}
