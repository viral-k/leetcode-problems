# Approach

**Tags:** `String`, `Backtracking`, `Breadth-First Search`

## Intuition

Two separate questions hide in this problem: how many brackets must go, and which sets of that size work.

The count is cheap. One pass with a counter gives it exactly: a `)` arriving with no pending `(` can never be matched by anything to its right, so it must be removed, and whatever `(` remain pending at the end must be removed too. Call those `extra_open` and `extra_close`. Nothing smaller can work, because each counted bracket is individually unmatchable.

With the budget known, the search becomes a decision per bracket rather than a search over removal counts. Carry the remaining budget of each type and the running balance; prune as soon as the balance would go negative or a budget is exhausted. Accepting only when both budgets are spent to exactly zero is what restricts the output to minimum-size removals, since otherwise the search would also return valid strings that threw away more than necessary.

The remaining problem is duplication, and it is severe. Choosing to delete the first or the second `(` of `"(("` produces the same string, so a per-character keep/remove search revisits the same result over and over. On `"(((((((((())))"` the per-character version reaches the single answer 210 separate times.

The fix is to branch on *how many* brackets to drop from each maximal run of identical brackets, not on which ones. A run of length `L` with budget `b` offers `min(L, b) + 1` choices instead of `2^L` paths. That collapses the worst inputs: on `"("` repeated 20 times the per-character search explores about a million paths, while the run-based one explores 21.

## Approach

1. Count the budget as described, giving `extra_open` and `extra_close`.
2. DFS over index `i` with `(balance, rem_open, rem_close, built)`:
   - a letter is appended unchanged, advance by one
   - otherwise scan the maximal run of the current bracket, length `run`
   - for each `drop` in `0 .. min(run, budget)`, keep `run - drop` of them: for `(` add `keep` to the balance; for `)` subtract it, skipping any `drop` where `balance < keep` since the balance would go negative mid-run
3. At the end of the string, record `built` when `balance == 0 and rem_open == 0 and rem_close == 0`.
4. Return the results.

Results are still collected in a set. Run-based branching produced no duplicates across every parentheses-only string up to length 15 and every string over `{(, ), a}` up to length 10, but that is measurement rather than proof, so the set stays as a cheap guarantee.

## Complexity

- **Time:** O(product over runs of `min(run, budget) + 1`), bounded by 2^p for `p` parentheses but far below it in practice
- **Space:** O(n) recursion depth plus the output

## Edge Cases

- No valid substring other than empty (`")("`) → `[""]`, produced by spending both budgets
- Already valid input → the budget is `(0, 0)`, so the only accepted result is the string itself
- Letters only, no parentheses → returns the input unchanged
- `"(()"` is the smallest duplicating input: both `(` are in one run, and dropping either gives `"()"`
- Long single runs (`"("` x 20) are the worst case for a per-character search and the easiest for this one
- A `)` run must be checked against the balance for the whole run at once; `balance >= keep` covers every intermediate step, since the balance only falls while consuming the run
