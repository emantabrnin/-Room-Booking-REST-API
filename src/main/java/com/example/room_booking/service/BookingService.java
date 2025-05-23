package com.example.room_booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.room_booking.BookingNotFoundException;
import com.example.room_booking.RoomNotFoundException;
import com.example.room_booking.RoomUnavailableException;
import com.example.room_booking.entities.Booking;
import com.example.room_booking.entities.Room;
import com.example.room_booking.repository.BookingRepository;
import com.example.room_booking.repository.RoomRepository;

@Service
public class BookingService {


        @Autowired
    private  BookingRepository bookingRepository;
        @Autowired
    private  RoomRepository roomRepository;
    

    public Booking createBooking(Booking booking) {
        Room room = roomRepository.findById(booking.getRoom().getId())
                .orElseThrow(() -> new RoomNotFoundException("Room not found"));

        if (!room.isAvailable()) {
            throw new RoomUnavailableException("Room is not available for booking");
        }

        room.setAvailable(false);
        roomRepository.save(room);
        return bookingRepository.save(booking);
    }

    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found"));

        Room room = booking.getRoom();
        room.setAvailable(true);
        roomRepository.save(room);

        bookingRepository.delete(booking);
    }

    public Booking getBooking(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found"));
    }
}