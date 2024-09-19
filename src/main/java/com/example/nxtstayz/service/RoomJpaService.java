package com.example.nxtstayz.service;

import com.example.nxtstayz.model.*;
import com.example.nxtstayz.repository.RoomJpaRepository;
import com.example.nxtstayz.repository.HotelJpaRepository;
import com.example.nxtstayz.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomJpaService implements RoomRepository {
    @Autowired
    private RoomJpaRepository roomJpaRepository;

    @Autowired
    private HotelJpaRepository hotelJpaRepository;

    @Override
    public ArrayList<Room> getRooms() {
        List<Room> roomsList = roomJpaRepository.findAll();
        ArrayList<Room> rooms = new ArrayList<>(roomsList);
        return rooms;
    }

    @Override
    public Room getRoomById(int roomId) {
        try {
            Room room = roomJpaRepository.findById(roomId).get();
            return room;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Room addRoom(Room room) {
        roomJpaRepository.save(room);
        return room;
    }

    @Override
    public Room updateRoom(int roomId, Room room) {
        try {
            Room newRoom = roomJpaRepository.findById(roomId).get();

            if (room.getRoomNumber() != null) {
                newRoom.setRoomNumber(room.getRoomNumber());
            }
            if (room.getRoomType() != null) {
                newRoom.setRoomType(room.getRoomType());
            }
            if (room.getPrice() != null) {
                newRoom.setPrice(room.getPrice());
            }
            if (room.getHotel() != null) {
                Hotel hotel = hotelJpaRepository.findById(room.getHotel().getHotelId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                newRoom.setHotel(hotel);
            }
            roomJpaRepository.save(newRoom);
            return newRoom;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteRoom(int roomId) {
        try {
            roomJpaRepository.deleteById(roomId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Hotel getHotelByRoomId(int roomId) {
        Room room = roomJpaRepository.findById(roomId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return room.getHotel();
    }

}