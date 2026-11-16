# Approach

**Tags:** `Array`, `Math`, `Dynamic Programming`, `Prefix Sum`

## Intuition

With prefix sums `P`, the subarray `arr[i..j-1]` sums to `P[j] - P[i]`. A difference is odd exactly when the two numbers have different parities. So only the parity of each prefix sum matters, not its value.

For each end `j`, the number of odd subarrays ending there is the number of earlier prefixes (including the empty one, `P[0] = 0`) whose parity differs from `P[j]`. Two counters are enough.

## Approach

1. Start with `even = 1` (the empty prefix) and `odd = 0`, and `parity = 0`.
2. For each `x`: flip `parity` if `x` is odd.
   - If `parity` is odd, every even prefix so far starts an odd subarray ending here: `ans += even`, then `odd += 1`.
   - Otherwise `ans += odd`, then `even += 1`.
3. Return `ans % (10^9 + 7)`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Edge Cases

- All even values (example 2): every prefix is even, `odd` stays 0, answer 0
- All odd values: parities alternate, so roughly half of all subarrays are odd
- A single element: 1 if it is odd, else 0
- The empty prefix must be counted as even; without it, subarrays starting at index 0 are missed (in `[1]` the answer would be 0 instead of 1)
- The raw count reaches about `n^2 / 4 ≈ 2.5 * 10^9` for alternating parity, past `int`, so Java accumulates in `long` and takes the modulo once at the end
