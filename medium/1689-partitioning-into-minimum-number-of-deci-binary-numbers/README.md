# 1689. Partitioning Into Minimum Number of Deci-Binary Numbers

**Difficulty:** Medium  
**Topics:** `String`, `Greedy`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/partitioning-into-minimum-number-of-deci-binary-numbers](https://yral.dev/leetcode/partitioning-into-minimum-number-of-deci-binary-numbers)
- **Problem:** [Partitioning Into Minimum Number of Deci-Binary Numbers on LeetCode](https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/)

## Idea

Each deci-binary number contributes at most 1 to each digit position. To build a digit `d`, we need at least `d` deci-binary numbers (each contributing 1 to that position). The answer is the maximum digit in `n`.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
