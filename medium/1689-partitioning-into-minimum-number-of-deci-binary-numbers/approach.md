# Approach

**Tags:** `String`, `Greedy`

## Intuition

Each deci-binary number contributes at most 1 to each digit position. To build a digit `d`, we need at least `d` deci-binary numbers (each contributing 1 to that position). The answer is the maximum digit in `n`.

## Solution

1. **Key insight**: Each deci-binary number has digits 0 or 1 only.

2. **Per-digit analysis**: To sum to digit `d` at any position, we need exactly `d` deci-binary numbers contributing 1 at that position.

3. **Maximum determines answer**: The digit requiring the most contributions dictates the minimum count.

4. **Return max digit**: Simply find and return the maximum digit in the string.

### Example Walkthrough

For `n = "32"`:
- Digit 3 at tens place needs 3 contributions
- Digit 2 at ones place needs 2 contributions
- Need at least 3 deci-binary numbers
- Solution: `10 + 11 + 11 = 32` ✓

## Complexity

- **Time:** O(n) — single pass to find max digit
- **Space:** O(1) — no extra space

## Edge Cases

- Single digit → return that digit
- All same digits → return that digit
- Contains '0' → doesn't affect answer (0 needs 0 contributions)
