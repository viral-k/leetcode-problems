# Approach

**Tags:** `Math`, `Enumeration`, `Simulation`

## Intuition

With `n <= 100` and `t <= 10`, just scan upward from `n` and return the first number whose digit product is divisible by `t`. The search is guaranteed short: any number containing a `0` digit has digit product `0`, which is divisible by every `t`, and such numbers (e.g. the next multiple of 10) are never far away.

## Approach

1. Starting at `x = n`, compute the product of `x`'s digits.
2. If that product is divisible by `t`, return `x`.
3. Otherwise increment `x` and repeat.

## Complexity

- **Time:** O(A · d) where A = answer − n (small) and d = digit count
- **Space:** O(1)

## Edge Cases

- `t = 1` → every number qualifies → answer is `n`
- Number with a `0` digit → product `0`, divisible by any `t`
- `n` itself already satisfies (Example 1) → return `n`
- Worst case still bounded: the next multiple of 10 always works
