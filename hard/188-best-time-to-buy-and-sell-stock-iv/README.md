# 188. Best Time to Buy and Sell Stock IV

**Difficulty:** Hard  
**Topics:** `Array`, `Dynamic Programming`  
**Complexity:** time O(n * k), or O(n) when k allows unlimited transactions, space O(k)

- **Write-up:** [yral.dev/leetcode/best-time-to-buy-and-sell-stock-iv](https://yral.dev/leetcode/best-time-to-buy-and-sell-stock-iv)
- **Problem:** [Best Time to Buy and Sell Stock IV on LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)

## Idea

At most `k` transactions means a trader passes through `2k + 1` states in order: idle, holding share 1, sold share 1, holding share 2, and so on. Track the best cash balance reachable in each state and update them all as every price arrives. Cash goes negative on a buy and recovers on a sell, so the final answer is the balance after the last completed sale.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
