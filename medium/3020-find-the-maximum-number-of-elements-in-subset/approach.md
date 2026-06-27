# Approach

**Tags:** `Array`, `Hash Table`, `Enumeration`

## Intuition

The valid arrangement `[x, x^2, ..., peak, ..., x^2, x]` is a symmetric chain of repeated squarings. Every value **below** the peak appears on both sides, so it needs **2 copies**; the **peak** appears once. The total length is always odd.

So for any base `x`, the best chain is: keep climbing `x -> x^2 -> x^4 -> ...` as long as the current value has at least 2 copies, then cap it with a peak.

## Approach

1. Count frequencies in a hash map.
2. **Base `x = 1`** is special: `1^2 = 1`, so a chain of ones is just ones. The length must be odd, so the answer is `freq[1]` if it's odd, else `freq[1] - 1`.
3. **For each distinct base `x > 1`:**
   - Start at `cur = x`, `count = 0`.
   - While `freq[cur] >= 2`: add 2 to `count`, then `cur = cur * cur`.
   - At exit `cur` has fewer than 2 copies:
     - If `freq[cur] >= 1`, it serves as the **peak**: `count += 1`.
     - Otherwise the chain can't be capped, so the last full level becomes the peak instead: `count -= 1`.
   - Update the answer with `count`.
4. Return the maximum found (always at least 1, since any single element forms `[x]`).

## Why the squaring stays bounded

`nums[i] <= 10^9`, so any value with a nonzero count is `<= 10^9`. We only square *after* confirming `freq[cur] >= 2`, so `cur` is a real key (`<= 10^9`) before squaring; the one square that overshoots reaches at most `10^18` (fits in `long`) and immediately fails the `freq` check, ending the loop.

## Complexity

- **Time:** O(n) — each distinct base climbs a chain of length O(log log(max)) at most, dominated by the O(n) counting
- **Space:** O(n) — the frequency map

## Edge Cases

- All ones → odd count or count − 1
- No repeats → every base yields a single peak → answer 1
- A pair `[x, x]` with no `x^2` → climbs once (count 2), no peak available, `count -= 1` → 1 (correct: only `[x]` is valid)
- Use `long` for `cur` in Java to avoid overflow on the squaring step
