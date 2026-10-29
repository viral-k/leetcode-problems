# 3310. Remove Methods from Project

**Difficulty:** Medium  
**Topics:** `Array`, `DFS`, `BFS`, `Graph`  
**Complexity:** time O(n + m), space O(n + m)

- **Write-up:** [yral.dev/leetcode/remove-methods-from-project](https://yral.dev/leetcode/remove-methods-from-project)
- **Problem:** [Remove Methods from Project on LeetCode](https://leetcode.com/problems/remove-methods-from-project/)

## Idea

The suspicious set is everything reachable from `k` along the invocation edges (directed graph). Those can be removed only if nothing *outside* the set calls into it — otherwise removing them would break a caller. If even one external caller points in, the rule forbids removal, so we keep everything.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
