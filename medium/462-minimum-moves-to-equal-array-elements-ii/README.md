# 462. Minimum Moves to Equal Array Elements II

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `Sorting`  
**Complexity:** time O(n) expected, space O(n)

- **Write-up:** [yral.dev/leetcode/minimum-moves-to-equal-array-elements-ii](https://yral.dev/leetcode/minimum-moves-to-equal-array-elements-ii)
- **Problem:** [Minimum Moves to Equal Array Elements II on LeetCode](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/)

## Idea

Every element moves to a common target `t`, at a cost of `sum(|x - t|)`. Picture `t` on the number line: shifting it one step right makes it 1 closer to every element on its right and 1 farther from every element on its left. So the total keeps falling while more elements lie on one side than on the other, and it stops at the point where both sides are equal. That point is the median.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
