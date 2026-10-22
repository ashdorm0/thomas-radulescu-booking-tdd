# Study Room Booking — TDD Assessment

## Description

This project implements a small library study room booking system using Java.

It was developed for the Agile Software Verification module using Test-Driven Development (TDD).

Students can reserve study rooms for specified time slots. The system validates bookings and prevents conflicting reservations.

## Requirements

- Java 17 or newer
- JUnit Platform Console Standalone 6.1.3
- Git

## Project Structure

```text
src/
├── main/java/
│   ├── TimeSlot.java
│   ├── Room.java
│   ├── Booking.java
│   ├── BookingService.java
│   ├── IRoomRepository.java
│   ├── IBookingRepository.java
│   ├── MemoryRoomRepository.java
│   └── MemoryBookingRepository.java
└── test/java/
    ├── TimeSlotTest.java
    ├── RoomTest.java
    ├── BookingTest.java
    └── BookingServiceTest.java
```

## Setup

Download `junit-platform-console-standalone-6.1.3.jar` from Maven Central.

Place the JAR in the project root directory and rename it `junit.jar`.

## Compilation

Run this command from the project root:

```bash
javac -d out -cp junit.jar src/main/java/*.java src/test/java/*.java
```

## Running Tests

Run:

```bash
java -jar junit.jar execute --class-path out --scan-class-path
```

JUnit will discover and execute the project's automated tests.

## Main Classes

### TimeSlot

Represents an immutable time interval with validation, duration calculation, overlap detection and equality.

### Room

Represents a study room using its ID and name.

### Booking

Represents a reservation containing a user ID, room ID and TimeSlot.

### BookingService

Implements the booking rules:

- R1: The room must exist.
- R2: The booking must start in the future.
- R3: The duration cannot exceed three hours.
- R4: A room cannot have overlapping bookings.
- R5: A user cannot have overlapping bookings.
- R6: Cancelling a booking removes it.
- R7: User bookings are returned in chronological order.

## Test-Driven Development

The project uses the Red → Green → Refactor cycle.

1. Write and execute a failing test.
2. Commit the failing test using `test:`.
3. Implement the minimum required functionality.
4. Run all tests and confirm they pass.
5. Commit the implementation using `feat:`.
6. Refactor when necessary, keeping all tests passing.

Tests that pass immediately are committed using `confirm:`.

The Git history documents the development process.

## Notes

`NOTES.md` records specification questions, lecturer rulings and corrections made after AI-assisted development.

## Assessment

Agile Software Verification — Study Room Booking TDD Assessment.