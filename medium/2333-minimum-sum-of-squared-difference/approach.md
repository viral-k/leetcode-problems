# Approach

**Tags:** `Array`, `Math`, `Binary Search`, `Sorting`, `Heap (Priority Queue)`, `Greedy`, `Counting`

## Intuition

The pairing is fixed, so the only thing that matters about index `i` is the absolute difference `d[i] = |nums1[i] - nums2[i]|`. One operation on either array changes one `d[i]` by exactly 1, which means `k1` and `k2` are interchangeable and collapse into a single budget `k = k1 + k2`.

Two observations shrink the search space. Increasing a difference never helps, since every term is a square of a non-negative quantity. And driving a difference below zero is pointless: the square starts growing again, so 0 is the floor.

That leaves: distribute `k` unit reductions across the `d` values to minimise `Σ d[i]²`. Reducing a value from `v` to `v - 1` saves `v² - (v - 1)² = 2v - 1`, which is monotone increasing in `v`, so the biggest saving is always on the current largest value. Greedily cutting the maximum is therefore optimal, and ties among equal maxima can be taken in any order.

Doing that one unit at a time would be far too slow with `k` up to `2 * 10^9`. But the values are bounded by `10^5`, so bucket them by value and move whole buckets. Sweeping from the top, each value level is visited once, giving a linear pass rather than a simulation of `k` steps.

## Approach

1. Build `d[i] = abs(nums1[i] - nums2[i])` and `k = k1 + k2`.
2. If `sum(d) <= k`, every difference can be zeroed, so return 0.
3. Count into `cnt[v]` for `v` up to `max(d)`.
4. For `v` from `max(d)` down to 1:
   - if `cnt[v] == 0`, skip
   - if `k >= cnt[v]`, move the whole bucket down: `k -= cnt[v]`, `cnt[v-1] += cnt[v]`, `cnt[v] = 0`
   - otherwise move only `k` of them: `cnt[v] -= k`, `cnt[v-1] += k`, `k = 0`, stop
5. Return `Σ v² * cnt[v]`.

Elements pushed from `v` to `v - 1` are reconsidered when the sweep reaches `v - 1`, which is exactly the behaviour wanted: the maximum keeps falling while budget remains. Because `v` only ever decreases, the whole sweep is O(max(d)).

An alternative binary search on the final cap value also works, needing a separate step to spend the leftover budget on values sitting exactly at the cap. It costs O(n log V) and is easier to get wrong on that remainder, so the counting sweep is used here.

## Complexity

- **Time:** O(n + V) where `V = max(d) <= 10^5`
- **Space:** O(V) for the counts

## Edge Cases

- `k1 = k2 = 0` → no modifications, return the raw sum of squares (Example 1)
- `sum(d) <= k` → 0, every difference is zeroed and budget may remain unused
- Budget running out mid-bucket is the common case; only part of the bucket moves down, leaving values at both `v` and `v - 1` (Example 2 ends with one 4 and three 3s)
- Arrays already equal → all differences 0, answer 0 regardless of budget
- Negative intermediate values are allowed by the statement but never useful, so the floor stays at 0
- `k1 + k2` reaches `2 * 10^9`, which overflows a 32-bit `int` in Java; the budget must be `long`
- The answer reaches `10^5 * (10^5)^2 = 10^15`, so the accumulator must be `long` too
