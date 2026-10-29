# 3300. Minimum Element After Replacement with Digit Sum

**Difficulty:** Easy  
**Topics:** `Array`, `Math`  
**Complexity:** time O(n * D), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-element-after-replacement-with-digit-sum](https://yral.dev/leetcode/minimum-element-after-replacement-with-digit-sum)
- **Problem:** [Minimum Element After Replacement with Digit Sum on LeetCode](https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/)

## Idea

Each number is independent. Replace a number by repeatedly taking its last digit and adding it to a running sum, then removing that digit.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
