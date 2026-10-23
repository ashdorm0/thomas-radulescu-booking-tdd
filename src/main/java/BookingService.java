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
        new RoomMustExist(rooms).check(userId, roomId, slot);
        new BookingMustBeFuture(clock).check(userId, roomId, slot);
        new MaximumDuration().check(userId, roomId, slot);
        checkRoomOverlap(roomId, slot);
        checkUserOverlap(userId, slot);

        Booking booking = new Booking(
                userId, roomId, slot);

        bookings.save(booking);

        return booking;
    }

    private void checkRoomOverlap(String roomId, TimeSlot slot) {
        if (hasOverlap(bookings.findByRoom(roomId), slot)) {
            throw new IllegalStateException(
                    "Room is already booked");
        }
    }

    private void checkUserOverlap(String userId, TimeSlot slot) {
        if (hasOverlap(bookings.findByUser(userId), slot)) {
            throw new IllegalStateException(
                    "User already has an overlapping booking");
        }
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

    private boolean hasOverlap(
            List<Booking> existingBookings,
            TimeSlot requestedSlot) {

        for (Booking booking : existingBookings) {
            if (booking.getSlot().overlaps(requestedSlot)) {
                return true;
            }
        }

        return false;
    }
}