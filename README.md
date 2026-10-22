# Study Room Booking — TDD Assessment

A Java application for booking library study rooms.

## Requirements

- Java 17 or newer
- JUnit Platform Console Standalone 6.1.3

## Compile

javac -d out -cp junit.jar src/main/java/*.java src/test/java/*.java

## Run tests

java -jar junit.jar execute --class-path out --scan-class-path

## Development approach

This project uses Test-Driven Development (TDD).

Each feature is developed through:

1. RED: Write a failing test.
2. GREEN: Implement the minimum code required.
3. REFACTOR: Improve the code when necessary.

The Git commit history records these steps.