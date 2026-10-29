# 192. Word Frequency

**Difficulty:** Medium  
**Topics:** `Shell`, `Sorting`, `Counting`  
**Complexity:** time O(w log w), space O(w)

- **Write-up:** [yral.dev/leetcode/word-frequency](https://yral.dev/leetcode/word-frequency)
- **Problem:** [Word Frequency on LeetCode](https://leetcode.com/problems/word-frequency/)

## Idea

Word counting is a textbook Unix pipeline: get one word per line, group identical words together by sorting, let `uniq -c` tally them, then order by count.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.sh](solution.sh) | Bash solution |
| [problem.md](problem.md) | Problem statement |
