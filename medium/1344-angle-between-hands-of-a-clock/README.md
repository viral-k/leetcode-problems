# 1344. Angle Between Hands of a Clock

**Difficulty:** Medium  
**Topics:** `Math`, `Geometry`  
**Complexity:** time O(1), space O(1)

- **Write-up:** [yral.dev/leetcode/angle-between-hands-of-a-clock](https://yral.dev/leetcode/angle-between-hands-of-a-clock)
- **Problem:** [Angle Between Hands of a Clock on LeetCode](https://leetcode.com/problems/angle-between-hands-of-a-clock/)

## Idea

Each hand has a fixed angular speed, so we can compute the exact angle of each hand from the 12 o'clock position and take the difference. The only subtlety is that the hour hand also moves as the minutes pass — it is not fixed at the hour mark.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
