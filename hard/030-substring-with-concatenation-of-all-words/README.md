# 30. Substring with Concatenation of All Words

**Difficulty:** Hard  
**Topics:** `Hash Table`, `String`, `Sliding Window`  
**Complexity:** time O(n * L), space O(m * L)

- **Write-up:** [yral.dev/leetcode/substring-with-concatenation-of-all-words](https://yral.dev/leetcode/substring-with-concatenation-of-all-words)
- **Problem:** [Substring with Concatenation of All Words on LeetCode](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)

## Idea

Every word has the same length `L`, which makes the problem far more structured than a general permutation search: a valid window is always exactly `L * m` characters long (`m = len(words)`), and it must start at an index whose position **mod `L`** stays fixed throughout the window. So the string splits into `L` independent "tracks", one per starting offset, and within a track the text is just a sequence of `L`-sized blocks.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
