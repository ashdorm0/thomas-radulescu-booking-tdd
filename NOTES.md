# NOTES

## Gaps

| Rule | What was unclear | Ruling | My test for it |
|:-----|:-----------------|:-------|:---------------|
| R2 | Is a booking starting at the exact current time valid, or must it start strictly after now? | Awaiting lecturer clarification | Not written for a ruling |
| R6 | If duplicate identical bookings exist, should cancelling remove one or all of them? | Awaiting lecturer clarification | Not written for a ruling |
| R7 | If two bookings have the same start time, is a secondary sorting rule required? | Awaiting lecturer clarification | Not written for a ruling |
| Room | Should null or empty room IDs and names be rejected? | Awaiting lecturer clarification | Not written for a ruling |
| Booking | Should null user IDs, room IDs or TimeSlots be rejected by the constructor? | Awaiting lecturer clarification | Not written for a ruling |
## AI corrections (at least three)

### 1
- What I asked: For guidance implementing TimeSlot validation using TDD.
- What it produced: An initial constructor that checked whether the end time occurred after the start time.
- What was wrong: The initial implementation did not handle null inputs, which resulted in NullPointerException rather than the required IllegalArgumentException.
- The test that caught it: nullStartIsRejected() and nullEndIsRejected().
- Correction: Added explicit null validation before comparing the times.

### 2
- What I asked:
- What it produced:
- What was wrong:
- The test that caught it:

### 3
- What I asked:
- What it produced:
- What was wrong:
- The test that caught it: