# 3619. Count Islands with Total Value Divisible by K

**Difficulty:** Medium  
**Topics:** `Array`, `Depth-First Search`, `Breadth-First Search`, `Matrix`  
**Complexity:** time O(m * n), space O(m * n)

- **Write-up:** [yral.dev/leetcode/count-islands-with-total-value-divisible-by-k](https://yral.dev/leetcode/count-islands-with-total-value-divisible-by-k)
- **Problem:** [Count Islands with Total Value Divisible by K on LeetCode](https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/)

## Idea

Each island is a connected group of positive cells, so one flood fill per island
finds all of its cells. The only thing we need from each island is its total
value, and only modulo `k`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
