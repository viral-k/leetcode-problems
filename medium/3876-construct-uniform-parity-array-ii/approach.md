# Approach

**Tags:** `Array`, `Math`, `Counting`, `Greedy`

## Intuition

As in part I, only parities matter — but the extra condition `nums1[i] - nums1[j] >= 1` restricts `j` to elements **strictly smaller** than `nums1[i]`, and that changes the answer substantially.

Subtracting an even leaves the parity alone; subtracting an odd flips it. So:

> index `i` can flip its parity **iff some odd element is strictly smaller than `nums1[i]`**.

Let `minOdd` be the smallest odd value and `minEven` the smallest even value.

**All even.** Every odd element has to flip. But the *smallest* odd element has no odd below it, so it can never flip — it is stuck being odd. Therefore all-even is possible only when there are **no odd elements at all**.

**All odd.** Every even element has to flip, which needs an odd strictly below it. The binding case is the smallest even, so the condition is `minOdd < minEven` (or there are no evens, in which case it holds trivially).

Compare with part I, where subtraction had no ordering restriction: there, all-even merely required `cntOdd != 1`. Here the "smallest odd is stranded" argument kills it entirely whenever any odd exists.

## Approach

1. Count odds and evens, and track `minOdd` and `minEven` in the same pass.
2. `allEven = (cntOdd == 0)`.
3. `allOdd = (cntEven == 0) or (cntOdd >= 1 and minOdd < minEven)`.
4. Return `allEven or allOdd`.

## Complexity

- **Time:** O(n) — one pass
- **Space:** O(1)

## Edge Cases

- `n == 1` → no valid `j`; a single even satisfies all-even, a single odd satisfies all-odd
- Any odd present → all-even is impossible, no matter how many odds there are
- Smallest element is even with odds above it (Example 2: `[2,3]`) → the even `2` cannot flip → `false`
- All even → all-even trivially true (Example 3)
- All odd → all-odd trivially true
- Only `minOdd` versus `minEven` matters; larger evens are automatically covered once the smallest one is
