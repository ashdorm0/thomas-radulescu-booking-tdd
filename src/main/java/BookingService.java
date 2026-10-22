import java.time.*;
import java.util.List;

public class BookingService {

    public static final Duration MAX_SLOT = Duration.ofHours(3);

    private final IRoomRepository rooms;
    private final IBookingRepository bookings;
    private final Clock clock;

    public BookingService(
            IRoomRepository rooms,
            IBookingRepository bookings,
            Clock clock) {

        this.rooms = rooms;
        this.bookings = bookings;
        this.clock = clock;
    }

    /** Book a room for a user. Returns the new booking. */
    public Booking book(
            String userId,
            String roomId,
            TimeSlot slot) {
        if (rooms.findById(roomId) == null) {
            throw new IllegalArgumentException(
                    "Room does not exist");
        }
        if (!slot.getStart().isAfter(LocalDateTime.now(clock))) {
            throw new IllegalArgumentException(
                    "Booking must start in the future");
        }
        if (slot.duration().compareTo(MAX_SLOT) > 0) {
            throw new IllegalArgumentException(
                    "Booking exceeds maximum duration");
        }
        for (Booking existing : bookings.findByRoom(roomId)) {
            if (existing.getSlot().overlaps(slot)) {
                throw new IllegalStateException(
                        "Room is already booked");
            }
        }
        for (Booking existing : bookings.findByUser(userId)) {
            if (existing.getSlot().overlaps(slot)) {
                throw new IllegalStateException(
                        "User already has an overlapping booking");
            }
        }
        Booking booking = new Booking(
                userId, roomId, slot);

        bookings.save(booking);

        return booking;
    }

    /** Cancel a user's booking. */
    public void cancel(
            String userId,
            String roomId,
            TimeSlot slot) {

        Booking target = new Booking(
                userId, roomId, slot);

        if (!bookings.findByUser(userId).contains(target)) {
            throw new IllegalArgumentException(
                    "Booking does not exist");
        }

        bookings.delete(target);
    }

    /** A user's bookings, earliest first. */
    public List<Booking> bookingsFor(String userId) {

        List<Booking> result = new java.util.ArrayList<>(
                bookings.findByUser(userId));

        result.sort(
                java.util.Comparator.comparing(
                        b -> b.getSlot().getStart()));

        return result;
    }
}