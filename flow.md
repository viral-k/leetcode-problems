# Execution Flow

Map of how this repo's tooling runs. The problem folders themselves are data;
all executable logic lives in `scripts/`.

## Recent AI Changes

**2026-10-04**

- Added `scripts/fetch_problem.py`. Scaffolds a problem folder from a LeetCode
  URL or slug instead of a hand-pasted statement: pulls the number, title,
  difficulty, description HTML, topic tags and method stubs from LeetCode's
  public GraphQL endpoint, converts the HTML to this repo's `problem.md`
  format, and writes the real signatures into `solution.py`/`solution.java`.
  Does not touch the READMEs or git.
- Replaced the `032-longest-valid-parentheses` solution with the two-pass
  counter method (O(1) space instead of O(n)). See `decisions.md`.

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
| `scripts/fetch_problem.py` | `python scripts/fetch_problem.py <url-or-slug>` | Scaffold a folder with `problem.md` and the stubs filled in from LeetCode |
| `scripts/update_readme.py` | `python scripts/update_readme.py` | Regenerate `README.md` and the per-difficulty READMEs |
| `scripts/push.py` | `python scripts/push.py` | Regenerate READMEs, commit, push |

`push.py` is the one normally used; it calls the README generation itself.

`fetch_problem.py` and `new_problem.py` do the same job from different inputs:
`fetch_problem.py` needs network access and fills the content in, while
`new_problem.py` works offline and leaves placeholders. Neither touches git or
the READMEs.

## Call flow

### new_problem.py

```
main()
  └─ create_problem(number, slug, difficulty)
       ├─ title_from_slug(slug)         # slug → Title Case, roman numerals uppercased
       ├─ zero-pads number to 3 digits when < 1000
       └─ copies the 4 files out of _templates/, substituting number/title
```

### fetch_problem.py

```
main()
  ├─ graphql(DAILY_QUERY)              # only with --daily, resolves today's slug
  ├─ slug_from_input(target)           # URL, /problems/... path, or bare slug
  ├─ graphql(QUESTION_QUERY, slug)     # leetcode.com/graphql, no auth needed
  ├─ build_problem_md(question)
  │    └─ split_blocks(content)        # <p>/<ul>/<ol>/<pre> plus untagged gaps
  │         ├─ inline(fragment)        # <code>→backticks, <sup>→^, entities, images
  │         ├─ pre_text(fragment)      # <pre> keeps its line breaks
  │         └─ list_items(html, ordered)
  ├─ build_approach_md(question)
  │    └─ repo_tag_vocabulary()        # tags already used in */*/approach.md
  ├─ build_solution_py(question, n)    # docstring under the real signature
  └─ build_solution_java(question, n)  # javadoc above `class Solution`
```

Exits non-zero without writing anything when the slug is unknown, the problem
is premium-locked (no description is served), or the folder exists and
`--force` was not passed. Anything it could not parse is printed as a
`Check these:` warning rather than failing silently.

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
