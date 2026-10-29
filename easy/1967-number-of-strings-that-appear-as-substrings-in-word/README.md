# 1967. Number of Strings That Appear as Substrings in Word

**Difficulty:** Easy  
**Topics:** `Array`, `String`, `String Matching`  
**Complexity:** time O(n * |word| * |pattern|), space O(1)

- **Write-up:** [yral.dev/leetcode/number-of-strings-that-appear-as-substrings-in-word](https://yral.dev/leetcode/number-of-strings-that-appear-as-substrings-in-word)
- **Problem:** [Number of Strings That Appear as Substrings in Word on LeetCode](https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/)

## Idea

Just count how many patterns occur as a substring of `word`. With everything bounded by 100, a direct substring check per pattern is more than fast enough.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
