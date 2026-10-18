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

## 2026-10-04 — Added scripts/fetch_problem.py (scaffold from a LeetCode link)

Problems were being added by pasting the statement text by hand. Added a script
that takes a URL or slug and pulls everything from LeetCode's public GraphQL
endpoint (`leetcode.com/graphql`, no auth for non-premium problems).

Chose GraphQL over scraping the HTML page because the page is JS-rendered, so
an HTTP fetch of it returns no description. The endpoint also returns the
official number, difficulty and the per-language method stubs, which removes
two recurring sources of error: guessing the folder number, and guessing the
method name on problems where the signature is not in the pasted text.

Written with only the standard library (`urllib`, `html`, `re`) so there is
nothing to install. HTML-to-markdown uses regex rather than a parser; the
input is machine-generated and consistent, and the conversion was checked
against 43 existing hand-written `problem.md` files.

Tradeoffs accepted: regex conversion will need a tweak if LeetCode changes its
markup; premium problems still have to be pasted by hand; and tables need
reformatting (the script warns in both cases). It deliberately does not touch
git or the READMEs, matching the existing split where only `push.py` does that.

Also noted, not fixed: `medium/0192-word-frequency` and
`easy/0628-maximum-product-of-three-numbers` use 4-digit padding, while
`CLAUDE.md` specifies 3. The script follows the documented convention, so it
would generate `192-` and `628-` for those two.

## 2026-10-11 — SQL problems get solution.sql only, and a `Database` tag

Problem 185 is a database problem, so there is no Python or Java solution to
write. Followed the existing precedent from `medium/0192-word-frequency`, which
is a shell problem and carries only `solution.sh`: the folder holds
`problem.md`, `approach.md` and `solution.sql`, and `update_readme.py` renders
the solution columns as `-` without complaint.

Tagged it `Database`, which LeetCode uses and this repo had not used before.
Introducing it mirrors how `Shell` entered the vocabulary. `fetch_problem.py`
filters LeetCode tags against tags already present in the repo, so it dropped
`Database` and warned; the tag is added by hand here and future database
problems will keep it automatically.

Validated the query by running it in sqlite3 against a Python reference rather
than reasoning about it: 7000 randomized cases, plus a check that swapping
`DENSE_RANK` for `RANK` or `ROW_NUMBER` actually breaks the given example. It
does, which is the point of the problem.

## 2026-10-18 — 1569 built the BST as a treap instead of recursive partitioning

The usual solution for 1569 recurses on the array, partitioning by the root at
each step: O(n^2) worst case (a sorted input is a chain), and in Python it
recurses n deep, which at the n = 1000 limit sits on the default recursion
limit and would need `setrecursionlimit` to be safe.

Used instead the fact that inserting a permutation into a BST produces exactly
the treap on (value, insertion index). That builds in O(n) with the right-spine
stack sweep over values 1..n, and subtree sizes come from a top-down interval
sweep because every subtree of a BST over 1..n spans a contiguous value range.
No recursion anywhere, and the answer reduces to one product of binomials.

Tradeoff: more reasoning to follow than the three-line recursion, and it relies
on the values being a permutation of 1..n. Both are stated in the constraints.
Validated the construction separately from the counting — the treap shape was
compared against literal repeated insertion on all 46233 permutations of size
<= 8 and on random and monotone inputs at n = 1000 — so the clever part is
checked independently of the combinatorics.
