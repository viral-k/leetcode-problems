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
