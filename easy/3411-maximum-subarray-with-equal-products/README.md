# 3411. Maximum Subarray with Equal Products

**Difficulty:** Easy  
**Topics:** `Array`, `Math`, `Sliding Window`, `Enumeration`, `Number Theory`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/maximum-subarray-with-equal-products](https://yral.dev/leetcode/maximum-subarray-with-equal-products)
- **Problem:** [Maximum Subarray with Equal Products on LeetCode](https://leetcode.com/problems/maximum-subarray-with-equal-products/)

## Idea

Look at a single prime `p` and the exponents of `p` in the elements. In the product those exponents add up. In the LCM we take the largest, in the GCD the smallest. So `prod = lcm * gcd` says that for every prime, the sum of the exponents equals the largest plus the smallest.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
