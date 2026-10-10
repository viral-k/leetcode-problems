from typing import List


class Solution:
    def minSumSquareDiff(self, nums1: List[int], nums2: List[int], k1: int, k2: int) -> int:
        """
        2333. Minimum Sum of Squared Difference
        Time: O(n + V) where V = max difference
        Space: O(V)
        """
        diffs = [abs(a - b) for a, b in zip(nums1, nums2)]
        budget = k1 + k2  # an op on either array moves one difference by 1

        if sum(diffs) <= budget:
            return 0

        top = max(diffs)
        cnt = [0] * (top + 1)
        for d in diffs:
            cnt[d] += 1

        # cutting the largest value saves 2v-1, the most available, so sweep
        # down moving whole buckets while the budget covers them
        for v in range(top, 0, -1):
            if cnt[v] == 0:
                continue
            if budget >= cnt[v]:
                budget -= cnt[v]
                cnt[v - 1] += cnt[v]
                cnt[v] = 0
            else:
                cnt[v] -= budget
                cnt[v - 1] += budget
                break

        return sum(v * v * c for v, c in enumerate(cnt) if c)
