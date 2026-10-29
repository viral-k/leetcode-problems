# 347. Top K Frequent Elements

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Bucket Sort`  
**Complexity:** time O(n), space O(n)

- **Write-up:** [yral.dev/leetcode/top-k-frequent-elements](https://yral.dev/leetcode/top-k-frequent-elements)
- **Problem:** [Top K Frequent Elements on LeetCode](https://leetcode.com/problems/top-k-frequent-elements/)

## Idea

Use bucket sort where index = frequency. Since max frequency is n, we create n+1 buckets. Elements with same frequency go in same bucket. Iterate buckets from high to low frequency to get top k.

## Files

| File | Contents |
|------|----------|
| [approach.md](approach.md) | Intuition, approach, complexity, edge cases |
| [solution.py](solution.py) | Python solution |
| [solution.java](solution.java) | Java solution |
| [problem.md](problem.md) | Problem statement |
