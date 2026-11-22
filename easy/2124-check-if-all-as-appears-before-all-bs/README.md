# 2124. Check if All A's Appears Before All B's

**Difficulty:** Easy  
**Topics:** `String`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/check-if-all-as-appears-before-all-bs](https://yral.dev/leetcode/check-if-all-as-appears-before-all-bs)
- **Problem:** [Check if All A's Appears Before All B's on LeetCode](https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/)

## Idea

Every `'a'` comes before every `'b'` exactly when the string has the shape `a...ab...b`. Either part can be empty. The only thing that breaks that shape is a `'b'` immediately followed by an `'a'`. If the string had a `'b'` somewhere before an `'a'` without that adjacent pair, it would have to switch from `b` back to `a` at some point, and that switch is the pair `"ba"`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
