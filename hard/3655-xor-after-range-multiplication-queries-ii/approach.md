# Approach

**Tags:** `Array`, `Bit Manipulation`, `Math`, `Sqrt Decomposition`

## Intuition

Two extreme approaches have tradeoffs:
- **Brute Force:** Fast for large k (few elements), slow for small k (many elements)
- **Difference Array:** Fast for small k (few unique values), slow for large k (many sweeps)

By splitting at sqrt(N), we get the best of both worlds.

## Solution

### Sqrt Decomposition

Let `S = sqrt(N)`:

**Large k (k >= S):** Use brute force loop
- Each query touches at most N/S = sqrt(N) elements
- Total: O(Q × sqrt(N))

**Small k (k < S):** Use multiplicative difference array
- Only S unique step sizes possible
- Group queries by k, process each group with O(1) per query
- Run S sweeps of size N
- Total: O(N × sqrt(N))

### Multiplicative Difference Array

For range multiplication with step k:
1. `diff[l] *= v` — start multiplying at position l
2. `diff[l + (steps+1)*k] *= v^(-1)` — cancel effect using modular inverse
3. Propagate: `diff[i] = diff[i] * diff[i-k]` for all i

**Example:** Query [l=0, r=2, k=1, v=4]
```
diff = [1, 1, 1, 1, 1]
diff[0] *= 4, diff[3] *= 4^(-1)
diff = [4, 1, 1, 4^(-1), 1]
After propagation: [4, 4, 4, 1, 1]
```

### Modular Inverse

Using Fermat's Little Theorem:
```
v^(-1) ≡ v^(MOD-2) (mod MOD)
```

Python: `pow(v, -1, MOD)`
Java: Fast exponentiation

## Complexity

- **Time:** O((N + Q) × sqrt(N) + Q × log(MOD))
  - Heavy queries: O(Q × sqrt(N))
  - Light query placement: O(Q)
  - Modular inverses: O(Q × log(MOD))
  - Propagation sweeps: O(N × sqrt(N))
- **Space:** O(N + Q)

## Edge Cases

- All queries have same k
- k = 1 for all queries (worst case for brute force)
- k = n for all queries (worst case for diff array)
- Overlapping ranges with same k
