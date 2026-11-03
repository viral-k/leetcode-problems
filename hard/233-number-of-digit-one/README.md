# 233. Number of Digit One

**Difficulty:** Hard  
**Topics:** `Math`, `Dynamic Programming`, `Recursion`  
**Complexity:** time O(log n), space O(1)

- **Write-up:** [yral.dev/leetcode/number-of-digit-one](https://yral.dev/leetcode/number-of-digit-one)
- **Problem:** [Number of Digit One on LeetCode](https://leetcode.com/problems/number-of-digit-one/)

## Idea

Instead of counting the 1s in each number, count, for each digit position, how many numbers in `0..n` have a 1 there. The digit at position `p` (1, 10, 100, ...) cycles through `0..9`, each value held for `p` consecutive numbers, so every block of `10p` numbers has exactly `p` numbers with a 1 at that position. Only the last, partial block needs care.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
