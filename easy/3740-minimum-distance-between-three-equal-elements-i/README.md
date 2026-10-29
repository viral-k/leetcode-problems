# 3740. Minimum Distance Between Three Equal Elements I

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/minimum-distance-between-three-equal-elements-i](https://yral.dev/leetcode/minimum-distance-between-three-equal-elements-i)
- **Problem:** [Minimum Distance Between Three Equal Elements I on LeetCode](https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/)

## Idea

For indices i < j < k, the distance simplifies to:
```
|i-j| + |j-k| + |k-i| = (j-i) + (k-j) + (k-i) = 2*(k-i)
```

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
