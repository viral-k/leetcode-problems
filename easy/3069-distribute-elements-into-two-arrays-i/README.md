# 3069. Distribute Elements Into Two Arrays I

**Difficulty:** Easy  
**Topics:** `Array`, `Simulation`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/distribute-elements-into-two-arrays-i](https://yral.dev/leetcode/distribute-elements-into-two-arrays-i)
- **Problem:** [Distribute Elements Into Two Arrays I on LeetCode](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/)

## Idea

The rule is stated procedurally and depends only on the two arrays' **last** elements, so there is nothing to optimize — just follow it step by step. Each array is append-only, so its last element is always available in O(1).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
