import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import main.java.TimeSlot;

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
}