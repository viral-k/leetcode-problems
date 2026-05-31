# Destroying Asteroids

**Difficulty:** Medium  
**LeetCode Link:** [Destroying Asteroids](https://leetcode.com/problems/destroying-asteroids/)

## Description

You are given an integer `mass`, which represents the original mass of a planet. You are further given an integer array `asteroids`, where `asteroids[i]` is the mass of the ith asteroid.

You can arrange for the planet to collide with the asteroids in any arbitrary order. If the mass of the planet is greater than or equal to the mass of the asteroid, the asteroid is destroyed and the planet gains the mass of the asteroid. Otherwise, the planet is destroyed.

Return `true` if all asteroids can be destroyed. Otherwise, return `false`.

## Examples

### Example 1
```
Input: mass = 10, asteroids = [3,9,19,5,21]
Output: true
Explanation:
One possible order is [9,19,5,3,21]. The planet can destroy every asteroid and increase its mass after each collision.
```

### Example 2
```
Input: mass = 5, asteroids = [4,9,23,4]
Output: false
Explanation:
After destroying the other asteroids, the planet has mass 22, which is less than 23.
```

## Constraints

- `1 <= mass <= 10^5`
- `1 <= asteroids.length <= 10^5`
- `1 <= asteroids[i] <= 10^5`
