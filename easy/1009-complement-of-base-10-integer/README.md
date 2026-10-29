# 1009. Complement of Base 10 Integer

**Difficulty:** Easy  
**Topics:** `Bit Manipulation`  
**Complexity:** time O(log n), space O(1)

- **Write-up:** [yral.dev/leetcode/complement-of-base-10-integer](https://yral.dev/leetcode/complement-of-base-10-integer)
- **Problem:** [Complement of Base 10 Integer on LeetCode](https://leetcode.com/problems/complement-of-base-10-integer/)

## Idea

To flip all bits, XOR with a mask of all 1s. The mask must match the binary length of `n`, not the full integer width.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
