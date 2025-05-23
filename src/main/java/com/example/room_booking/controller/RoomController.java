package com.example.room_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.room_booking.entities.Room;
import com.example.room_booking.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private  RoomService roomService;


    @GetMapping
    public ResponseEntity<List<Room>> listRooms(@RequestParam(required = false) Boolean available) {
        return ResponseEntity.ok(roomService.getRooms(available));
    }

    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        return ResponseEntity.ok(roomService.addRoom(room));
    }
}
