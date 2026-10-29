# 123. Best Time to Buy and Sell Stock III

**Difficulty:** Hard  
**Topics:** `Array`, `Dynamic Programming`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/best-time-to-buy-and-sell-stock-iii](https://yral.dev/leetcode/best-time-to-buy-and-sell-stock-iii)
- **Problem:** [Best Time to Buy and Sell Stock III on LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)

## Idea

At most two transactions means the trader passes through at most five states in order: nothing, holding the first share, sold it, holding the second share, sold it. Track the best cash balance reachable in each of the four action states, and update all four as each day's price arrives. Cash after a buy is negative (you paid), cash after a sell adds the price back.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
