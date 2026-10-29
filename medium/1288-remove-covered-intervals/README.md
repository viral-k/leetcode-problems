# 1288. Remove Covered Intervals

**Difficulty:** Medium  
**Topics:** `Array`, `Sorting`, `Greedy`  
**Complexity:** time O(n log n), space O(1)

- **Write-up:** [yral.dev/leetcode/remove-covered-intervals](https://yral.dev/leetcode/remove-covered-intervals)
- **Problem:** [Remove Covered Intervals on LeetCode](https://leetcode.com/problems/remove-covered-intervals/)

## Idea

Sort so that whenever one interval could cover another, the potential coverer is visited first. Sorting by left endpoint ascending guarantees every later interval has `l >= all previous lefts`, so coverage reduces to a single check on the right endpoint: a later interval is covered iff its right endpoint doesn't extend past the largest right seen so far.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
