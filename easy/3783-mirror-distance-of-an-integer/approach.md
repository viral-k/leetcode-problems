# Approach

**Tags:** `Math`

## Intuition

Reverse the digits of n, then compute the absolute difference.

## Solution

### Reverse Function

Two approaches:

**String-based:**
```python
reverse = int(str(n)[::-1])
```

**Mathematical:**
```python
def reverse(n):
    result = 0
    while n > 0:
        result = result * 10 + n % 10
        n //= 10
    return result
```

Both handle leading zeros correctly (e.g., 10 → 01 → 1).

### Final Answer

```python
return abs(n - reverse(n))
```

## Complexity

- **Time:** O(d) where d = number of digits ≈ log₁₀(n)
- **Space:** O(1) or O(d) for string approach

## Edge Cases

- Palindrome numbers → distance = 0
- Numbers ending in 0 (10, 100, 120) → reverse has fewer digits
- Single digit → distance = 0
