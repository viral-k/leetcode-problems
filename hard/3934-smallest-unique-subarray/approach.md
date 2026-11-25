# Approach

**Tags:** `Array`, `Hash Table`, `Binary Search`

## Intuition

Extending a unique subarray keeps it unique, so "some subarray of length `L` is unique" is monotone in `L`. That gives the usual solution: binary search on `L` and count rolling hashes of every window, O(n log n), with some risk of hash collisions.

A suffix automaton answers the question directly and compares subarrays exactly. Every state in it stands for a group of subarrays that end at the same set of positions. Two facts finish the problem:

- The lengths in a state `v` are exactly `len(link(v)) + 1` up to `len(v)`, so its shortest subarray has length `len(link(v)) + 1`.
- A subarray is unique when its set of end positions has size 1. Those are the leaves of the suffix-link tree, the states that no other state links to. Any state with a child occurs at least twice: a cloned state has two or more children with disjoint end positions, and an original state also has the end of its own prefix, which none of its children contain.

So the answer is the minimum of `len(link(v)) + 1` over the leaves.

## Approach

1. Build the automaton one element at a time. Transitions are hash maps because values go up to `10^5`.
   - Add a state `cur` with `len = len(last) + 1`.
   - Walk the suffix links from `last`, adding a transition on `x` to `cur` until a state already has one.
   - If that state's target `q` has `len(q) == len(p) + 1`, link `cur` to `q`. Otherwise clone `q`, redirect the transitions on `x` that go to `q` from `p` upward, and link both `q` and `cur` to the clone.
2. Mark every state that is the suffix link of some other state.
3. Return the minimum of `len(link(v)) + 1` over the unmarked states.

## Complexity

- **Time:** O(n) expected. There are at most `2n` states and `3n` transitions, and transitions are never deleted, so copying them into clones is covered by the same bound.
- **Space:** O(n)

## Edge Cases

- `n = 1`: the only leaf links to the root, answer 1
- All equal (`[3, 3, 3]`): the states form a single chain, the only leaf is the whole array, and its link has length `n - 1`, so the answer is `n`
- All distinct, or any value that occurs once: that state links to the root, answer 1
- Overlapping occurrences count as separate subarrays (`[1, 1, 1]` contains `[1, 1]` twice). End positions handle that without special treatment.
- The whole array is always unique, so an answer always exists
