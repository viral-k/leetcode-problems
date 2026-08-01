# Count Number of Texts

**Difficulty:** Medium  
**LeetCode Link:** [Count Number of Texts](https://leetcode.com/problems/count-number-of-texts/)

## Description

Alice is texting Bob using her phone. In order to add a letter, Alice has to press the key of the corresponding digit `i` times, where `i` is the position of the letter in the key.

- For example, to add the letter `'s'`, Alice has to press `'7'` four times. To add `'k'`, she presses `'5'` twice.
- Digits `'0'` and `'1'` do not map to any letters.

Due to a transmission error, Bob received a string of pressed keys instead of the message. For example, when Alice sent `"bob"`, Bob received `"2266622"`.

Given a string `pressedKeys` representing the string received by Bob, return the total number of possible text messages Alice could have sent, modulo `10^9 + 7`.

## Examples

### Example 1
```
Input: pressedKeys = "22233"
Output: 8
Explanation: "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae", "ce".
```

### Example 2
```
Input: pressedKeys = "222222222222222222222222222222222222"
Output: 82876089
Explanation: 2082876103 possible messages; mod 10^9 + 7 = 82876089.
```

## Constraints

- `1 <= pressedKeys.length <= 10^5`
- `pressedKeys` only consists of digits from `'2'` - `'9'`.
