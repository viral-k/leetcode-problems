# Approach

**Tags:** `Array`, `String`, `Trie`

## Intuition

A suffix becomes a prefix if we read the word from right to left. So we can insert every container word into a trie in reversed order.

At each trie node, store the best container index among all words that pass through that node. "Best" means:

1. shortest word length
2. if lengths tie, smallest original index

Then a query walks the trie from its last character backward. The deepest node reached represents the longest common suffix, and that node already knows the correct tie-broken answer.

## Approach

1. Create a reversed trie.
2. Insert every word from `wordsContainer`:
   - update the root with this word, because the empty suffix is a valid fallback
   - walk the word from right to left
   - create missing trie nodes
   - at every visited node, update the stored best index if this word is shorter, or equally short and earlier
3. For every query:
   - start with the root's best index
   - walk the query from right to left
   - if the next character is missing, stop
   - otherwise move to that node and use its stored best index as the current answer
4. Return all query answers.

## Complexity

Let `C` be the total length of all strings in `wordsContainer`, and `Q` be the total length of all strings in `wordsQuery`.

- **Time:** O(C + Q) — every inserted or queried character is processed once
- **Space:** O(C) — one trie node per distinct reversed prefix

## Edge Cases

- No non-empty common suffix -> root returns the globally shortest earliest container word
- Multiple words share the same suffix -> node-level tie-breaking chooses shortest then earliest
- Duplicate container words -> earliest index wins
- Query shorter than the matching container suffix -> traversal naturally stops at the query length
