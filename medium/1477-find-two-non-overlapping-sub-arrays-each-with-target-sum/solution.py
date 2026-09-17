from typing import List


class Solution:
    def minSumOfLengths(self, arr: List[int], target: int) -> int:
        """
        1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
        Time: O(n)
        Space: O(n)
        """
        n = len(arr)
        INF = float("inf")
        # best[i] = shortest target-sum subarray ending at index <= i
        best = [INF] * n
        cur_best = INF
        answer = INF

        left = 0
        window = 0
        for right in range(n):
            window += arr[right]
            # all values positive, so shrinking from the left is monotone
            while window > target:
                window -= arr[left]
                left += 1

            if window == target:
                length = right - left + 1
                if left > 0 and best[left - 1] != INF:
                    answer = min(answer, length + best[left - 1])
                cur_best = min(cur_best, length)

            best[right] = cur_best

        return -1 if answer == INF else answer
