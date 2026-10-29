# 2897. Apply Operations on Array to Maximize Sum of Squares

**Difficulty:** Hard  
**Topics:** `Array`, `Hash Table`, `Greedy`, `Bit Manipulation`  
**Complexity:** time O((n + k) * 30), space O(1)

- **Write-up:** [yral.dev/leetcode/apply-operations-on-array-to-maximize-sum-of-squares](https://yral.dev/leetcode/apply-operations-on-array-to-maximize-sum-of-squares)
- **Problem:** [Apply Operations on Array to Maximize Sum of Squares on LeetCode](https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/)

## Idea

Look at the operation one bit position at a time. Replacing `(a, b)` with `(a AND b, a OR b)` maps that bit's pair of values as `(1,1) -> (1,1)`, `(1,0) -> (0,1)`, `(0,1) -> (0,1)`, `(0,0) -> (0,0)`. In every case the number of set bits in the pair is unchanged. So for each bit position, the total count across the whole array is invariant: no operation can create or destroy a bit, only relocate it.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
