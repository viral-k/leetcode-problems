# Approach

**Tags:** `Array`, `Greedy`, `Sorting`

## Intuition

Two simplifications collapse this problem almost entirely.

First, the sign of each element is irrelevant: every term in the score is a square, so `-3` and `3` are interchangeable. Only `|nums[i]|` matters.

Second, the structure of the alternating sum is fixed by the length alone. In an array of `n` elements the added positions are `0, 2, 4, ...`, so there are exactly `ceil(n / 2)` of them, and the subtracted positions number `floor(n / 2)`. Rearrangement is unrestricted, so any partition of the elements into a group of size `ceil(n / 2)` and a group of size `floor(n / 2)` is realisable by some ordering. The order *within* each group never matters either.

So the problem is just: pick `ceil(n / 2)` elements to add and subtract the rest, maximising the total. That is maximised by adding the largest squares and subtracting the smallest, with no interaction between the choices.

Finding the largest `ceil(n / 2)` squares does not need a full comparison sort. The values are bounded by `4 * 10^4`, so counting the absolute values and sweeping downward is O(n + V), which beats O(n log n) at these sizes.

## Approach

1. `add = (n + 1) // 2`, the number of positions that contribute positively.
2. Count occurrences of `abs(v)` for each element into `cnt`, indexed `0 .. 40000`.
3. Sweep `a` from `40000` down to `0`. For a value with count `c`:
   - `take = min(c, add)` of them go to the added side: `total += take * a * a`, `add -= take`
   - the remaining `c - take` go to the subtracted side: `total -= (c - take) * a * a`
4. Return `total`.

Sweeping from the top guarantees the added side receives the largest squares, so the greedy is exactly the optimum described above.

## Complexity

- **Time:** O(n + V) where `V = 4 * 10^4`
- **Space:** O(V)

## Edge Cases

- `n = 1` → one added position, so the answer is `nums[0]^2`, always non-negative
- `n = 2` → the larger square minus the smaller, which can be 0 when the magnitudes match
- All magnitudes equal → the added and subtracted counts differ by at most one, so the answer is `a^2` for odd `n` and 0 for even `n`
- Negative inputs are handled purely by taking absolute values; `[1,-1,2,-2,3,-3]` behaves identically to `[1,1,2,2,3,3]`
- Zeros contribute nothing on either side
- The answer is never negative: the added side holds at least as many elements as the subtracted side and takes the largest squares
- Overflow: the magnitude reaches `5 * 10^4 * (4 * 10^4)^2 = 8 * 10^13`, which needs a 64-bit accumulator. The Java signature returns `long` for this reason.
