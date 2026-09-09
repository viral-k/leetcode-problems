# Execution Flow

Map of how this repo's tooling runs. The problem folders themselves are data;
all executable logic lives in `scripts/`.

## Recent AI Changes

**2026-09-09**

- Added `medium/3871-count-commas-in-range-ii/`. Reuses the threshold-loop
  formula from `easy/3870-count-commas-in-range/`; return type widened to
  64-bit because `n` now reaches 10^15.
- Created this file and `decisions.md` per the global development rules.
  Neither existed before.

## Entry points

Three standalone CLI scripts. There is no long-running application and no
shared runtime state between them.

| Script | Invocation | Purpose |
|---|---|---|
| `scripts/new_problem.py` | `python scripts/new_problem.py <number> <slug> <difficulty>` | Scaffold an empty problem folder from `_templates/` |
| `scripts/update_readme.py` | `python scripts/update_readme.py` | Regenerate `README.md` and the per-difficulty READMEs |
| `scripts/push.py` | `python scripts/push.py` | Regenerate READMEs, commit, push |

`push.py` is the one normally used; it calls the README generation itself.

## Call flow

### new_problem.py

```
main()
  └─ create_problem(number, slug, difficulty)
       ├─ title_from_slug(slug)         # slug → Title Case, roman numerals uppercased
       ├─ zero-pads number to 3 digits when < 1000
       └─ copies the 4 files out of _templates/, substituting number/title
```

### update_readme.py

```
main()
  ├─ scan_problems()                    # walks easy/ medium/ hard/
  │    ├─ parse_problem_folder(name)    # "3871-count-commas..." → (number, slug)
  │    ├─ get_problem_title(problem.md) # reads the H1
  │    │    └─ normalize_title / title_from_slug   # fallback when H1 is missing
  │    └─ get_tags_from_approach(approach.md)      # parses the **Tags:** line
  ├─ generate_main_readme(data)         # progress counts + aggregated topic list
  └─ generate_difficulty_readme(...)    # one table per difficulty
```

The `**Tags:**` line in each `approach.md` is the single source of truth for
the topic column and the aggregated Topics list. A malformed tag line shows up
as a missing or wrong entry in the generated tables.

### push.py

```
main()
  ├─ run_cmd(["git", "status", "--porcelain"])
  ├─ get_changed_problems()             # classifies added vs modified folders
  ├─ update_readme.main()               # regenerates READMEs before staging
  ├─ generate_commit_message(changes)   # "Add problems: 115, 940, 3904"
  ├─ prompts for confirmation           # bypass with: echo y | python scripts/push.py
  └─ run_cmd git add / commit / push
```

## Ordering constraint worth knowing

`push.py` regenerates the READMEs *before* it commits. If the remote is ahead
(for example after editing a file through the GitHub web UI), the push is
rejected as non-fast-forward, and a later rebase can drop the remote's README
edit in favour of the freshly generated one. Run `git pull` before `push.py`
whenever commits may have been made outside this machine.
