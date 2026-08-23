# Sum Game

**Difficulty:** Medium  
**LeetCode Link:** [Sum Game](https://leetcode.com/problems/sum-game/)

## Description

Alice and Bob take turns playing a game, with Alice starting first.

You are given a string `num` of even length consisting of digits and `'?'` characters. On each turn, a player will do the following if there is still at least one `'?'` in `num`:

1. Choose an index `i` where `num[i] == '?'`.
2. Replace `num[i]` with any digit between `'0'` and `'9'`.

The game ends when there are no more `'?'` characters in `num`.

For Bob to win, the sum of the digits in the first half of `num` must be equal to the sum of the digits in the second half. For Alice to win, the sums must not be equal.

For example, if the game ended with `num = "243801"`, then Bob wins because `2+4+3 = 8+0+1`. If the game ended with `num = "243803"`, then Alice wins because `2+4+3 != 8+0+3`.

Assuming Alice and Bob play optimally, return `true` if Alice will win and `false` if Bob will win.

## Examples

### Example 1
```
Input: num = "5023"
Output: false
Explanation: No moves remain, and 5 + 0 = 2 + 3, so Bob wins.
```

### Example 2
```
Input: num = "25??"
Output: true
Explanation: Alice can replace one '?' with '9', making equality impossible for Bob.
```

### Example 3
```
Input: num = "?3295???"
Output: false
Explanation: Bob can always force the sums to match.
```

## Constraints

- `2 <= num.length <= 10^5`
- `num.length` is even.
- `num` consists of only digits and `'?'`.
