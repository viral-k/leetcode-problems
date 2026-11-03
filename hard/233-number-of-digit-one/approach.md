# Approach

**Tags:** `Math`, `Dynamic Programming`, `Recursion`

## Intuition

Instead of counting the 1s in each number, count, for each digit position, how many numbers in `0..n` have a 1 there. The digit at position `p` (1, 10, 100, ...) cycles through `0..9`, each value held for `p` consecutive numbers, so every block of `10p` numbers has exactly `p` numbers with a 1 at that position. Only the last, partial block needs care.

## Approach

For each position `p = 1, 10, 100, ...` while `p <= n`, split `n` into:

- `high = n // (10p)`: the number of complete blocks,
- `cur = (n // p) % 10`: the digit at this position,
- `low = n % p`: the digits to its right.

Then the count at this position is `high * p`, plus for the partial block:

- `cur == 0`: nothing, the run of 1s hasn't started yet;
- `cur == 1`: `low + 1`, the numbers from `...1000` up to `n`;
- `cur >= 2`: `p`, the whole run of 1s is passed.

Example, `n = 13`, `p = 1`: `high = 1`, `cur = 3`, giving `1 + 1 = 2` (the 1 and the 11). With `p = 10`: `high = 0`, `cur = 1`, `low = 3`, giving `4` (10 to 13). Total 6.

## Complexity

- **Time:** O(log n), one step per digit
- **Space:** O(1)

## Edge Cases

- `n = 0`: no positions to process, answer 0
- `n` that is itself a 1 followed by zeros (`10`, `1000`): `cur == 1`, `low == 0`, so only the number itself counts at the top position
- Digits of 0 in the middle (`101`): that position adds only the full blocks
- `n = 10^9`: in Java, `p` would step from `10^9` to `10^10` and overflow `int`, so `p` is a `long`
