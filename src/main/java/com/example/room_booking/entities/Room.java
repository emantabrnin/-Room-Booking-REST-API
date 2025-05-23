package com.example.room_booking.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roomNumber;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private BigDecimal pricePerNight;

    @Column(nullable = false)
    private boolean available;
}

