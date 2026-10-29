# 3629. Minimum Jumps to Reach End via Prime Teleportation

**Difficulty:** Medium  
**Topics:** `Array`, `BFS`, `Number Theory`, `Hash Table`  
**Complexity:** time O(M log log M + n log M), M = max(nums), space O(M + n log M)

- **Write-up:** [yral.dev/leetcode/minimum-jumps-to-reach-end-via-prime-teleportation](https://yral.dev/leetcode/minimum-jumps-to-reach-end-via-prime-teleportation)
- **Problem:** [Minimum Jumps to Reach End via Prime Teleportation on LeetCode](https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/)

## Idea

Every move costs one jump, so this is a shortest-path problem on indices. Adjacent moves are simple, but teleport moves can be large: from a prime value `p`, we can jump to every index whose value is divisible by `p`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
