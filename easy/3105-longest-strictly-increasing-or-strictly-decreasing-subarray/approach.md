# Approach

**Tags:** `Array`

## Intuition

A strictly increasing subarray ending at `i` extends the one ending at `i - 1` exactly when `nums[i] > nums[i - 1]`; otherwise it starts over at length 1. The same holds for decreasing with `<`. So two running lengths are enough, and the answer is the largest value either one ever reaches.

## Approach

1. Start with `inc = dec = best = 1` (a single element counts as both).
2. For each `i` from 1:
   - `nums[i] > nums[i - 1]`: `inc += 1`, `dec = 1`
   - `nums[i] < nums[i - 1]`: `dec += 1`, `inc = 1`
   - equal: both reset to 1, since neither run can include an equal pair
3. After each step, `best = max(best, inc, dec)`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- A single element: the answer is 1
- All equal (example 2): every step resets, so the answer stays 1
- An equal pair inside a run (`[1, 2, 2, 3]`): it breaks the run, so the answer is 2, not 3
- The whole array is monotonic (example 3): the answer is `n`
- A run that changes direction (`[1, 3, 2]`): the peak element ends one run and starts the next, so the answer is 2
