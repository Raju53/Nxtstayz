package com.example.nxtstayz.controller;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.service.HotelJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class HotelController {
    @Autowired
    private HotelJpaService hotelJpaService;

    @GetMapping("/hotels")
    public ArrayList<Hotel> getHotels() {
        return hotelJpaService.getHotels();
    }

    @GetMapping("/hotels/{hotelId}")
    public Hotel getHotelById(@PathVariable("hotelId") int hotelId) {
        return hotelJpaService.getHotelById(hotelId);
    }

    @PostMapping("/hotels")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelJpaService.addHotel(hotel);
    }

    @PutMapping("/Hotels/{hotelId}")
    public Hotel updateHotel(@PathVariable("hotelId") int hotelId, @RequestBody Hotel hotel) {
        return hotelJpaService.updateHotel(hotelId, hotel);
    }

    @DeleteMapping("/Hotels/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") int hotelId) {
        hotelJpaService.deleteHotel(hotelId);
    }

    @GetMapping("/hotels/{hotelId}/rooms")
    public List<Room> getRoomsByHotelId(@PathVariable("hotelId") int hotelId) {
        return hotelJpaService.getRoomsByHotelId(hotelId);
    }
}