import java.time.LocalDateTime;
import java.time.Duration;

public final class TimeSlot {
    private final LocalDateTime start;
    private final LocalDateTime end;

    public TimeSlot(LocalDateTime start, LocalDateTime end) {
        if (!end.isAfter(start)) {
            throw new IllegalArgumentException(
                    "end must be after start");
        }

        if (start == null || end == null) {
            throw new IllegalArgumentException(
                    "start and end cannot be null");
        }
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Duration duration() {
        return Duration.between(start, end);
    }
}