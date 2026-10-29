# 3312. Sorted GCD Pair Queries

**Difficulty:** Hard  
**Topics:** `Array`, `Hash Table`, `Math`, `Number Theory`, `Binary Search`, `Counting`, `Prefix Sum`  
**Complexity:** time O(V log V + q log V), space O(V)

- **Write-up:** [yral.dev/leetcode/sorted-gcd-pair-queries](https://yral.dev/leetcode/sorted-gcd-pair-queries)
- **Problem:** [Sorted GCD Pair Queries on LeetCode](https://leetcode.com/problems/sorted-gcd-pair-queries/)

## Idea

There are up to `n*(n-1)/2 ≈ 5 * 10^9` pairs, so `gcdPairs` can never be built explicitly. But the **values** are small (`<= 5 * 10^4`), and the queries only ask "what value sits at sorted index q?". That's answerable from the *distribution* of GCD values: if we know how many pairs have each GCD `g`, the sorted array is fully determined, and a prefix sum plus binary search resolves any index.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
