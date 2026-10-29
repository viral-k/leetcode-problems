# 220. Contains Duplicate III

**Difficulty:** Hard  
**Topics:** `Array`, `Sliding Window`, `Sorting`, `Bucket Sort`  
**Complexity:** time O(n), space O(min(n, indexDiff))

- **Write-up:** [yral.dev/leetcode/contains-duplicate-iii](https://yral.dev/leetcode/contains-duplicate-iii)
- **Problem:** [Contains Duplicate III on LeetCode](https://leetcode.com/problems/contains-duplicate-iii/)

## Idea

The textbook solution slides a window of width `indexDiff` and keeps its values
in an ordered set, asking for the nearest neighbour of each new value. That is
O(n log k). Bucketing gets the same answer in O(n).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
