# 212. Word Search II

**Difficulty:** Hard  
**Topics:** `Array`, `String`, `Backtracking`, `Trie`, `Matrix`  
**Complexity:** time O(cells * 4 * 3^(L-1)) worst case, plus O(total word length) to build, space O(total word length)

- **Write-up:** [yral.dev/leetcode/word-search-ii](https://yral.dev/leetcode/word-search-ii)
- **Problem:** [Word Search II on LeetCode](https://leetcode.com/problems/word-search-ii/)

## Idea

Running the single-word search 30,000 times is the obvious approach and far too slow: each run re-walks the same board prefixes. The fix is to turn the word list inside out. Put the words in a trie, then do one DFS per starting cell that descends the board and the trie together. Words sharing a prefix share that descent, and a path dies the moment the board letter has no matching trie child.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
