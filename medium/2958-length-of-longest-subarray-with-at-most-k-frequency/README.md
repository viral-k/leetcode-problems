# 2958. Length of Longest Subarray with at Most K Frequency

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Sliding Window`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/length-of-longest-subarray-with-at-most-k-frequency](https://yral.dev/leetcode/length-of-longest-subarray-with-at-most-k-frequency)
- **Problem:** [Length of Longest Subarray with at Most K Frequency on LeetCode](https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/)

## Idea

The "good" property is **monotone under shrinking**: if a window satisfies "every frequency `<= k`", so does any sub-window of it. That's exactly the condition for a two-pointer sliding window — grow the right end greedily, and whenever the window breaks the rule, shrink from the left until it holds again.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
