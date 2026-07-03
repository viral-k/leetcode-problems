# Network Recovery Pathways

**Difficulty:** Hard  
**LeetCode Link:** [Network Recovery Pathways](https://leetcode.com/problems/network-recovery-pathways/)

## Description

You are given a directed acyclic graph of `n` nodes numbered from `0` to `n − 1`. This is represented by a 2D array `edges` of length `m`, where `edges[i] = [u_i, v_i, cost_i]` indicates a one-way communication from node `u_i` to node `v_i` with a recovery cost of `cost_i`.

Some nodes may be offline. You are given a boolean array `online` where `online[i] = true` means node `i` is online. Nodes `0` and `n − 1` are always online.

A path from `0` to `n − 1` is valid if:

- All intermediate nodes on the path are online.
- The total recovery cost of all edges on the path does not exceed `k`.

For each valid path, define its score as the minimum edge-cost along that path.

Return the maximum path score (i.e., the largest minimum-edge cost) among all valid paths. If no valid path exists, return `-1`.

## Examples

### Example 1
```
Input: edges = [[0,1,5],[1,3,10],[0,2,3],[2,3,4]], online = [true,true,true,true], k = 10
Output: 3
Explanation: 0->1->3 costs 15 > k (invalid). 0->2->3 costs 7 <= k, min edge = min(3,4) = 3.
```

### Example 2
```
Input: edges = [[0,1,7],[1,4,5],[0,2,6],[2,3,6],[3,4,2],[2,4,6]], online = [true,true,true,false,true], k = 12
Output: 6
Explanation: Node 3 offline. 0->1->4 cost 12, score 5. 0->2->4 cost 12, score 6. Answer 6.
```

## Constraints

- `n == online.length`
- `2 <= n <= 5 * 10^4`
- `0 <= m == edges.length <= min(10^5, n * (n - 1) / 2)`
- `edges[i] = [u_i, v_i, cost_i]`
- `0 <= u_i, v_i < n`, `u_i != v_i`
- `0 <= cost_i <= 10^9`
- `0 <= k <= 5 * 10^13`
- `online[i]` is either `true` or `false`; `online[0]` and `online[n − 1]` are always `true`.
- The given graph is a directed acyclic graph.
