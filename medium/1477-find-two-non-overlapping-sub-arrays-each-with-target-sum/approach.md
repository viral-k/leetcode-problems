# Approach

**Tags:** `Array`, `Hash Table`, `Binary Search`, `Dynamic Programming`, `Sliding Window`

## Intuition

Every element is positive, so as the right end of a window moves right, the left end only ever needs to move right too. That means a single sliding window visits every subarray whose sum is exactly `target`, and for each right index there is at most one such subarray.

Once we can enumerate target-sum subarrays left to right, pairing them is a prefix-minimum problem: when the window `[l..r]` hits `target`, the best partner is the shortest target-sum subarray that ends strictly before `l`. Keep a running array `best[i]` = shortest target-sum subarray ending at or before index `i`, and the partner is just `best[l-1]`.

## Approach

1. Maintain `best` of length `n`, initialised to infinity, and a window sum.
2. For each `r`, add `arr[r]`, then shrink from `l` while the sum exceeds `target`.
3. If the sum equals `target`:
   - `length = r - l + 1`
   - if `l > 0` and `best[l-1]` is finite, update the answer with `length + best[l-1]`
   - set `curBest = min(curBest, length)`
4. Set `best[r] = curBest` (prefix minimum so far).
5. Return the answer, or `-1` if it never got updated.

Every valid pair of non-overlapping subarrays has a right member; that right member is examined at step 3 with the optimal left partner, so the minimum found is exact.

## Complexity

- **Time:** O(n) — each index enters and leaves the window once
- **Space:** O(n) for the `best` array

## Edge Cases

- Single element array → at most one subarray, return `-1`
- Only one target-sum subarray anywhere → `-1` (Example 3)
- Two target-sum subarrays that share an endpoint are overlapping and must not be paired; using `best[l-1]` rather than `best[l]` enforces this
- Overlapping candidates like `[7],[3,4],[7]` where the shortest two are far apart (Example 2)
- `target` larger than the total sum → the window never matches, `-1`
- Answer sum of lengths can reach `n` exactly (e.g. two halves each summing to target)
