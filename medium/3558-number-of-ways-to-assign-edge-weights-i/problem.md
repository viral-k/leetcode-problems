# Number of Ways to Assign Edge Weights I

**Difficulty:** Medium  
**LeetCode Link:** [Number of Ways to Assign Edge Weights I](https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/)

## Description

There is an undirected tree with `n` nodes labeled from `1` to `n`, rooted at node `1`. The tree is represented by a 2D integer array `edges` of length `n - 1`, where `edges[i] = [ui, vi]` indicates that there is an edge between nodes `ui` and `vi`.

Initially, all edges have a weight of `0`. You must assign each edge a weight of either `1` or `2`.

The cost of a path between any two nodes `u` and `v` is the total weight of all edges in the path connecting them.

Select any one node `x` at the maximum depth. Return the number of ways to assign edge weights in the path from node `1` to `x` such that its total cost is odd.

Since the answer may be large, return it modulo `10^9 + 7`.

**Note:** Ignore all edges not in the path from node `1` to `x`.

## Examples

### Example 1
```
Input: edges = [[1,2]]
Output: 1
Explanation: The path from Node 1 to Node 2 has one edge.
Weight 1 makes the cost odd, weight 2 makes it even. So 1 valid assignment.
```

### Example 2
```
Input: edges = [[1,2],[1,3],[3,4],[3,5]]
Output: 2
Explanation: The maximum depth is 2 (nodes 4 and 5). A path of two edges has
cost odd for weights (1,2) or (2,1). So 2 valid assignments.
```

## Constraints

- `2 <= n <= 10^5`
- `edges.length == n - 1`
- `edges[i] == [ui, vi]`
- `1 <= ui, vi <= n`
- `edges` represents a valid tree.
