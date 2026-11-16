# 273. Integer to English Words

**Difficulty:** Hard  
**Topics:** `Math`, `String`, `Recursion`  
**Complexity:** time O(1), at most 4 chunks of 3 digits, space O(1)

- **Write-up:** [yral.dev/leetcode/integer-to-english-words](https://yral.dev/leetcode/integer-to-english-words)
- **Problem:** [Integer to English Words on LeetCode](https://leetcode.com/problems/integer-to-english-words/)

## Idea

English reads numbers in groups of three digits. 1,234,567 is "one million", "two hundred thirty four thousand", "five hundred sixty seven". Each group is said the same way, as a number from 1 to 999, followed by its scale word. So the whole problem is a 1–999 converter plus a loop over at most four groups (`2^31 - 1` is just over two billion).

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
