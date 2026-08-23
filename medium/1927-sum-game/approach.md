# Approach

**Tags:** `Math`, `Greedy`, `String`, `Game Theory`

## Intuition

Positions within a half don't matter — only two things do: the **known digit imbalance** and **how many `?` sit on each side**.

Let `sumL`, `sumR` be the sums of the already-known digits and `qL`, `qR` the `?` counts.

**Odd total `?`:** Alice moves first *and* last. Whatever balance exists going into her final move, she has 10 choices for it and at most one of them produces equality, so she can always avoid it. Alice wins.

**Even total `?`:** the blanks pair up, one move each. Think of every pair as a duel: Bob wants each pair to contribute 0 to the imbalance, Alice wants it to swing. If a pair straddles the halves, Bob simply mirrors whatever Alice plays, so it nets 0. The interesting case is the **surplus** blanks — the `|qR - qL|` extras on one side, which also pair among themselves. For those, one player picks a digit and the other answers on the same side; optimal play makes each such pair worth exactly **9** (Alice plays 9 or 0, Bob completes to the extreme). So the surplus can shift the balance by exactly `9 * (qR - qL) / 2`.

Bob therefore wins precisely when the known imbalance equals what the surplus contributes:

```
sumL - sumR == 9 * (qR - qL) / 2
```

Anything else and Alice can steer the total out of Bob's reach.

## Approach

1. Scan `num` once, accumulating `sumL`, `sumR`, `qL`, `qR` (first half vs second half).
2. If `(qL + qR)` is odd → return `true` (Alice wins).
3. Otherwise return `true` iff `sumL - sumR != 9 * (qR - qL) / 2`.

Note that when `qL + qR` is even, `qR - qL` is even too (a sum and difference share parity), so the division is exact.

## Complexity

- **Time:** O(n) — a single pass
- **Space:** O(1)

## Edge Cases

- No `?` at all → the check reduces to `sumL == sumR` (Example 1)
- All `?` on one side → the full surplus formula applies (Example 2: `7 != 9` → Alice wins)
- Odd `?` count → Alice always wins, handled before the formula
- The comparison must be exact equality; being off by even 1 hands the game to Alice
- Verified exhaustively for lengths 2 and 4, and by sampling at length 6, against a full game-tree search
