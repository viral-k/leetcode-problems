# Approach

**Tags:** `Array`, `Math`, `Greedy`, `Counting`, `Game Theory`

## Intuition

Only each stone's value **mod 3** affects the game, so reduce the array to three counts: `c0`, `c1`, `c2` (stones ≡ 0, 1, 2 mod 3).

Two structural facts drive the answer:

1. **Residue-0 stones are "pass" moves.** Removing one leaves the running sum unchanged mod 3 but hands the turn over. So they can't change *which residues* are playable — only **who** is on move. Their count matters solely by **parity**.
2. **Ignoring the zeros, the sum must follow a fixed pattern.** Starting from sum ≡ 0, the first stone must be a 1 or a 2 (either is fine), and thereafter the only way to avoid making the sum divisible by 3 is to keep repeating that same residue: `1,1,2,1,2,1,2,...` or `2,2,1,2,1,2,1,...`. So the game reduces to who runs out of the needed residue first.

Working through both openings under each `c0` parity gives a closed form.

## Approach

Count `c0`, `c1`, `c2`, then:

- **`c0` even** (the zeros cancel out in turn order): Alice wins iff **both** `c1 >= 1` and `c2 >= 1`. She opens with whichever residue lets the alternating chain outlast Bob; with only one residue type present, she can't start a viable chain.
- **`c0` odd** (one leftover pass flips the parity of the whole race): Alice wins iff **`|c1 - c2| > 2`**, i.e. one residue class outnumbers the other by at least 3, so the imbalance survives the flipped turn order.

Return the matching condition.

## Complexity

- **Time:** O(n) — a single counting pass
- **Space:** O(1) — three counters

## Edge Cases

- Single stone → Alice removes it, nothing remains → Bob wins automatically → `false` (Example 2)
- All stones divisible by 3 → `c1 = c2 = 0` → both branches give `false`
- Only one non-zero residue present with `c0` even → `false`
- `|c1 - c2| == 2` exactly with `c0` odd → `false` (strict `>` matters)
- Verified exhaustively against a full minimax for all `(c0, c1, c2)` up to 5 each
