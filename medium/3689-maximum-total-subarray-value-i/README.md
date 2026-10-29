# 3689. Maximum Total Subarray Value I

**Difficulty:** Medium  
**Topics:** `Array`, `Greedy`, `Math`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-total-subarray-value-i](https://yral.dev/leetcode/maximum-total-subarray-value-i)
- **Problem:** [Maximum Total Subarray Value I on LeetCode](https://leetcode.com/problems/maximum-total-subarray-value-i/)

## Idea

For any subarray, `max - min` can never exceed the difference between the global maximum and the global minimum of the whole array, because narrowing the window can only lower the max or raise the min. The full array itself achieves exactly `globalMax - globalMin`, so that is the largest value any single subarray can have.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
