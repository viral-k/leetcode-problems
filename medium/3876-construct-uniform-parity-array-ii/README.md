# 3876. Construct Uniform Parity Array II

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Counting`, `Greedy`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/construct-uniform-parity-array-ii](https://yral.dev/leetcode/construct-uniform-parity-array-ii)
- **Problem:** [Construct Uniform Parity Array II on LeetCode](https://leetcode.com/problems/construct-uniform-parity-array-ii/)

## Idea

As in part I, only parities matter — but the extra condition `nums1[i] - nums1[j] >= 1` restricts `j` to elements **strictly smaller** than `nums1[i]`, and that changes the answer substantially.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
