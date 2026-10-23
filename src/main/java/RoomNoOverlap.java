class RoomNoOverlap implements BookingRule {

    private final IBookingRepository bookings;

    RoomNoOverlap(IBookingRepository bookings) {
        this.bookings = bookings;
    }

    @Override
    public void check(String userId, String roomId, TimeSlot slot) {
        for (Booking existing : bookings.findByRoom(roomId)) {
            if (existing.getSlot().overlaps(slot)) {
                throw new IllegalStateException(
                    "Room is already booked"
                );
            }
        }
    }
}