# Approach

**Tags:** `Array`, `Math`, `Enumeration`

## Intuition

The special positions are exactly the divisors of `n`, and there are far fewer of those than there are elements. Rather than testing `n % i == 0` for every index, enumerate the divisors directly: walk `i` from 1 while `i * i <= n`, and whenever `i` divides `n`, both `i` and `n / i` are divisors. That touches only O(sqrt(n)) indices.

The one wrinkle is indexing. The statement is 1-indexed, so divisor `i` refers to `nums[i - 1]`.

## Approach

1. `n = len(nums)`, `total = 0`.
2. For `i` from 1 while `i * i <= n`:
   - if `n % i != 0`, continue
   - add `nums[i - 1] ** 2`
   - let `j = n // i`; if `j != i`, add `nums[j - 1] ** 2`
3. Return `total`.

The `j != i` guard stops a perfect square from being counted twice, since `i` and `n / i` coincide when `i * i == n`.

## Complexity

- **Time:** O(sqrt(n))
- **Space:** O(1)

At `n <= 50` the simple full scan is equally fast in practice; the divisor enumeration is used because it is the shape the problem actually has.

## Edge Cases

- `n = 1` → only index 1 is special, so the answer is `nums[0] ** 2`
- Perfect square `n` (4, 9, 16, 25, 36, 49) → `i == n / i` at the top, and the guard prevents double counting
- Prime `n` → only indices 1 and `n` qualify
- Index 1 always divides `n`, and index `n` always does, so the answer is never 0
- Maximum value: `n = 50` with every element 50 gives at most 6 divisors of 50 times 2500, well inside `int`
