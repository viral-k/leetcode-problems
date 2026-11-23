# 1352. Product of the Last K Numbers

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Design`, `Prefix Sum`  
**Complexity:** time O(1) per add and getProduct, space O(n)

- **Write-up:** [yral.dev/leetcode/product-of-the-last-k-numbers](https://yral.dev/leetcode/product-of-the-last-k-numbers)
- **Problem:** [Product of the Last K Numbers on LeetCode](https://leetcode.com/problems/product-of-the-last-k-numbers/)

## Idea

Products of a window work like sums of a window: keep prefix products, and the last `k` numbers multiply to `prefix[n] / prefix[n - k]`. That makes both operations O(1).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
