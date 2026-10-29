# 68. Text Justification

**Difficulty:** Hard  
**Topics:** `Array`, `String`, `Simulation`, `Greedy`  
**Complexity:** time O(total characters), space O(maxWidth) excluding the output

- **Write-up:** [yral.dev/leetcode/text-justification](https://yral.dev/leetcode/text-justification)
- **Problem:** [Text Justification on LeetCode](https://leetcode.com/problems/text-justification/)

## Idea

Two independent jobs: deciding which words share a line, and spacing a line once its words are fixed. Keeping them separate is what stops this from turning into tangled index arithmetic.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
