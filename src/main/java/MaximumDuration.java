class MaximumDuration implements BookingRule {

    @Override
    public void check(String userId, String roomId, TimeSlot slot) {
        if (slot.duration().compareTo(BookingService.MAX_SLOT) > 0) {
            throw new IllegalArgumentException(
                "Booking exceeds maximum duration"
            );
        }
    }
}