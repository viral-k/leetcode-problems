# 2747. Count Zero Request Servers

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Sliding Window`, `Sorting`  
**Complexity:** time O(m log m + q log q + n), space O(n + m + q)

- **Write-up:** [yral.dev/leetcode/count-zero-request-servers](https://yral.dev/leetcode/count-zero-request-servers)
- **Problem:** [Count Zero Request Servers on LeetCode](https://leetcode.com/problems/count-zero-request-servers/)

## Idea

Each query asks how many distinct servers appear in the time window `[q - x, q]`, and the answer is `n` minus that. Handled one by one, each query would scan the logs. But every window has the same length, so if the queries are answered in increasing order, each window's start and end only move right. One sliding window over the sorted logs can answer all of them, as long as the results go back to each query's original position.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
