# Sum of GCD of Formed Pairs

**Difficulty:** Medium  
**LeetCode Link:** [Sum of GCD of Formed Pairs](https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/)

## Description

You are given an integer array `nums` of length `n`.

Construct an array `prefixGcd` where for each index `i`:

- Let `mx_i = max(nums[0], nums[1], ..., nums[i])`.
- `prefixGcd[i] = gcd(nums[i], mx_i)`.

After constructing `prefixGcd`:

- Sort `prefixGcd` in non-decreasing order.
- Form pairs by taking the smallest unpaired element and the largest unpaired element.
- Repeat this process until no more pairs can be formed.
- For each formed pair, compute the gcd of the two elements.
- If `n` is odd, the middle element in the `prefixGcd` array remains unpaired and should be ignored.

Return an integer denoting the sum of the GCD values of all formed pairs.

The term `gcd(a, b)` denotes the greatest common divisor of `a` and `b`.

## Examples

### Example 1
```
Input: nums = [2,6,4]
Output: 2
Explanation:
prefixGcd = [2, 6, 2] -> sorted [2, 2, 6]
Pair (2, 6): gcd = 2. Middle element 2 ignored. Sum = 2.
```

### Example 2
```
Input: nums = [3,6,2,8]
Output: 5
Explanation:
prefixGcd = [3, 6, 2, 8] -> sorted [2, 3, 6, 8]
Pairs: gcd(2, 8) = 2, gcd(3, 6) = 3. Sum = 5.
```

## Constraints

- `1 <= n == nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
