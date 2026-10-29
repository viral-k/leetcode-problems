# 3942. Minimum Operations to Sort a Permutation

**Difficulty:** Medium  
**Topics:** `Array`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-operations-to-sort-a-permutation](https://yral.dev/leetcode/minimum-operations-to-sort-a-permutation)
- **Problem:** [Minimum Operations to Sort a Permutation on LeetCode](https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/)

## Idea

Rotating left and reversing generate the dihedral group. Rotation has order `n`,
reversal is its own inverse, and the two interact by
`reverse . rotate-left = rotate-right . reverse`. Everything reachable from
`nums` is therefore one of only `2n` arrays: the `n` rotations of `nums`, and the
`n` rotations of `reverse(nums)`. Any permutation outside that orbit is
unreachable, which is the whole story behind -1.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
