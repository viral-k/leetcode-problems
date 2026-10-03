# Decisions

Running log of non-trivial choices. Newest first.

## 2026-09-09 — Count Commas II: keep the threshold loop instead of the closed form

Part I (`3870`, `n <= 10^5`) could have been written as `max(0, n - 999)`,
since only one grouping threshold ever applies at that bound. Kept the general
loop `sum over k of max(0, n - 10^(3k) + 1)` in both parts instead.
Part II (`3871`, `n <= 10^15`) then needed no algorithm change, only a widened
return type. Tradeoff: a couple of extra lines in part I for a formula that
survives the constraint bump.

## 2026-09-09 — Added decisions.md and flow.md

Neither file existed. Started both from this session rather than backfilling
the ~190 existing problem folders, since per-problem reasoning already lives in
each `approach.md` and duplicating it here would add noise without adding
information. This log is for repo-level choices; algorithm choices stay in
`approach.md`.

## Standing conventions (recorded for context, decided earlier)

- **Two languages per problem, Python + Java.** Python for fast local
  validation, Java to force explicit integer-width decisions that Python hides.
  This is why several entries note "answer exceeds int32" — Python would never
  surface it.
- **READMEs are generated, never hand-edited.** `approach.md`'s `**Tags:**`
  line is the single source of truth for the topic tables. Editing a generated
  README by hand gets silently overwritten on the next `push.py`.
- **Wait for LeetCode acceptance before committing.** Solutions occasionally
  fail hidden tests; committing only after acceptance keeps "fix" commits out
  of the history.

## 2026-10-03 — Replaced an accepted solution (032) with a lower-space one

Problem 32 was already solved and committed (`18aafe6`, Jun 21) using the
stack-of-indices method: O(n) time, O(n) space. Swapped it for the two-pass
counter method at O(n) time, O(1) space, on the user's instruction to use the
optimal solution.

Rewriting an already-accepted solution is normally not worth the churn, but the
repo convention is to prefer the genuinely better complexity, and this is a
strict improvement with no cost to readability. The old version was kept as one
of the cross-check references during validation rather than discarded, which is
how the new one was confirmed on all 524,287 strings up to length 18.

Rule going forward: when a pasted problem already exists in the repo, say so and
check the committed solution rather than overwriting it silently.
