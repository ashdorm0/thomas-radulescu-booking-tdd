# NOTES

## Gaps

| Rule | What was unclear | Ruling | My test for it |
| ---- | ---------------- | ------ | -------------- |

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