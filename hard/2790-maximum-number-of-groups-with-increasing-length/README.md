# 2790. Maximum Number of Groups with Increasing Length

**Difficulty:** Hard  
**Topics:** `Array`, `Greedy`, `Sorting`, `Binary Search`  
**Complexity:** time O(n log n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-number-of-groups-with-increasing-length](https://yral.dev/leetcode/maximum-number-of-groups-with-increasing-length)
- **Problem:** [Maximum Number of Groups with Increasing Length on LeetCode](https://leetcode.com/problems/maximum-number-of-groups-with-increasing-length/)

## Idea

Group sizes must be strictly increasing, so to maximize the count of groups, the cheapest valid sizes are `1, 2, 3, ..., k`, needing `k(k+1)/2` total usages. The specific numbers do not matter for *capacity* — distinctness only forbids repeating a number *within* one group, and there are always enough different numbers to spread a group across. So the problem reduces to: with the given per-number capacities, how large can `k` be?

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
