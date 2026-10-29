# 921. Minimum Add to Make Parentheses Valid

**Difficulty:** Medium  
**Topics:** `String`, `Stack`, `Greedy`  
**Complexity:** time O(n), space O(1)

- **Write-up:** [yral.dev/leetcode/minimum-add-to-make-parentheses-valid](https://yral.dev/leetcode/minimum-add-to-make-parentheses-valid)
- **Problem:** [Minimum Add to Make Parentheses Valid on LeetCode](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)

## Idea

Insertions are free to place anywhere, so the only thing that matters is how many brackets end up with no partner. Walk the string keeping a count of unmatched `(`. A `)` either pairs with one of those, or it has nothing before it to pair with and is therefore stranded, which forces inserting a `(` somewhere to its left.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
