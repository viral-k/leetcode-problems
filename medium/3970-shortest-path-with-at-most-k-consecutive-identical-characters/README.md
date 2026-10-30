# 3970. Shortest Path with at Most K Consecutive Identical Characters

**Difficulty:** Medium  
**Topics:** `Graph`, `String`, `Heap (Priority Queue)`, `Shortest Path`  
**Complexity:** time O(k * (n + m) log(n * k)), space O(n * k + m)

- **Write-up:** [yral.dev/leetcode/shortest-path-with-at-most-k-consecutive-identical-characters](https://yral.dev/leetcode/shortest-path-with-at-most-k-consecutive-identical-characters)
- **Problem:** [Shortest Path with at Most K Consecutive Identical Characters on LeetCode](https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/)

## Idea

The labels along a path only matter through the length of the current run of identical characters. Moving along `u -> v` either extends the run (same label) or resets it to 1 (different label). So expand each node into states `(node, run)` with `1 <= run <= k`, and run Dijkstra on that layered graph. That's at most `n * k` states, about 2.5 * 10^6.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
