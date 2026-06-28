# CLAUDE.md

Guidance for working in this repo. **Read this instead of re-scanning the whole tree** when the user pastes a problem.

## What this repo is

A personal collection of LeetCode solutions. Each problem lives in its own folder with a problem statement, a written approach, and Python + Java solutions. Top-level `README.md` and per-difficulty `README.md`s are **auto-generated** — never hand-edit them.

## Repo layout

```
<difficulty>/<number>-<slug>/      difficulty ∈ {easy, medium, hard}
    problem.md
    approach.md
    solution.py
    solution.java
_templates/                        the 4 file templates
scripts/
    new_problem.py                 scaffolds a folder from templates
    push.py                        regenerates READMEs, commits, pushes
    update_readme.py               regenerates README tables from approach.md tags
README.md, <difficulty>/README.md  AUTO-GENERATED — do not edit by hand
```

### Folder naming

- `<number>-<slug>/` e.g. `medium/3020-find-the-maximum-number-of-elements-in-subset/`
- **Number:** zero-padded to 3 digits if `< 1000` (e.g. `033-...`, `887-...`); raw otherwise (e.g. `3020-...`).
- **Slug:** lowercase, hyphen-separated. Roman numerals stay lowercase in the slug (`...-ii`) but are uppercased in the title.

## The 4 files

1. **`problem.md`** — `# <Title>`, then `**Difficulty:**`, `**LeetCode Link:**`, `## Description`, `## Examples` (fenced blocks), `## Constraints` (bullets). Mirror the pasted statement.
2. **`approach.md`** — starts with `**Tags:**` line of backtick-wrapped Title-Case tags (these are **auto-parsed into the README tables**, so use canonical tag names — see the Topics list in `README.md`). Then `## Intuition`, `## Approach`, `## Complexity` (Time/Space), `## Edge Cases`.
3. **`solution.py`** — real LeetCode method signature, `from typing import List` etc. as needed. Docstring opens with `<number>. <Title>` then `Time:` / `Space:` lines.
4. **`solution.java`** — `class Solution { ... }`, real signature, imports at top. Javadoc block opens with `<number>. <Title>` then Time/Space. Use `long` for overflow-prone sums/products; `Map<Long,Integer>`, `ArrayDeque`, etc.

Match the style of recent problem folders exactly. `_templates/` holds the canonical skeletons.

## Workflow when the user pastes a problem

1. **Print the approach in chat** (always — in addition to writing `approach.md`).
2. Create the 4 files, fully filled in.
3. **Validate `solution.py` locally** with a throwaway harness (never committed): pasted examples + edge cases + random cross-checks against a brute force / independent reference. Report results (include a perf number at max constraints for tight problems).
4. **STOP.** Do not update READMEs, commit, or push. Wait for the user to submit on LeetCode.
   - The user often pushes from their own terminal — you don't need to wait for an explicit "push".
   - If the user says "push": `echo y | python scripts/push.py` (regenerates READMEs, auto-commits `Add <num>. <Title> (<Difficulty>)`, pushes).
   - If LeetCode rejects, the user pastes the failing case → fix both solutions, re-validate, push as an `Update` commit.

**Why wait:** keeps git history clean (no "fix" commits) since solutions occasionally fail hidden tests.

## Conventions

- TreeNode/ListNode: commented-out `# Definition for...` stub in Python, `/* Definition for... */` block in Java.
- Premium-locked problems: method name may be uncertain — flag it so the user can rename to match LeetCode's stub.
- Prefer the genuinely better complexity even if a simpler one passes (e.g. O(n) over O(n log n) when the ±1 prefix-sum trick applies).
