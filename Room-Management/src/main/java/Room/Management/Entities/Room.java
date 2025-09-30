package Room.Management.Entities;

import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false)
    private String type;   //e.g  single,double,suite

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private boolean available;

    @Column(nullable = false)
    private Long hotelId;   // Foreign key to Hotel Management Service


    public Room() {
    }

    public Room(Long roomId, String type, double price, boolean available, Long hotelId) {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
        this.available = available;
        this.hotelId = hotelId;
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

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }


}
