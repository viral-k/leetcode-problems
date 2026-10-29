# 214. Shortest Palindrome

**Difficulty:** Hard  
**Topics:** `String`, `String Matching`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/shortest-palindrome](https://yral.dev/leetcode/shortest-palindrome)
- **Problem:** [Shortest Palindrome on LeetCode](https://leetcode.com/problems/shortest-palindrome/)

## Idea

Characters may only be added in front, so the tail of `s` is fixed and whatever is prepended has to mirror a suffix of `s`. Concretely, if `s[0..k-1]` is a palindrome, then prepending `reverse(s[k..])` gives a palindrome of length `2n - k`. Making the result shortest means making `k` as large as possible, so the whole problem reduces to one question: what is the longest palindromic **prefix** of `s`?

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
