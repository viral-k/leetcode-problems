# 3336. Find the Number of Subsequences with Equal GCD

**Difficulty:** Hard  
**Topics:** `Array`, `Dynamic Programming`, `Number Theory`, `Math`  
**Complexity:** time O(n * V^2), space O(V^2)

- **Write-up:** [yral.dev/leetcode/find-the-number-of-subsequences-with-equal-gcd](https://yral.dev/leetcode/find-the-number-of-subsequences-with-equal-gcd)
- **Problem:** [Find the Number of Subsequences with Equal GCD on LeetCode](https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/)

## Idea

Each index of `nums` is independently placed into `seq1`, into `seq2`, or into neither — three choices. What matters about the two growing subsequences is only their current GCDs, and GCD values never exceed `max(nums) <= 200`. So a DP over `(gcd1, gcd2)` captures everything, and we count assignments where both are non-empty and the GCDs match.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
