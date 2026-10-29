# 3116. Kth Smallest Amount with Single Denomination Combination

**Difficulty:** Hard  
**Topics:** `Array`, `Binary Search`, `Bit Manipulation`, `Math`, `Number Theory`, `Combinatorics`  
**Complexity:** time O(2^m * log(k * minCoin)), space O(2^m)

- **Write-up:** [yral.dev/leetcode/kth-smallest-amount-with-single-denomination-combination](https://yral.dev/leetcode/kth-smallest-amount-with-single-denomination-combination)
- **Problem:** [Kth Smallest Amount with Single Denomination Combination on LeetCode](https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/)

## Idea

Since denominations can't be mixed, coin `c` produces exactly the multiples of `c`. The set of reachable amounts is therefore the **union of the multiple-sets** of all coins.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
