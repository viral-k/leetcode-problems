# Approach

**Tags:** `String`, `Greedy`, `Counting`, `Sorting`

## Intuition

A palindrome is fully determined by its left half (and a possible middle character). Because `s` is already palindromic, every character count is even except at most one — exactly the condition needed to form a palindrome. To make the whole palindrome lexicographically smallest, make its **left half** as small as possible: place characters in ascending order, using half of each character's count. The right half is then forced (it must mirror the left), and the lone odd character sits in the middle.

## Approach

1. Count each character.
2. Build the left half by appending `count[c] // 2` copies of each character `c` in `a..z` order.
3. If one character has an odd count, that single leftover is the middle.
4. Result = `left + middle + reverse(left)`.

## Complexity

- **Time:** O(n) — counting and building each half once (26-letter alphabet is constant)
- **Space:** O(n) — the output string

## Edge Cases

- Single character → it's the middle, empty halves → itself (Example 1)
- Odd length → exactly one character has an odd count → middle
- Even length → no middle
- All same character → already the smallest palindrome
- Input guaranteed palindromic, so at most one odd count is assured
