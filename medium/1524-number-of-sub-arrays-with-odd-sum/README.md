# 1524. Number of Sub-arrays with Odd Sum

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Dynamic Programming`, `Prefix Sum`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/number-of-sub-arrays-with-odd-sum](https://yral.dev/leetcode/number-of-sub-arrays-with-odd-sum)
- **Problem:** [Number of Sub-arrays with Odd Sum on LeetCode](https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/)

## Idea

With prefix sums `P`, the subarray `arr[i..j-1]` sums to `P[j] - P[i]`. A difference is odd exactly when the two numbers have different parities. So only the parity of each prefix sum matters, not its value.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
