from collections import defaultdict, deque
from typing import List


class Solution:
    def minJumps(self, nums: List[int]) -> int:
        """
        3629. Minimum Jumps to Reach End via Prime Teleportation
        Time: O(M log log M + n log M), M = max(nums)
        Space: O(M + n log M)
        """
        n = len(nums)
        if n == 1:
            return 0

        max_value = max(nums)
        spf = self._build_spf(max_value)
        prime_sources = {num for num in nums if self._is_prime(num, spf)}

        teleports = defaultdict(list)
        for i, num in enumerate(nums):
            for factor in self._prime_factors(num, spf):
                if factor in prime_sources:
                    teleports[factor].append(i)

        distance = [-1] * n
        distance[0] = 0
        queue = deque([0])

        while queue:
            i = queue.popleft()
            next_distance = distance[i] + 1

            for nei in (i - 1, i + 1):
                if 0 <= nei < n and distance[nei] == -1:
                    if nei == n - 1:
                        return next_distance
                    distance[nei] = next_distance
                    queue.append(nei)

            value = nums[i]
            if value in prime_sources:
                for nei in teleports[value]:
                    if nei != i and distance[nei] == -1:
                        if nei == n - 1:
                            return next_distance
                        distance[nei] = next_distance
                        queue.append(nei)
                teleports[value].clear()

        return distance[n - 1]

    def _build_spf(self, max_value: int) -> List[int]:
        spf = list(range(max_value + 1))
        if max_value >= 0:
            spf[0] = 0
        if max_value >= 1:
            spf[1] = 1

        factor = 2
        while factor * factor <= max_value:
            if spf[factor] == factor:
                for multiple in range(factor * factor, max_value + 1, factor):
                    if spf[multiple] == multiple:
                        spf[multiple] = factor
            factor += 1

        return spf

    def _is_prime(self, num: int, spf: List[int]) -> bool:
        return num >= 2 and spf[num] == num

    def _prime_factors(self, num: int, spf: List[int]) -> List[int]:
        factors = []

        while num > 1:
            factor = spf[num]
            factors.append(factor)
            while num % factor == 0:
                num //= factor

        return factors
