import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class TimeSlotTest {

    @Test
    void endBeforeStartIsRejected() {
        LocalDateTime start = LocalDateTime.of(2027, 1, 11, 10, 0);

        LocalDateTime end = LocalDateTime.of(2027, 1, 11, 9, 0);

        assertThrows(
                IllegalArgumentException.class,
                () -> new TimeSlot(start, end));
    }

    @Test
    void equalStartAndEndAreRejected() {
        LocalDateTime ten = LocalDateTime.of(2027, 1, 11, 10, 0);

        assertThrows(
                IllegalArgumentException.class,
                () -> new TimeSlot(ten, ten));
    }

    @Test
    void nullStartIsRejected() {
        LocalDateTime end = LocalDateTime.of(2027, 1, 11, 11, 0);

        assertThrows(
                IllegalArgumentException.class,
                () -> new TimeSlot(null, end));
    }

    @Test
    void nullEndIsRejected() {
        LocalDateTime start = LocalDateTime.of(2027, 1, 11, 10, 0);

        assertThrows(
                IllegalArgumentException.class,
                () -> new TimeSlot(start, null));
    }

    @Test
    void gettersReturnTheOriginalTimes() {
        LocalDateTime start = LocalDateTime.of(2027, 1, 11, 10, 0);

        LocalDateTime end = LocalDateTime.of(2027, 1, 11, 11, 0);

        TimeSlot slot = new TimeSlot(start, end);

        assertEquals(start, slot.getStart());
        assertEquals(end, slot.getEnd());
    }
}