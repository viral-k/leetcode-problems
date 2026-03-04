# Approach

**Tags:** `String`, `Recursion`, `Bit Manipulation`

## Intuition

The string has a recursive structure: `Sn = Sn-1 + "1" + reverse(invert(Sn-1))`. Instead of building the entire string (which can be 2^20 - 1 characters), we can recursively determine the kth bit by analyzing its position relative to the middle.

## Solution

The length of `Sn` is `2^n - 1`, and the middle element (at position `2^(n-1)`) is always `"1"`.

**Three cases for position k:**

1. **k == mid**: Return `"1"` (middle is always 1)

2. **k < mid**: The bit is in `Sn-1`, so recursively find `findKthBit(n-1, k)`

3. **k > mid**: The bit is in `reverse(invert(Sn-1))`
   - Find the mirrored position: `mirror = 2^n - k`
   - Get the bit at that position in `Sn-1`
   - Return the inverted bit (0↔1)

### Example Walkthrough

For `n=4, k=11`:
- Length = 15, mid = 8
- k=11 > 8, so mirror position = 16 - 11 = 5
- Find bit at position 5 in S3, then invert
- S3 has mid=4, k=5 > 4, mirror = 8 - 5 = 3
- Find bit at position 3 in S2, then invert
- S2 = "011", position 3 is "1"
- Invert: "0", then invert again: "1"

## Complexity

- **Time:** O(n) — at most n recursive calls
- **Space:** O(n) — recursion stack depth

## Edge Cases

- n = 1 → always return "0"
- k at exact middle → always return "1"
- k = 1 → always return "0" (first bit never changes)
