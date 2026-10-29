# 1545. Find Kth Bit in Nth Binary String

**Difficulty:** Medium  
**Topics:** `String`, `Recursion`, `Bit Manipulation`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/find-kth-bit-in-nth-binary-string](https://yral.dev/leetcode/find-kth-bit-in-nth-binary-string)
- **Problem:** [Find Kth Bit in Nth Binary String on LeetCode](https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/)

## Idea

The string has a recursive structure: `Sn = Sn-1 + "1" + reverse(invert(Sn-1))`. Instead of building the entire string (which can be 2^20 - 1 characters), we can recursively determine the kth bit by analyzing its position relative to the middle.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
