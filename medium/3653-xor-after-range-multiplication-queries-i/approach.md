# Approach

**Tags:** `Array`, `Bit Manipulation`, `Simulation`

## Intuition

With small constraints (n, q ≤ 10³), direct simulation is efficient enough. Process each query by iterating with step k and apply XOR at the end.

## Solution

### Step 1: Process Each Query

For each query `[l, r, k, v]`:
```python
idx = l
while idx <= r:
    nums[idx] = (nums[idx] * v) % MOD
    idx += k
```

### Step 2: Compute XOR

After all queries, XOR all elements:
```python
result = 0
for num in nums:
    result ^= num
```

### Why Modulo?

Values can grow large after multiple multiplications. Using `10^9 + 7` keeps values bounded while preserving the multiplication result for XOR.

## Complexity

- **Time:** O(q × n/k) ≈ O(q × n) in worst case = O(10⁶)
- **Space:** O(1) extra space

## Edge Cases

- Single element array
- k = n (only one element updated per query)
- k = 1 (all elements in range updated)
- Multiple queries affecting same indices
