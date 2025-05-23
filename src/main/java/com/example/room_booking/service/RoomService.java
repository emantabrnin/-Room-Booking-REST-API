package com.example.room_booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.room_booking.entities.Room;
import com.example.room_booking.repository.RoomRepository;

import java.util.List;

@Service
public class RoomService {
        @Autowired
    private  RoomRepository roomRepository;
    
    // @Autowired
    // public RoomService(RoomRepository roomRepository) {
    //     this.roomRepository = roomRepository;
    // }

    public List<Room> getRooms(Boolean available) {
        return (available == null) ? roomRepository.findAll() : roomRepository.findByAvailable(available);
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }
}
