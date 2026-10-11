# Approach

**Tags:** `Array`, `String`, `Backtracking`, `Trie`, `Matrix`

## Intuition

Running the single-word search 30,000 times is the obvious approach and far too slow: each run re-walks the same board prefixes. The fix is to turn the word list inside out. Put the words in a trie, then do one DFS per starting cell that descends the board and the trie together. Words sharing a prefix share that descent, and a path dies the moment the board letter has no matching trie child.

That alone is not enough on the worst inputs. A 12x12 board of nothing but `a` with thousands of `a`-heavy words still re-explores the same region for every surviving word. Two prunes fix it:

- **Letter multiplicity.** A word needing four `z` on a board with one can never match. Counting the board's letters once and filtering the word list is linear in the total word length and removes most candidates on adversarial inputs.
- **Shrink the trie as it is consumed.** When a word is found, remove it from its node. After a node's recursive calls return, if it has no children and no word, delete it from its parent. Found and dead branches physically disappear, so later starting cells do not revisit them. This is the difference between passing and timing out.

Visited cells are handled by overwriting the board cell with a sentinel and restoring it on the way out, which avoids a parallel visited array.

## Approach

1. Count the board's letters; drop any word whose letter requirements exceed it.
2. Insert the remaining words into a trie. Store the full word at its terminal node.
3. For each cell whose letter is a child of the root, DFS:
   - descend to the child node for this cell's letter
   - if the node holds a word, take it out and record it
   - mark the cell visited, recurse into the four neighbours whose letter is a child of the current node, then restore the cell
   - if the node is now empty (no children, no word), delete it from its parent
4. Return the collected words.

Checking `board[x][y] in node` before recursing keeps the recursion from being entered on a doomed path, which matters more than it looks: it halves the call count.

## Complexity

- **Time:** O(cells * 4 * 3^(L-1)) in the worst case, where `L <= 10` is the longest word, plus O(total word length) to build the trie. The prunes make the practical cost far lower.
- **Space:** O(total word length) for the trie, O(L) recursion depth

## Edge Cases

- A word longer than the number of cells can never fit; the multiplicity filter catches most such cases, and the trie walk catches the rest
- `"abcb"` on a 2x2 board reuses a cell, so it must not match (Example 2); the sentinel marking is what forbids that
- Duplicate results: a word reachable by several paths must appear once, which popping it from the node guarantees
- A word that is a prefix of another (`"ab"` and `"abc"`) → both reported, since the shorter one's node still has children and is not pruned
- Single-cell board, or a single-character word
- Worst case for pruning: every cell the same letter with many same-letter words
- Restoring the board cell after recursion is required; the caller may inspect the board afterwards
