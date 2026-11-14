# Approach

**Tags:** `Array`, `Sliding Window`, `Prefix Sum`

## Intuition

With prefix sums `P`, the subarray `nums[i..j-1]` sums to `P[j] - P[i]`, and its length is `j - i`. Fix the end `j`. The length constraint `l <= j - i <= r` means the start `i` must lie in `[j - r, j - l]`, and that range slides right by one as `j` grows.

For a fixed `j`, the sum `P[j] - P[i]` is positive and as small as possible when `P[i]` is the largest value still strictly below `P[j]`. That is a predecessor query on the prefix sums in the window, which a sorted multiset answers in O(log n).

Trying every length for every end is O(n * (r - l + 1)) and passes easily at `n <= 100`. The sorted window removes the dependence on `r - l`.

## Approach

1. Build `P` with `P[0] = 0`.
2. For `j` from `l` to `n`:
   - Add `P[j - l]` to the window (the newest allowed start).
   - If `j - r - 1 >= 0`, remove `P[j - r - 1]` (that start would make the subarray longer than `r`).
   - Find the largest value in the window that is `< P[j]`. If it exists, update `best` with `P[j]` minus it.
3. Return `best`, or `-1` if nothing was found.

Java keeps the window in a `TreeMap<Integer, Integer>` used as a multiset (equal prefix sums are common) and calls `lowerKey`. Python uses `bisect` on a sorted list. Its searches are O(log r), but `insort` and `pop` shift elements, so the honest bound is O(n * r). That's irrelevant at this size, and it avoids depending on `sortedcontainers`.

## Complexity

- **Time:** O(n log n) in Java; O(n * r) in Python because of list shifts
- **Space:** O(n)

## Edge Cases

- No positive sum anywhere (example 2): return `-1`
- A sum of exactly 0 is not positive, so the predecessor search must be strict (`lowerKey`, `bisect_left - 1`), not `floorKey`
- Equal prefix sums inside the window: the window has to be a multiset, or removing one copy would drop another start that is still allowed
- `l = r`: the window holds a single prefix sum, so this becomes a fixed-size sliding window
- `l = 1`: single elements count, so any positive element is a candidate
- Sums stay within `100 * 1000`, so `int` is fine
