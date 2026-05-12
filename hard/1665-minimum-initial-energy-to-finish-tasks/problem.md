# Minimum Initial Energy to Finish Tasks

**Difficulty:** Hard  
**LeetCode Link:** [Minimum Initial Energy to Finish Tasks](https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/)

## Description

You are given an array `tasks` where `tasks[i] = [actuali, minimumi]`:

- `actuali` is the actual amount of energy you spend to finish the `i`th task.
- `minimumi` is the minimum amount of energy you require to begin the `i`th task.

For example, if the task is `[10, 12]` and your current energy is `11`, you cannot start this task. However, if your current energy is `13`, you can complete this task, and your energy will be `3` after finishing it.

You can finish the tasks in any order you like.

Return the minimum initial amount of energy you will need to finish all the tasks.

## Examples

### Example 1
```
Input: tasks = [[1,2],[2,4],[4,8]]
Output: 8
Explanation:
Starting with 8 energy, finish the tasks in this order:
- [4,8], leaving energy 4
- [2,4], leaving energy 2
- [1,2], leaving energy 1
```

### Example 2
```
Input: tasks = [[1,3],[2,4],[10,11],[10,12],[8,9]]
Output: 32
```

### Example 3
```
Input: tasks = [[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]
Output: 27
```

## Constraints

- `1 <= tasks.length <= 10^5`
- `1 <= actuali <= minimumi <= 10^4`
