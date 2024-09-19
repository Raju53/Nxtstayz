package com.example.nxtstayz.model;

import com.example.nxtstayz.model.Room;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @Column(name = "hotelid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;
    @Column(name = "hotelname")
    private String hotelName;
    @Column(name = "location")
    private String location;
    @Column(name = "rating")
    private int rating;
    @Column(name = "rooms")
    @OneToMany(mappedBy = "hotel")
    @JoinColumn(name = "")
    private List<Room> rooms;

    public Hotel() {
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}