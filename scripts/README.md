# Scripts

Automation scripts for managing the LeetCode solutions repository.

## Scripts

### `new_problem.py`

Creates a new problem folder with all required files from templates.

```bash
python scripts/new_problem.py <number> <slug> <difficulty>
```

**Arguments:**
| Arg | Description | Example |
|-----|-------------|---------|
| `number` | LeetCode problem number | `1`, `347`, `42` |
| `slug` | Problem URL slug (kebab-case) | `two-sum`, `top-k-frequent-elements` |
| `difficulty` | `easy`, `medium`, or `hard` | `medium` |

**Example:**
```bash
python scripts/new_problem.py 347 top-k-frequent-elements medium
```

**Creates:**
```
medium/347-top-k-frequent-elements/
├── problem.md      # Problem statement template
├── approach.md     # Approach template with Tags placeholder
├── solution.py     # Python solution template
└── solution.java   # Java solution template
```

---

### `update_readme.py`

Scans all problem folders and regenerates README files.

```bash
python scripts/update_readme.py
```

**Updates:**
- `README.md` — Main stats, topics, usage guide
- `easy/README.md` — Easy problems table
- `medium/README.md` — Medium problems table  
- `hard/README.md` — Hard problems table

**Auto-extracts:**
- Problem titles from `problem.md`
- Tags from `approach.md` (parsed from `**Tags:** \`tag1\`, \`tag2\``)
- Solution file existence (Python/Java checkmarks)

---

### `push.py`

Automates the git workflow: detect changes → update READMEs → commit → push.

```bash
python scripts/push.py
```

**Workflow:**
1. Detects added/modified problem folders
2. Runs `update_readme.py` automatically
3. Generates commit message based on changes
4. Prompts for confirmation
5. Commits and pushes to remote

**Commit message format:**
- Single problem: `Add 347. Top K Frequent Elements (Medium)`
- Multiple problems: `Add 3 problems: 1. Two Sum, 347. Top K Frequent Elements, ...`
- Updates only: `Update solutions`

---

## Adding New Scripts

When adding new scripts:
1. Add executable shebang: `#!/usr/bin/env python3`
2. Include docstring with purpose
3. Use `REPO_ROOT = Path(__file__).parent.parent` for paths
4. Update this README
