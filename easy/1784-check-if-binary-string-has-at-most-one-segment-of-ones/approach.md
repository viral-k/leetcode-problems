# Approach

**Tags:** `String`

## Intuition

Since the string has no leading zeros (starts with `'1'`), if there's more than one segment of ones, we must see the pattern `"01"` — a zero followed by a one.

## Solution

If `"01"` appears in the string, it means a segment of ones ended and another begins later.

Simply check if the substring `"01"` exists:

- If `"01"` exists → return `false` (multiple segments)
- Otherwise → return `true` (at most one segment)

### Why This Works

Since `s[0] = '1'` (no leading zeros):

- All ones at the start form one segment
- If we see `"01"`, a new segment of ones started after some zeros
- If no `"01"`, all ones are contiguous at the beginning

## Complexity

- **Time:** O(n) — substring search
- **Space:** O(1) — no extra space

## Edge Cases

- Single `'1'` → true
- All ones `"111"` → true
- Ones then zeros `"110"` → true
- Pattern `"101"` → false (contains "01")
