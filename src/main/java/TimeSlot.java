import java.time.LocalDateTime;

public final class TimeSlot {

    public TimeSlot(LocalDateTime start, LocalDateTime end) {
        if (!end.isAfter(start)) {
            throw new IllegalArgumentException(
                    "end must be after start");
        }

        if (start == null || end == null) {
            throw new IllegalArgumentException(
                    "start and end cannot be null");
        }
    }

    public LocalDateTime getStart() {
        return null;
    }

    public LocalDateTime getEnd() {
        return null;
    }
}