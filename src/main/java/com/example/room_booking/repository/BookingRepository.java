package com.example.room_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.room_booking.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {}
