# Earliest Finish Time for Land and Water Rides II

**Difficulty:** Medium  
**LeetCode Link:** [Earliest Finish Time for Land and Water Rides II](https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/)

## Description

You are given two categories of theme park attractions: land rides and water rides.

For land rides:

- `landStartTime[i]` is the earliest time the ith land ride can be boarded.
- `landDuration[i]` is how long the ith land ride lasts.

For water rides:

- `waterStartTime[j]` is the earliest time the jth water ride can be boarded.
- `waterDuration[j]` is how long the jth water ride lasts.

A tourist must experience exactly one ride from each category, in either order.

A ride may be started at its opening time or any later moment. If a ride is started at time `t`, it finishes at time `t + duration`. Immediately after finishing one ride, the tourist may board the other if it is already open or wait until it opens.

Return the earliest possible time at which the tourist can finish both rides.

## Examples

### Example 1
```
Input: landStartTime = [2,8], landDuration = [4,1], waterStartTime = [6], waterDuration = [3]
Output: 9
Explanation:
Take land ride 0 from time 2 to 6, then take water ride 0 from time 6 to 9.
```

### Example 2
```
Input: landStartTime = [5], landDuration = [3], waterStartTime = [1], waterDuration = [10]
Output: 14
Explanation:
Take water ride 0 from time 1 to 11, then take land ride 0 from time 11 to 14.
```

## Constraints

- `1 <= n, m <= 5 * 10^4`
- `landStartTime.length == landDuration.length == n`
- `waterStartTime.length == waterDuration.length == m`
- `1 <= landStartTime[i], landDuration[i], waterStartTime[j], waterDuration[j] <= 10^5`
