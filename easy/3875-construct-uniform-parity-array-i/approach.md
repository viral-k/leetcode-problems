# Approach

**Tags:** `Array`, `Math`, `Counting`, `Greedy`

## Intuition

The actual values are irrelevant — only **parities** are. For index `i` with parity `p_i`, the two allowed choices produce:

- `nums1[i]` → parity `p_i`
- `nums1[i] - nums1[j]` → parity `p_i XOR p_j`

So subtracting an **even** element leaves the parity at `p_i`, while subtracting an **odd** element flips it to `1 - p_i`. In other words, index `i` can reach the opposite parity **iff some odd element exists at a different index**.

Now check each target separately, with `cntOdd` and `cntEven` the parity counts:

**All even.** Even elements are already fine. An odd element must flip, which needs an odd element at another index — so a lone odd is stuck, but two or more odds can pair up. Hence all-even works iff `cntOdd != 1`.

**All odd.** Odd elements are already fine. An even element must flip, which needs any odd element (necessarily at a different index, since this one is even). Hence all-odd works iff there are no evens at all, or `cntOdd >= 1`.

The answer is whether either target is reachable.

## Approach

1. Count odds and evens in `nums1`.
2. `allEven = (cntOdd != 1)`.
3. `allOdd = (cntEven == 0) or (cntOdd >= 1)`.
4. Return `allEven or allOdd`.

## Complexity

- **Time:** O(n) — one counting pass
- **Space:** O(1)

## Edge Cases

- `n == 1` → no valid `j` exists, so only the direct choice is available; the formulas still hold (a single even gives `cntOdd = 0` → all-even true; a single odd gives `cntEven = 0` → all-odd true)
- Exactly one odd among evens → all-even fails, but all-odd succeeds (Example 1)
- All even → all-even trivially true (Example 2)
- All odd → all-odd trivially true
- The "different index" requirement is what makes `cntOdd == 1` fail for the all-even target
