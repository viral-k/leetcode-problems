# Approach

**Tags:** `Array`, `Greedy`, `Sorting`, `Binary Search`

## Intuition

Group sizes must be strictly increasing, so to maximize the count of groups, the cheapest valid sizes are `1, 2, 3, ..., k`, needing `k(k+1)/2` total usages. The specific numbers do not matter for *capacity* — distinctness only forbids repeating a number *within* one group, and there are always enough different numbers to spread a group across. So the problem reduces to: with the given per-number capacities, how large can `k` be?

Sorting ascending and accumulating lets smaller capacities "open" the small early groups while surplus carries forward to support the larger later groups.

## Approach

1. Sort `usageLimits` ascending.
2. Sweep left to right maintaining a running surplus and a group count:
   - add the current limit to `running`,
   - if `running >= groups + 1` (the size of the next group to form), subtract `groups + 1` and increment `groups`.
3. Return `groups`.

The carried surplus represents capacity not yet consumed; because we always try to complete the *smallest* outstanding group first, this greedy is optimal — any feasible assignment can be rearranged into this staircase.

## Complexity

- **Time:** O(n log n) — dominated by the sort
- **Space:** O(1) extra (in-place sort)

## Edge Cases

- All limits `1` -> only the first few small groups fit (e.g. `[1,1]` -> 1)
- Single element -> at most 1 group
- Very large limits -> the running surplus can reach ~10^14, so use 64-bit integers
- Many small then one huge limit -> surplus carries forward to extend the staircase
