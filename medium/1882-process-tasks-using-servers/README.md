# 1882. Process Tasks Using Servers

**Difficulty:** Medium  
**Topics:** `Array`, `Heap (Priority Queue)`  
**Complexity:** time O((n + m) log n), space O(n + m)

- **Write-up:** [yral.dev/leetcode/process-tasks-using-servers](https://yral.dev/leetcode/process-tasks-using-servers)
- **Problem:** [Process Tasks Using Servers on LeetCode](https://leetcode.com/problems/process-tasks-using-servers/)

## Idea

At any moment, two questions need fast answers: which idle server has the smallest `(weight, index)`, and when does the next busy server become free. Each is a heap. The queue itself never needs storing, because tasks are assigned strictly in order. Task `j` starts at whichever is later: its arrival second `j`, or the start time of task `j - 1`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
