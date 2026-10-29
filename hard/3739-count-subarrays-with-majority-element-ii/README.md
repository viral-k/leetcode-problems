# 3739. Count Subarrays with Majority Element II

**Difficulty:** Hard  
**Topics:** `Array`, `Prefix Sum`, `Counting`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/count-subarrays-with-majority-element-ii](https://yral.dev/leetcode/count-subarrays-with-majority-element-ii)
- **Problem:** [Count Subarrays with Majority Element II on LeetCode](https://leetcode.com/problems/count-subarrays-with-majority-element-ii/)

## Idea

`target` is the majority of a subarray iff it appears strictly more than half the time. Map every element to `+1` if it equals `target`, else `-1`. Then in a subarray, `(#target) - (#non-target) > 0` exactly captures "strict majority". So a subarray is valid iff its **transformed sum is strictly positive**.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
