# 2778. Sum of Squares of Special Elements

**Difficulty:** Easy  
**Topics:** `Array`, `Math`, `Enumeration`  
**Complexity:** time O(sqrt(n)), space O(1)

- **Write-up:** [yral.dev/leetcode/sum-of-squares-of-special-elements](https://yral.dev/leetcode/sum-of-squares-of-special-elements)
- **Problem:** [Sum of Squares of Special Elements on LeetCode](https://leetcode.com/problems/sum-of-squares-of-special-elements/)

## Idea

The special positions are exactly the divisors of `n`, and there are far fewer of those than there are elements. Rather than testing `n % i == 0` for every index, enumerate the divisors directly: walk `i` from 1 while `i * i <= n`, and whenever `i` divides `n`, both `i` and `n / i` are divisors. That touches only O(sqrt(n)) indices.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
