# 3225. Maximum Score from Grid Operations

**Difficulty:** Hard  
**Topics:** `Array`, `Dynamic Programming`, `Matrix`, `Prefix Sum`  
**Complexity:** time O(n^3), space O(n^2)

- **Write-up:** [yral.dev/leetcode/maximum-score-from-grid-operations](https://yral.dev/leetcode/maximum-score-from-grid-operations)
- **Problem:** [Maximum Score from Grid Operations on LeetCode](https://leetcode.com/problems/maximum-score-from-grid-operations/)

## Idea

For each column j, choose a "height" h[j] = number of black cells (0 to n). A white cell (i,j) scores if it's white (i >= h[j]) AND has adjacent black cell (i < h[j-1] OR i < h[j+1]).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
