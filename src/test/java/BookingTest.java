import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    private static TimeSlot createSlot() {
        return new TimeSlot(
            LocalDateTime.of(2027, 1, 11, 10, 0),
            LocalDateTime.of(2027, 1, 11, 11, 0)
        );
    }

    @Test
    void bookingStoresConstructorValues() {
        TimeSlot slot = createSlot();

        Booking booking = new Booking(
            "alice",
            "R1",
            slot
        );

        assertEquals("alice", booking.getUserId());
        assertEquals("R1", booking.getRoomId());
        assertEquals(slot, booking.getSlot());
    }
}