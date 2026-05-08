# Approach

**Tags:** `Array`, `BFS`, `Number Theory`, `Hash Table`

## Intuition

Every move costs one jump, so this is a shortest-path problem on indices. Adjacent moves are simple, but teleport moves can be large: from a prime value `p`, we can jump to every index whose value is divisible by `p`.

The key optimization is to preprocess teleport destinations by prime divisor. Then BFS can expand a prime teleport group once and clear it, because expanding the same prime again would only repeat work.

## Approach

1. Build the smallest-prime-factor array up to `max(nums)`.
2. Identify which values in `nums` are prime; only those primes can be used as teleport sources.
3. For each index `i`, factor `nums[i]` into distinct prime factors.
4. If a factor `p` appears as a prime value in `nums`, add index `i` to `teleports[p]`.
5. Run BFS from index `0`.
6. From each index:
   - visit `i - 1`
   - visit `i + 1`
   - if `nums[i]` is prime, visit every index in `teleports[nums[i]]`
7. After using a prime teleport list, clear it so it is never scanned again.

## Complexity

- **Time:** O(M log log M + n log M), where `M = max(nums)`
- **Space:** O(M + n log M), for the smallest-prime-factor array and teleport lists

## Edge Cases

- `n = 1` -> already at the target
- No prime values -> only adjacent steps are possible
- Prime at current index has no useful destination -> BFS still continues through adjacent steps
- Repeated values and repeated prime factors -> each index is added once per distinct relevant factor
