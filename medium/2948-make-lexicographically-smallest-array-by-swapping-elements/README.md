# 2948. Make Lexicographically Smallest Array by Swapping Elements

**Difficulty:** Medium  
**Topics:** `Array`, `Union Find`, `Sorting`, `Greedy`  
**Complexity:** time O(n log n), space O(n)

- **Write-up:** [yral.dev/leetcode/make-lexicographically-smallest-array-by-swapping-elements](https://yral.dev/leetcode/make-lexicographically-smallest-array-by-swapping-elements)
- **Problem:** [Make Lexicographically Smallest Array by Swapping Elements on LeetCode](https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/)

## Idea

Swappability is **transitive** even though the stated condition isn't. If `a` can swap with `b` and `b` with `c`, then `a` and `c` can be exchanged too — route the values through `b`. So the real structure is the connected components of the "differs by at most `limit`" graph, and within a component **any** permutation of its values is reachable (transpositions along a spanning tree generate the full symmetric group).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
