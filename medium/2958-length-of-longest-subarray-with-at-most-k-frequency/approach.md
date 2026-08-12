# Approach

**Tags:** `Array`, `Hash Table`, `Sliding Window`

## Intuition

The "good" property is **monotone under shrinking**: if a window satisfies "every frequency `<= k`", so does any sub-window of it. That's exactly the condition for a two-pointer sliding window — grow the right end greedily, and whenever the window breaks the rule, shrink from the left until it holds again.

Only one element can ever break the rule at a time: the one just added. So the shrink loop just needs to bring that element's count back down to `k`.

## Approach

1. Keep a hash map `freq` of counts inside the current window, and a left pointer `left`.
2. For each right index `r`:
   - Increment `freq[nums[r]]`.
   - While `freq[nums[r]] > k`, decrement `freq[nums[left]]` and advance `left`.
   - Update the answer with `r - left + 1`.
3. Return the largest window seen.

Each index enters and leaves the window at most once, so the total work is linear.

## Complexity

- **Time:** O(n) — amortized; `left` only moves forward
- **Space:** O(n) — the frequency map

## Edge Cases

- All identical values (Example 3) → answer is exactly `k`
- `k >= n` → the whole array is good → answer `n`
- `k = 1` → longest run of pairwise-distinct values
- Values up to 10^9 → use a hash map, not a fixed array
- The answer is always at least 1 since `k >= 1`
