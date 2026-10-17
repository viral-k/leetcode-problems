# Approach

**Tags:** `Array`, `Hash Table`, `Sorting`

## Intuition

The target arrangement is not ambiguous. The values are distinct, so the key `(digit sum, value)` is distinct for every element and the sorted order is unique — there is no choice to make about where anything goes. The question is only how cheaply we can get there by swapping.

Minimum swaps between two known arrangements is a cycle-counting problem. Write `order[t]` for the original index of the element that belongs at position `t`; this is a permutation of `0..n-1`. Decompose it into cycles. Swapping two elements that sit in the same cycle splits that cycle in two; swapping across two cycles merges them into one. We begin with `c` cycles and have to finish with `n` (every element a fixed point), so no swap raises the cycle count by more than one and at least `n - c` swaps are needed. That bound is reached by walking each cycle and putting one element home per swap, so a cycle of length `k` costs exactly `k - 1`.

Answer: `n - (number of cycles)`.

## Approach

1. For each index `i` compute `digit_sum(nums[i])` by repeatedly taking `% 10` and `// 10`.
2. Sort the indices `0..n-1` by `(digit_sum, value)`. Call the result `order`, so `order[t]` is the index whose element belongs at position `t`.
3. Walk `order` with a `visited` array. For each unvisited `t`, follow `t -> order[t] -> order[order[t]] -> ...` until it returns, marking as you go, and add `length - 1` to the answer.
4. Return the total.

Fixed points are cycles of length 1 and contribute 0, which is why an already-sorted array needs no special case.

In Java the key and the index are packed into one `long` — `(digitSum * 1_000_000_001 + value) << 17 | index` — so `Arrays.sort` runs on a primitive `long[]` instead of boxing into `Integer[]` with a comparator. Digit sum is at most 81 and value at most `10^9`, so the key fits in 37 bits; shifting by 17 leaves room for indices up to 131071, above the `10^5` limit.

## Complexity

- **Time:** O(n log n) — the sort dominates, cycle counting visits each index once
- **Space:** O(n)

## Edge Cases

- Already in the target order → every cycle has length 1 → 0, matching example 2
- Single element → 0
- Equal digit sums → broken by the value, so example 3 sorts `[18,43,34,16]` to `[16,34,43,18]` rather than leaving it alone
- Values are distinct, so the sort key never ties and `order` is a genuine permutation; duplicates would make the target order non-unique and this argument would need the cheapest matching instead
- Digit sum of a 9-digit number is at most 81, well inside `int`
- A single large cycle costs `n - 1` swaps, the worst case
