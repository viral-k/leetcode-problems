# 126. Word Ladder II

**Difficulty:** Hard  
**Topics:** `Hash Table`, `String`, `Backtracking`, `Breadth-First Search`  
**Complexity:** time O(n * L * 26) for the BFS, plus the output size, space O(n * L)

- **Write-up:** [yral.dev/leetcode/word-ladder-ii](https://yral.dev/leetcode/word-ladder-ii)
- **Problem:** [Word Ladder II on LeetCode](https://leetcode.com/problems/word-ladder-ii/)

## Idea

Words are nodes, one-letter differences are unit-weight edges, so shortest sequences are shortest paths. Enumerating all paths with plain DFS is hopeless; instead build the shortest-path DAG with BFS, then read all paths out of it.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
