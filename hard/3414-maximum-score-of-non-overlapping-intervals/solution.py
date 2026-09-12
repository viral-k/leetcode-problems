from typing import List
from bisect import bisect_right


class Solution:
    def maximumWeight(self, intervals: List[List[int]]) -> List[int]:
        """
        3414. Maximum Score of Non-overlapping Intervals
        Time: O(n log n)
        Space: O(n)
        """
        n = len(intervals)
        order = sorted(range(n), key=lambda i: intervals[i][0])
        lefts = [intervals[i][0] for i in order]

        # nxt[p] = first sorted position whose left endpoint is strictly past r_p;
        # strict because intervals sharing a boundary still overlap
        nxt = [bisect_right(lefts, intervals[order[p]][1]) for p in range(n)]

        # dp[p][k] = (score, sorted tuple of original indices) for positions >= p
        dp = [[(0, ())] * 5 for _ in range(n + 1)]

        for p in range(n - 1, -1, -1):
            idx = order[p]
            weight = intervals[idx][2]
            for k in range(1, 5):
                best = dp[p + 1][k]                       # skip this interval
                sub_score, sub_idx = dp[nxt[p]][k - 1]    # take it, jump past conflicts
                cand = (sub_score + weight, tuple(sorted(sub_idx + (idx,))))
                # higher score wins; ties go to the lexicographically smaller indices
                if (-cand[0], cand[1]) < (-best[0], best[1]):
                    best = cand
                dp[p][k] = best

        return list(dp[0][4][1])
