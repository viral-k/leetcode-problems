# 2914. Minimum Number of Changes to Make Binary String Beautiful

**Difficulty:** Medium  
**Topics:** `String`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-number-of-changes-to-make-binary-string-beautiful](https://yral.dev/leetcode/minimum-number-of-changes-to-make-binary-string-beautiful)
- **Problem:** [Minimum Number of Changes to Make Binary String Beautiful on LeetCode](https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/)

## Idea

The partition rule looks like it needs a DP over block boundaries, but it collapses to something local. Cut the string into aligned pairs `(s[0], s[1]), (s[2], s[3]), ...`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
