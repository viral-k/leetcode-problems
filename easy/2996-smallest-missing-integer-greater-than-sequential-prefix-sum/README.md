# 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Simulation`  
**Complexity:** time O(n + A), space O(n)

- **Write-up:** [yral.dev/leetcode/smallest-missing-integer-greater-than-sequential-prefix-sum](https://yral.dev/leetcode/smallest-missing-integer-greater-than-sequential-prefix-sum)
- **Problem:** [Smallest Missing Integer Greater Than Sequential Prefix Sum on LeetCode](https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/)

## Idea

A "sequential prefix" must start at index 0, so there's exactly one longest such prefix: the maximal run from the front where each element is one more than the previous. Sum it, then walk upward from that sum until hitting a value not in `nums`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
