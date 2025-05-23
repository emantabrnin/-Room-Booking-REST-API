# 🏨 Hotel Booking API

A **Spring Boot** REST API for managing **room reservations** and **bookings** using **H2 in-memory database**. Includes error handling, validation, and design patterns.

---


 1️⃣ **Clone the Repository**

git clone https://github.com/emantabrnin/-Room-Booking-REST-API
cd -Room-Booking-REST-API

Access H2 Database Console
URL: http://localhost:8082/h2-console

JDBC URL: jdbc:h2:mem:testdb

Username: room-booking

Password: (empty)

API Documentation
1️⃣ List Available Rooms
 Endpoint: GET /rooms?available=true 
  Description: Returns a list of all available rooms.

 Example Curl Request
curl -X GET "http://localhost:8080/rooms?available=true" -H "Content-Type: application/json"

Response
json
[
    {
        "id": 1,
        "roomNumber": "101",
        "capacity": 2,
        "pricePerNight": 100.00,
        "available": true
    },
    {
        "id": 2,
        "roomNumber": "202",
        "capacity": 3,
        "pricePerNight": 150.00,
        "available": true
    }
]
2️⃣ Add a New Room
 Endpoint: POST /rooms 
 Description: Adds a new room to the system.

 Example Curl Request

curl -X POST "http://localhost:8080/rooms" -H "Content-Type: application/json" -d '{
    "roomNumber": "303",
    "capacity": 4,
    "pricePerNight": 200.00,
    "available": true
}'
Response
json
{
    "id": 3,
    "roomNumber": "303",
    "capacity": 4,
    "pricePerNight": 200.00,
    "available": true
}
Create a Booking
 Endpoint: POST /bookings 
 Description: Books a room if available.

 Example Curl Request
curl -X POST "http://localhost:8080/bookings" -H "Content-Type: application/json" -d '{
    "customerName": "Eman",
    "checkIn": "2025-06-01",
    "checkOut": "2025-06-05",
    "status": "CONFIRMED",
    "room": {
        "id": 1
    }
}'
 Response
{
    "id": 1,
    "customerName": "Eman",
    "checkIn": "2025-06-01",
    "checkOut": "2025-06-05",
    "status": "CONFIRMED",
    "room": {
        "id": 1,
        "roomNumber": "101",
        "capacity": 2,
        "pricePerNight": 100.00,
        "available": false
    }
}
4️⃣ Cancel a Booking
 Endpoint: PUT /bookings/{id}/cancel 
 Description: Cancels a booking and updates room availability.

 Example Curl Request

curl -X PUT "http://localhost:8080/bookings/1/cancel"
 Response
json
{
    "message": "Booking cancelled successfully",
    "room": {
        "id": 1,
        "available": true
    }
}
View Booking Details
 Endpoint: GET /bookings/{id} 
  Description: Retrieves booking details.

 Example Curl Request
curl -X GET "http://localhost:8080/bookings/1"
 Response
json
{
    "id": 1,
    "customerName": "Eman",
    "checkIn": "2025-06-01",
    "checkOut": "2025-06-05",
    "status": "CONFIRMED",
    "room": {
        "id": 1,
        "roomNumber": "101",
        "capacity": 2,
        "pricePerNight": 100.00,
        "available": false
    }
}

Design Patterns Used
Service Layer Pattern → Keeps business logic separate.  Repository Pattern → Manages database operations.  Global Exception Handling → Ensures clean error responses.