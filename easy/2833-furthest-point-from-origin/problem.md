# Furthest Point From Origin

**Difficulty:** Easy  
**LeetCode Link:** [Furthest Point From Origin](https://leetcode.com/problems/furthest-point-from-origin/)

## Description

You are given a string `moves` of length `n` consisting only of characters `'L'`, `'R'`, and `'_'`. The string represents your movement on a number line starting from the origin `0`.

In the `ith` move, you can choose one of the following directions:
- Move to the **left** if `moves[i] = 'L'` or `moves[i] = '_'`
- Move to the **right** if `moves[i] = 'R'` or `moves[i] = '_'`

Return the **distance from the origin** of the furthest point you can get to after `n` moves.

## Examples

### Example 1
```
Input: moves = "L_RL__R"
Output: 3
Explanation: Furthest point is -3 via "LLRLLLR".
```

### Example 2
```
Input: moves = "_R__LL_"
Output: 5
Explanation: Furthest point is -5 via "LRLLLLL".
```

### Example 3
```
Input: moves = "_______"
Output: 7
Explanation: Furthest point is 7 via "RRRRRRR".
```

## Constraints

- `1 <= moves.length == n <= 50`
- `moves` consists only of characters `'L'`, `'R'` and `'_'`
