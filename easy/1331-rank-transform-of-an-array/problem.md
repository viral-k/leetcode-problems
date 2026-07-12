# Rank Transform of an Array

**Difficulty:** Easy  
**LeetCode Link:** [Rank Transform of an Array](https://leetcode.com/problems/rank-transform-of-an-array/)

## Description

Given an array of integers `arr`, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

- Rank is an integer starting from 1.
- The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
- Rank should be as small as possible.

## Examples

### Example 1
```
Input: arr = [40,10,20,30]
Output: [4,1,2,3]
```

### Example 2
```
Input: arr = [100,100,100]
Output: [1,1,1]
```

### Example 3
```
Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]
```

## Constraints

- `0 <= arr.length <= 10^5`
- `-10^9 <= arr[i] <= 10^9`
