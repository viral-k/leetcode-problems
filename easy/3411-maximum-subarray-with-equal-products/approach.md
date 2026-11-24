# Approach

**Tags:** `Array`, `Math`, `Sliding Window`, `Enumeration`, `Number Theory`

## Intuition

Look at a single prime `p` and the exponents of `p` in the elements. In the product those exponents add up. In the LCM we take the largest, in the GCD the smallest. So `prod = lcm * gcd` says that for every prime, the sum of the exponents equals the largest plus the smallest.

- **Length 2:** the largest plus the smallest is the whole sum, so every pair works. The answer is at least 2.
- **Length 3 or more:** every exponent other than the largest and the smallest has to be 0. There is at least one of those, and the smallest can't exceed it, so the smallest is 0 too. Only one element can be divisible by `p`. Since this holds for every prime, the elements are pairwise coprime.

So the task is to find the longest subarray where no prime divides two elements, with 2 as the floor. Values go up to 10, so only 2, 3, 5 and 7 matter.

## Approach

1. Keep `last[p]`, the last index with a value divisible by `p`, for `p` in 2, 3, 5, 7. Start each at -1.
2. Scan the array with a window start `left = 0`. For each `nums[i]` and each prime `p` that divides it:
   - move `left` to `max(left, last[p] + 1)`, so the earlier multiple of `p` is out of the window
   - set `last[p] = i`
3. The window `[left, i]` is now the longest coprime one ending at `i`. Update the answer with `i - left + 1`, starting from 2.

## Complexity

- **Time:** O(n), with four primes per element
- **Space:** O(1)

## Edge Cases

- No coprime neighbours (`[2, 2, 2]` or `[2, 4, 6]`): every window shrinks to one element, but any pair is valid, so the answer is 2
- All ones: no prime divides 1, so the whole array counts
- A single element `x > 1` isn't product equivalent (`x` vs `x * x`). It doesn't matter, because `n >= 2` guarantees a pair.
- Values with two primes (6, 10): both primes have to be checked, and `left` takes the later of the two cut points
- Prime powers (`4` after `2`): they share the prime 2 even though the values differ
