# 2463. Minimum Total Distance Traveled

**Difficulty:** Hard  
**Topics:** `Array`, `Dynamic Programming`, `Sorting`  
**Complexity:** time O(n × m) where m = sum of factory limits, space O(n × m)

- **Write-up:** [yral.dev/leetcode/minimum-total-distance-traveled](https://yral.dev/leetcode/minimum-total-distance-traveled)
- **Problem:** [Minimum Total Distance Traveled on LeetCode](https://leetcode.com/problems/minimum-total-distance-traveled/)

## Idea

After sorting both robots and factories by position, optimal assignments don't cross (if robot A is left of robot B, A's factory is not to the right of B's factory). This allows a DP solution.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
