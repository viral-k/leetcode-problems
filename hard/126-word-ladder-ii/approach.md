# Approach

**Tags:** `Hash Table`, `String`, `Backtracking`, `Breadth-First Search`

## Intuition

Words are nodes, one-letter differences are unit-weight edges, so shortest sequences are shortest paths. Enumerating all paths with plain DFS is hopeless; instead build the shortest-path DAG with BFS, then read all paths out of it.

BFS gives each reachable word its distance from `beginWord`. An edge `cur -> next` lies on a shortest path exactly when `dist[next] == dist[cur] + 1`, so recording those edges as parent links produces a DAG containing every shortest path and nothing else. Walking it backwards from `endWord` yields the answers without exploring a single dead end.

The one thing that needs care: a word can have several parents in the same BFS level's predecessor set. Removing visited words from the candidate set must happen after the whole level is processed, not on first discovery, or the second and later parents get lost.

## Approach

1. Put `wordList` in a set. If `endWord` is absent, return `[]`.
2. BFS from `beginWord` level by level. For each word in the current level, generate neighbours by replacing each position with the 25 other letters and keeping those still in the unvisited set.
   - For each such neighbour, append the current word to `parents[neighbour]`.
   - Collect the level's discovered words, then remove them all from the unvisited set and make them the next level.
   - Stop as soon as `endWord` appears in a level.
3. If `endWord` was never reached, return `[]`.
4. DFS from `endWord` following `parents` down to `beginWord`, building each path in reverse and reversing it at the end.

Generating neighbours by mutation costs O(L * 26) per word, which beats comparing every pair of words when `L <= 5`.

## Complexity

- **Time:** O(n * L * 26) for the BFS plus O(total output size) for the path extraction
- **Space:** O(n * L) for the parent graph, plus the output

## Edge Cases

- `endWord` not in `wordList` → `[]` (Example 2)
- `beginWord` present in `wordList` → it must be excluded from the unvisited set up front, or it can be rediscovered as its own neighbour
- `beginWord` and `endWord` one letter apart → a single two-word sequence
- `endWord` unreachable although present → `[]`
- Words of length 1 (`beginWord = "a"`, `endWord = "c"`) → every pair of distinct letters differs in one position
- Many parallel shortest paths: the output can be large, which is why the DAG must be traversed rather than the graph re-searched
