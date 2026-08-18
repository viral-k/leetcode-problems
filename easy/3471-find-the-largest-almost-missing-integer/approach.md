# Approach

**Tags:** `Array`, `Hash Table`, `Enumeration`, `Counting`

## Intuition

"Appears in exactly one subarray of size `k`" is a direct counting question, and with `n <= 50` there are at most 50 windows to inspect. For each window take the **set** of values it holds (a value appearing twice inside one window still counts as that one window), tally across windows, and keep the values whose tally is 1.

Two boundary behaviours fall out for free:

- `k == 1`: each window is a single element, so a value's tally equals its number of occurrences — it qualifies iff it occurs exactly once.
- `k == n`: there is only one window, so every distinct value has tally 1 and the answer is simply the maximum.

## Approach

1. For each start index `i` in `[0, n - k]`, collect the distinct values in `nums[i .. i + k - 1]`.
2. Increment a counter for each distinct value in that window.
3. Return the largest value whose counter equals 1, or `-1` if none.

## Complexity

- **Time:** O(n * k) — every window scanned once
- **Space:** O(n) — the tally map

## Edge Cases

- No qualifying value (Example 3) → `-1`
- Duplicates inside a single window count that window once (hence the per-window set)
- `k == n` → one window → answer is `max(nums)`
- `k == 1` → answer is the largest value occurring exactly once
- Values may be `0`, so `-1` is a safe "not found" sentinel
