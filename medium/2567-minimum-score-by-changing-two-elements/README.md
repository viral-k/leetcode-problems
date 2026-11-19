# 2567. Minimum Score by Changing Two Elements

**Difficulty:** Medium  
**Topics:** `Array`, `Greedy`, `Sorting`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-score-by-changing-two-elements](https://yral.dev/leetcode/minimum-score-by-changing-two-elements)
- **Problem:** [Minimum Score by Changing Two Elements on LeetCode](https://leetcode.com/problems/minimum-score-by-changing-two-elements/)

## Idea

The low score is a distraction. Whatever two elements get changed, set them to a value that is still in the array and lies between the remaining min and max. That makes a duplicate, so the low score is 0, and it doesn't widen the range. So the score is just `max - min` of the elements left untouched, and the question is which two elements to "remove" to make that range as small as possible.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
