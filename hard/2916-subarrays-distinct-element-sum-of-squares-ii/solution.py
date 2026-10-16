from typing import List


class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        """
        2916. Subarrays Distinct Element Sum of Squares II
        Time: O(n log n)
        Space: O(n)
        """
        MOD = 10**9 + 7
        n = len(nums)

        # Fenwick pair giving range-add / range-sum over D, where
        # D[i] = distinct count of nums[i..j] for the current right end j.
        # These hold exact counts, never residues: the sums feed a
        # multiplication by 2 that has to match the true values.
        tree1 = [0] * (n + 2)
        tree2 = [0] * (n + 2)

        def add(tree: List[int], i: int, delta: int) -> None:
            while i <= n:
                tree[i] += delta
                i += i & -i

        def prefix(i: int) -> int:
            s1 = s2 = 0
            x = i
            while x > 0:
                s1 += tree1[x]
                s2 += tree2[x]
                x -= x & -x
            return s1 * i - s2

        def range_add(lo: int, hi: int) -> None:  # 1-indexed, inclusive, +1
            add(tree1, lo, 1)
            add(tree1, hi + 1, -1)
            add(tree2, lo, lo - 1)
            add(tree2, hi + 1, -hi)

        last = {}
        squares = 0  # sum of D[i]^2 over the active prefix
        answer = 0

        for j, v in enumerate(nums):
            left = last.get(v, -1) + 1  # counts rise exactly on [left, j]
            width = j - left + 1

            # read the old D values before incrementing them
            before = prefix(j + 1) - (prefix(left) if left else 0)
            # (d + 1)^2 = d^2 + 2d + 1, summed over `width` indices
            squares = (squares + 2 * before + width) % MOD

            range_add(left + 1, j + 1)
            last[v] = j
            answer = (answer + squares) % MOD

        return answer
