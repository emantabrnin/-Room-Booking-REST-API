package com.example.room_booking;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RoomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleRoomNotFoundException(RoomNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(RoomUnavailableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRoomUnavailableException(RoomUnavailableException e) {
        return e.getMessage();
    }

    @ExceptionHandler(BookingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleBookingNotFoundException(BookingNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGenericException(Exception e) {
        return "An unexpected error occurred: " + e.getMessage();
    }
}
