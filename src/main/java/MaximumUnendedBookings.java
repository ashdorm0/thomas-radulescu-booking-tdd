import java.time.Clock;
import java.time.LocalDateTime;

class MaximumUnendedBookings implements BookingRule {

    private final IBookingRepository bookings;
    private final Clock clock;

    MaximumUnendedBookings(
            IBookingRepository bookings,
            Clock clock) {

        this.bookings = bookings;
        this.clock = clock;
    }

    @Override
    public void check(
            String userId,
            String roomId,
            TimeSlot slot) {

        int count = 0;

        LocalDateTime now = LocalDateTime.now(clock);

        for (Booking booking : bookings.findByUser(userId)) {

            if (booking.getSlot().getEnd().isAfter(now)) {
                count++;
            }
        }

        if (count >= 3) {
            throw new IllegalStateException(
                "User already has three unended bookings"
            );
        }
    }
}