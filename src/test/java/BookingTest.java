import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    private static TimeSlot createSlot() {
        return new TimeSlot(
                LocalDateTime.of(2027, 1, 11, 10, 0),
                LocalDateTime.of(2027, 1, 11, 11, 0));
    }

    @Test
    void bookingStoresConstructorValues() {
        TimeSlot slot = createSlot();

        Booking booking = new Booking(
                "alice",
                "R1",
                slot);

        assertEquals("alice", booking.getUserId());
        assertEquals("R1", booking.getRoomId());
        assertEquals(slot, booking.getSlot());
    }

    @Test
    void equalBookingsHaveEqualHashCodes() {
        Booking first = new Booking(
                "alice", "R1", createSlot());

        Booking second = new Booking(
                "alice", "R1", createSlot());

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void bookingsWithDifferentUsersAreNotEqual() {
        Booking first = new Booking(
                "alice", "R1", createSlot());

        Booking second = new Booking(
                "bob", "R1", createSlot());

        assertNotEquals(first, second);
    }

    @Test
    void bookingsWithDifferentRoomsAreNotEqual() {
        Booking first = new Booking(
                "alice", "R1", createSlot());

        Booking second = new Booking(
                "alice", "R2", createSlot());

        assertNotEquals(first, second);
    }

    @Test
    void bookingsWithDifferentSlotsAreNotEqual() {
        TimeSlot later = new TimeSlot(
                LocalDateTime.of(2027, 1, 11, 12, 0),
                LocalDateTime.of(2027, 1, 11, 13, 0));

        Booking first = new Booking(
                "alice", "R1", createSlot());

        Booking second = new Booking(
                "alice", "R1", later);

        assertNotEquals(first, second);
    }

}