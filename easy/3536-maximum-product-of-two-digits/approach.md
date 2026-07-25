# Approach

**Tags:** `Math`, `Greedy`

## Intuition

Digits are non-negative, so the largest product of any two of them is simply the product of the two largest digits (using the same position isn't allowed, but a repeated *value* is — and tracking the top two by value handles that automatically since `n >= 10` guarantees at least two digits).

## Approach

1. Scan the digits of `n`, maintaining the largest (`max1`) and second-largest (`max2`) digit values seen.
2. Return `max1 * max2`.

## Complexity

- **Time:** O(d) where d = number of digits (at most 10)
- **Space:** O(1)

## Edge Cases

- Repeated largest digit (e.g. `22`) → `max1` and `max2` both that value → squared
- At least two digits always exist (`n >= 10`)
- A `0` digit just never wins the top two unless forced; products stay correct
