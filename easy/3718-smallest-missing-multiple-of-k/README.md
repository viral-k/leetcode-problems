# 3718. Smallest Missing Multiple of K

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Math`, `Simulation`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/smallest-missing-multiple-of-k](https://yral.dev/leetcode/smallest-missing-multiple-of-k)
- **Problem:** [Smallest Missing Multiple of K on LeetCode](https://leetcode.com/problems/smallest-missing-multiple-of-k/)

## Idea

Walk the multiples of `k` in increasing order and return the first one that isn't present. A hash set makes each membership test O(1).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
