# 282. Expression Add Operators

**Difficulty:** Hard  
**Topics:** `Math`, `String`, `Backtracking`  
**Complexity:** time O(n * 4^n), space O(n) besides the output

- **Write-up:** [yral.dev/leetcode/expression-add-operators](https://yral.dev/leetcode/expression-add-operators)
- **Problem:** [Expression Add Operators on LeetCode](https://leetcode.com/problems/expression-add-operators/)

## Idea

With at most 10 digits there are only `4^9` ways to fill the 9 gaps (`+`, `-`, `*`, or no operator), so trying them all is fine. What matters is evaluating each expression as it's built, instead of parsing it again at the end.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
