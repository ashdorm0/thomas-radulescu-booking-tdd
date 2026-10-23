import java.time.Clock;
import java.time.LocalDate;

class BookingWindow implements BookingRule {

    private final Clock clock;

    BookingWindow(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void check(
            String userId,
            String roomId,
            TimeSlot slot) {

        LocalDate today = LocalDate.now(clock);

        LocalDate latestAllowedDate = today.plusDays(14);

        LocalDate requestedDate = slot.getStart().toLocalDate();

        if (requestedDate.isAfter(latestAllowedDate)) {
            throw new IllegalArgumentException(
                    "Booking cannot start more than 14 days ahead");
        }
    }
}