# 1606. Find Servers That Handled Most Number of Requests

**Difficulty:** Hard  
**Topics:** `Array`, `Heap (Priority Queue)`, `Simulation`  
**Complexity:** time O(n log k), space O(k)

- **Write-up:** [yral.dev/leetcode/find-servers-that-handled-most-number-of-requests](https://yral.dev/leetcode/find-servers-that-handled-most-number-of-requests)
- **Problem:** [Find Servers That Handled Most Number of Requests on LeetCode](https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/)

## Idea

Each request needs two things fast: release the servers whose work has finished, and find the first free server going clockwise from `i % k`. The first is a min-heap on end time. The second is usually an ordered set with a `ceiling` lookup plus a wrap-around, but a plain min-heap also works if each free server is stored under a shifted key instead of its id.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
