# Approach

**Tags:** `Array`, `Math`, `Design`, `Prefix Sum`

## Intuition

Products of a window work like sums of a window: keep prefix products, and the last `k` numbers multiply to `prefix[n] / prefix[n - k]`. That makes both operations O(1).

Zeros break this. Once a zero enters a prefix product, every later prefix is 0 and there's nothing to divide by. But a zero also settles every window that contains it: the product is 0. So when a zero arrives, throw away the whole history and start a fresh prefix list. Then:

- a window that fits inside the numbers since the last zero divides out normally;
- a window longer than that must include the zero, so the answer is 0.

The restart also keeps the numbers small. Every stored prefix is the product of a contiguous run since the last zero, and the statement guarantees any such product fits in 32 bits.

## Approach

1. Start with `prefix = [1]` (the empty product).
2. `add(num)`:
   - `num == 0`: reset to `prefix = [1]`
   - otherwise: append `prefix[-1] * num`
3. `getProduct(k)`: let `m = len(prefix) - 1`, the count of numbers since the last zero.
   - `k > m`: the window contains that zero, so return 0
   - otherwise: return `prefix[-1] / prefix[-1 - k]`, which is exact

## Complexity

- **Time:** O(1) per `add` and `getProduct` (amortized for the list append)
- **Space:** O(n) for the prefix list

## Edge Cases

- `k` equal to exactly the number of values since the last zero: the window stops just after the zero, so the answer is the full current prefix, not 0. That's why the zero test is `k >= len(prefix)`, with `len(prefix) = m + 1`.
- A zero as the very last number: `prefix = [1]`, so any `k >= 1` gives 0
- Several zeros in a row: each one resets again, and nothing goes wrong
- Ones: they leave the prefix unchanged, which is fine because division by the earlier equal prefix still gives 1
- Without the reset, the prefix product of the whole stream could also overflow even though every window fits. The reset bounds the stored values by the guarantee.
