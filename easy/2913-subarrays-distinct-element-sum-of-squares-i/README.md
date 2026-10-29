# 2913. Subarrays Distinct Element Sum of Squares I

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`  
**Complexity:** time O(n^2), space O(V) where V = 100 is the value range

- **Write-up:** [yral.dev/leetcode/subarrays-distinct-element-sum-of-squares-i](https://yral.dev/leetcode/subarrays-distinct-element-sum-of-squares-i)
- **Problem:** [Subarrays Distinct Element Sum of Squares I on LeetCode](https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/)

## Idea

Recomputing the distinct count for each of the `O(n^2)` subarrays from scratch would be cubic. But the counts for subarrays sharing a left endpoint are related: extending `nums[i..j]` to `nums[i..j+1]` either introduces a value not yet in the window, raising the count by one, or repeats one already present and leaves it unchanged.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
