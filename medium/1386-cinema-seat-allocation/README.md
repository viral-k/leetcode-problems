# 1386. Cinema Seat Allocation

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Greedy`, `Bit Manipulation`, `Counting`  
**Complexity:** time O(m), space O(m)

- **Write-up:** [yral.dev/leetcode/cinema-seat-allocation](https://yral.dev/leetcode/cinema-seat-allocation)
- **Problem:** [Cinema Seat Allocation on LeetCode](https://leetcode.com/problems/cinema-seat-allocation/)

## Idea

`n` reaches 10^9, but there are at most 10^4 reservations — so the overwhelming majority of rows are completely empty. An empty row always seats exactly **2** groups: blocks `2-5` and `6-9` are disjoint, and no third group can fit alongside them. That gives a baseline of `2 * n`, and only the handful of rows containing a reservation need individual attention.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
