# 2033. Minimum Operations to Make a Uni-Value Grid

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Sorting`, `Matrix`  
**Complexity:** time O(mn * log(mn)), space O(mn)

- **Write-up:** [yral.dev/leetcode/minimum-operations-to-make-a-uni-value-grid](https://yral.dev/leetcode/minimum-operations-to-make-a-uni-value-grid)
- **Problem:** [Minimum Operations to Make a Uni-Value Grid on LeetCode](https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/)

## Idea

1. All elements must have the same remainder mod x (otherwise impossible)
2. Target value should be the **median** (minimizes sum of absolute differences)
3. Operations = Σ |element - median| / x

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
