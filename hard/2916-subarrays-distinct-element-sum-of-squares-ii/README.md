# 2916. Subarrays Distinct Element Sum of Squares II

**Difficulty:** Hard  
**Topics:** `Array`, `Hash Table`, `Binary Indexed Tree`, `Segment Tree`  
**Complexity:** time O(n log n), space O(n)

- **Write-up:** [yral.dev/leetcode/subarrays-distinct-element-sum-of-squares-ii](https://yral.dev/leetcode/subarrays-distinct-element-sum-of-squares-ii)
- **Problem:** [Subarrays Distinct Element Sum of Squares II on LeetCode](https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/)

## Idea

Sweep the right endpoint and keep, for every left endpoint `i`, the distinct count `D[i]` of `nums[i..j]`. The answer is the running total of `S2 = sum of D[i]^2` taken after each step, since that sum is exactly the contribution of all subarrays ending at `j`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
