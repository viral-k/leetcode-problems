# 3789. Minimum Cost to Acquire Required Items

**Difficulty:** Medium  
**Topics:** `Math`, `Greedy`  
**Complexity:** time O(1), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-cost-to-acquire-required-items](https://yral.dev/leetcode/minimum-cost-to-acquire-required-items)
- **Problem:** [Minimum Cost to Acquire Required Items on LeetCode](https://leetcode.com/problems/minimum-cost-to-acquire-required-items/)

## Idea

Only the number of type 3 items matters. Once that number `k` is fixed, the rest is forced: buy type 1 items for whatever of `need1` is still missing, and type 2 items for whatever of `need2` is still missing. So the cost is a function of one variable:

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
