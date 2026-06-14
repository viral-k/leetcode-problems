# Approach

**Tags:** `Linked List`, `Two Pointers`, `Stack`

## Intuition

Twins are the `ith` and `(n-1-i)th` nodes — the node pairs you get by walking inward from both ends, exactly like a palindrome check. If we could traverse the second half in reverse while traversing the first half forward, each step would line up a twin pair.

Reversing the second half of the list in place lets us do that with two pointers and only O(1) extra space.

## Approach

1. Use slow/fast pointers to reach the middle: when `fast` reaches the end, `slow` is at the start of the second half.
2. Reverse the second half of the list in place.
3. Walk one pointer from the original head and another from the head of the reversed second half simultaneously; each step is a twin pair. Track the maximum of `first.val + second.val`.
4. Return that maximum.

## Complexity

- **Time:** O(n) — find middle, reverse half, single pairing pass
- **Space:** O(1) — in-place reversal, no extra structures

## Edge Cases

- Smallest list (`n == 2`) -> a single twin pair
- All equal values -> every twin sum is identical
- Maximum values -> twin sum up to `2 * 10^5`, well within `int`

## Note

An O(n) time / O(n) space alternative is to push the first half onto a stack, then pop while traversing the second half to form pairs — simpler but uses extra memory.
