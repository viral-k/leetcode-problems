# 3041. Maximize Consecutive Elements in an Array After Modification

**Difficulty:** Hard  
**Topics:** `Array`, `Dynamic Programming`, `Sorting`  
**Complexity:** time O(n log n), space O(n)

- **Write-up:** [yral.dev/leetcode/maximize-consecutive-elements-in-an-array-after-modification](https://yral.dev/leetcode/maximize-consecutive-elements-in-an-array-after-modification)
- **Problem:** [Maximize Consecutive Elements in an Array After Modification on LeetCode](https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/)

## Idea

The selected values have to be distinct and form a run `v, v+1, ..., v+k-1`. Each element can stand for its own value `x` or for `x + 1`. In sorted order, an element can only extend a run that ends at `x - 1` (by staying `x`) or at `x` (by becoming `x + 1`). So track, for every value `v`, the longest run that ends exactly at `v`, using elements seen so far.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
