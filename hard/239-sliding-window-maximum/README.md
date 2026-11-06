# 239. Sliding Window Maximum

**Difficulty:** Hard  
**Topics:** `Array`, `Sliding Window`, `Heap (Priority Queue)`  
**Complexity:** time O(n), space O(k)

- **Write-up:** [yral.dev/leetcode/sliding-window-maximum](https://yral.dev/leetcode/sliding-window-maximum)
- **Problem:** [Sliding Window Maximum on LeetCode](https://leetcode.com/problems/sliding-window-maximum/)

## Idea

A heap gives O(n log n), but most of what it stores is useless. If a new element `b` arrives and an older element `a` in the window has `a <= b`, then `a` can never be a maximum again: `b` is at least as large and stays in the window longer. So only elements with nothing as large to their right matter. Those form a strictly decreasing sequence, and its first element is the window's maximum.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
